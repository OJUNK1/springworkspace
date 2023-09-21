package co.ojun.mvc.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.ojun.mvc.board.service.BoardService;
import co.ojun.mvc.board.service.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	// 전체 조회 : URI - boardList / Return - board/boardList
	@GetMapping("boardList")
	public String selectAll(Model model) {
		List<BoardVO> list = boardService.getBoardList();

		model.addAttribute("boards", list);
		return "board/boardList";
	}

	// 단건 조회 : URI - boardInfo / Param - BoardVO / Return - board/boardInfo
	@GetMapping("boardInfo")
	public String selectOne(BoardVO boardVO, Model model) {
		BoardVO vo = boardService.getBoardInfo(boardVO);

		model.addAttribute("boards", vo);
		return "board/boardInfo";
	}

	// 등록 - 페이지 : URI - boardInsert / Return - board/boardInsert
	@GetMapping("boardInsert")
	public String insertForm(BoardVO boardVO, Model model) {
		// 등록 페이지를 호출할 때 미리 primary key를 보여야하는 경우, Model이 필요함.. 예시) 사원 등록 시, 등록 form에서
		// 자동으로 부여되는 사원번호가 미리 보여야하기 model을 써야 한다.
		List<BoardVO> vo = boardService.getBoardList();
		int lastIdx = vo.size() - 1;
		
		BoardVO lastBoard = vo.get(lastIdx);
		
		String lastBoardNo = String.format("%03d",Integer.valueOf(lastBoard.getBno()) + 1);

		boardVO.setBno(lastBoardNo);
		System.out.println(lastBoardNo);
		model.addAttribute("bno", lastBoardNo);
		
		return "board/boardInsert";
	}

	// 등록 - 처리 : URI - boardInsert / Parameter - BoardVO / Return - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String insert(BoardVO boardVO, RedirectAttributes attributes) {
		boardService.insertBoardInfo(boardVO);
		return "redirect:boardList";

	}

	// 수정 - 페이지 : URI - boardUpdate / Parameter - BoardVO / Return -
	// board/boardUpdate
	@GetMapping("boardUpdate")
	public String updateForm(BoardVO boardVO, Model model) {
		BoardVO vo = boardService.getBoardInfo(boardVO);
		model.addAttribute("boards", vo);
		return "board/boardUpdate";
	}

	// 수정 - 처리 : URI - boardUpdate / Parameter - BoardVO / Return - 실행결과(Data) /
	// RequestBody는 붙여도 되고, 안 붙여도 됨. 붙이는 경우 json으로, 안 붙이면 query String.
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> update(@RequestBody BoardVO boardVO) {
		Map<String, Object> map = new HashMap<>();

		int boardNo = boardService.updateBoardInfo(boardVO);

		String result = null;

		if (boardNo == -1) {
			result = "수정 실패";
			map.put("result", result);

		} else {
			result = "수정 성공, " + "변경된 게시판의 번호는 " + boardNo + "입니다.";
			map.put("bno", boardNo);
			map.put("result", result);
		}
		return map;
	}

	// 삭제 - 처리 : URI - boardDelete / Parameter - bno / Return - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String delete(@RequestParam("bno") Integer bno, RedirectAttributes attr) {
		boardService.deleteBoardInfo(bno);
		return "redirect:boardList";

	}
}
