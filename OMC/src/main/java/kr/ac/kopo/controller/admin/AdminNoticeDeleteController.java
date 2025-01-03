package kr.ac.kopo.controller.admin;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardNotice.service.BoardNoticeService;
import kr.ac.kopo.boardNotice.service.NoticeService;
import kr.ac.kopo.boardNotice.vo.BoardNoticeVO;
import kr.ac.kopo.controller.Controller;

public class AdminNoticeDeleteController implements Controller {
	
	private NoticeService noticeService;
	
	public AdminNoticeDeleteController() {
		noticeService = new BoardNoticeService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int noticeID = Integer.parseInt(request.getParameter("noticeID"));
		System.out.println("전달받은 공지사항 ID:" + noticeID);
		noticeService.deleteNotice(noticeID);
		List<BoardNoticeVO> boardNoticeList = noticeService.searchAllBoard();
//		request.removeAttribute("boardNoticeList");
		request.setAttribute("boardNoticeList", boardNoticeList);
		System.out.println("삭제후 request영역에 등록된 공지목록 : " + boardNoticeList);
		return "/jsp/boardNotice/noticelist.jsp";
	}

}
