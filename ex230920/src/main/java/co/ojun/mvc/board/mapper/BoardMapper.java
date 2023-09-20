package co.ojun.mvc.board.mapper;

import java.util.List;

import co.ojun.mvc.board.service.BoardVO;

public interface BoardMapper {
	// 전체 조회
	public List<BoardVO> selectAll();

	// 단건 조회 : 조건 1) 글번호 2) 특정작가와 글번호
	public BoardVO selectOne(BoardVO boardVO);

	// 등록 : 1) 필수(not null)와 옵션을 구분 2) bno 자동부여 
	public int insert(BoardVO boardVO);

	// 수정 : 대상 ( 제목 or 내용 or 이미지 or 수정날짜)
	//   -> 이미지는 빈값도 허용, 수정날짜는 어떤 경우에도 반드시 		
	public int update(BoardVO boardVO);

	// 삭제
	public int delete(int bno);
}
