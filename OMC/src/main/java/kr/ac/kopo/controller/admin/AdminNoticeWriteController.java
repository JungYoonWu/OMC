package kr.ac.kopo.controller.admin;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardNotice.service.BoardNoticeService;
import kr.ac.kopo.boardNotice.service.NoticeService;
import kr.ac.kopo.boardNotice.vo.BoardNoticeVO;
import kr.ac.kopo.controller.Controller;

public class AdminNoticeWriteController implements Controller {

	private NoticeService noticeService;
	
	public AdminNoticeWriteController() {
		noticeService = new BoardNoticeService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("공지등록 제목, 내용" + title+content);
		
		BoardNoticeVO boardNoticeVO = new BoardNoticeVO();
		boardNoticeVO.setTitle(title);
		boardNoticeVO.setContent(content);
		
		noticeService.addNotice(boardNoticeVO);
		List<BoardNoticeVO> boardNoticeList = noticeService.searchAllBoard();
		request.setAttribute("boardNoticeList", boardNoticeList);
		System.out.println("공지등록후 등록된 공지목록: " +boardNoticeList.toString());
		return "/jsp/boardNotice/noticelist.jsp";
	}

}
