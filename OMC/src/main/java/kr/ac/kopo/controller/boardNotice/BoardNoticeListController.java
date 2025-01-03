package kr.ac.kopo.controller.boardNotice;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardNotice.service.BoardNoticeService;
import kr.ac.kopo.boardNotice.vo.BoardNoticeVO;
import kr.ac.kopo.controller.Controller;

public class BoardNoticeListController implements Controller{
	
	private BoardNoticeService boardService;

	public BoardNoticeListController() {
		boardService = new BoardNoticeService();
	}

	@Override
	//반환값이 String인 이유는 JSP주소를 String으로 표현해서
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<BoardNoticeVO> boardNoticeList = boardService.searchAllBoard();
		for(BoardNoticeVO vo : boardNoticeList) {
			System.out.println("NoticeID: " + vo.getNoticeID());
		}
		request.setAttribute("boardNoticeList", boardNoticeList);
		
		//forward용 주소라서 contextPath 뒤를 뜻함
		return "/jsp/boardNotice/noticelist.jsp";
	}
	
}
