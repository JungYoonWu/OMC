package kr.ac.kopo.controller.boardQnA;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardQnA.service.ReplyService;
import kr.ac.kopo.boardQnA.service.ReplyServiceImpl;
import kr.ac.kopo.boardQnA.vo.ReplyVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.vo.UserVO;

public class InquiryReplyProcessController implements Controller {

	private ReplyService replyService;
	
	public InquiryReplyProcessController() {
		this.replyService = new ReplyServiceImpl();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int inquiryID = Integer.parseInt(request.getParameter("inquiryID"));
		String content = request.getParameter("content");
		String userID = request.getParameter("userID");
		
		UserVO adminVO = (UserVO) request.getSession().getAttribute("loginVO");
		String adminID = adminVO.getUserID();
		
		ReplyVO replyVO = new ReplyVO(inquiryID, adminID, content);
		replyService.addReply(replyVO);
		
//		String userID = request.getParameter("userID");
		return "/qna/detail.yoon?inquiryID=" + inquiryID + "&userID=" + userID;
	}

}
