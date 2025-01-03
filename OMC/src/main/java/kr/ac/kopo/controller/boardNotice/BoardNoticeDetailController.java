package kr.ac.kopo.controller.boardNotice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardNotice.service.BoardNoticeService;
import kr.ac.kopo.boardNotice.vo.BoardNoticeVO;
import kr.ac.kopo.controller.Controller;

public class BoardNoticeDetailController implements Controller{

	private BoardNoticeService boardService;
	
	public BoardNoticeDetailController() {
		boardService = new BoardNoticeService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int noticeID = Integer.parseInt(request.getParameter("noticeID"));
		
		BoardNoticeVO boardNoticeVO = boardService.searchBoardByID(noticeID);
		request.setAttribute("boardNoticeVO", boardNoticeVO);
		return "/jsp/boardNotice/noticedetail.jsp";
	}
	
	
}
