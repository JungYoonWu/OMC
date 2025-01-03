package kr.ac.kopo.controller.boardQnA;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardQnA.service.BoardInquiryService;
import kr.ac.kopo.boardQnA.service.InquiryService;
import kr.ac.kopo.boardQnA.service.ReplyService;
import kr.ac.kopo.boardQnA.service.ReplyServiceImpl;
import kr.ac.kopo.boardQnA.vo.InquiryVO;
import kr.ac.kopo.boardQnA.vo.ReplyVO;
import kr.ac.kopo.controller.Controller;

public class InquiryDetailController implements Controller {

	private InquiryService inquiryService;
	private ReplyService replyService;
	
	public InquiryDetailController() {
		inquiryService = new BoardInquiryService();
		replyService = new ReplyServiceImpl();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = request.getParameter("userID");
		System.out.println("파라미터로 전달받은 UserID:" + userID);
		int inquiryID = Integer.parseInt(request.getParameter("inquiryID"));
		System.out.println("파라미터로 전달받은 InquiryID:"+inquiryID);
		
		InquiryVO inquiryVO = inquiryService.searchInquiryByUserID(userID, inquiryID);
		request.setAttribute("inquiryVO", inquiryVO);
		
		ReplyVO replyVO = replyService.getReplyByInquiryID(inquiryID);
		request.setAttribute("replyVO", replyVO);
		
		return "/jsp/boardQnA/inquiryDetail.jsp";
	}

}
