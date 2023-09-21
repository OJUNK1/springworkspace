package co.ojun.mvc;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.ojun.mvc.board.mapper.BoardMapper;
import co.ojun.mvc.board.service.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/database-context.xml")
public class BoardMapperTest {
	@Autowired
	BoardMapper boardMapper;
	
	@Test
	public void 전체조회() {
		List<BoardVO> boardList = boardMapper.selectAll();
		assertNotNull(boardList);
	}
}
