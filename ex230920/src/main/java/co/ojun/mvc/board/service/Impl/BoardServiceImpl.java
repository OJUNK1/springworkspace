package co.ojun.mvc.board.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ojun.mvc.board.mapper.BoardMapper;
import co.ojun.mvc.board.service.BoardService;
import co.ojun.mvc.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> list = boardMapper.selectAll();
		return list;
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardMapper.selectOne(boardVO);
	}

	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		int result = boardMapper.insert(boardVO);

		if (result == 1) {
			return Integer.parseInt(boardVO.getBno());
		} else {
			return -1;
		}
	}

	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		int result = boardMapper.update(boardVO);

		if (result == 1) {
			return Integer.parseInt(boardVO.getBno());
		} else {
			return -1;
		}

	}

	@Override
	public int deleteBoardInfo(int boardNo) {

		int result = boardMapper.delete(boardNo);

		if (result == 1) {
			return boardNo;
		} else {
			return -1;
		}
	}

}
