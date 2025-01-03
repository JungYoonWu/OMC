package kr.ac.kopo.controller.boardQnA;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardQnA.service.BoardInquiryService;
import kr.ac.kopo.boardQnA.service.InquiryService;
import kr.ac.kopo.boardQnA.vo.InquiryVO;
import kr.ac.kopo.controller.Controller;

public class InquiryProcessController implements Controller {

	private InquiryService inquiryService;
	
	public InquiryProcessController() {
		inquiryService = new BoardInquiryService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = request.getParameter("userID");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("문의등록을위해 전달받은 Parameter" + userID + title + content);
		InquiryVO inquiryVO = new InquiryVO(userID, title, content);
		inquiryService.addInquiry(inquiryVO);
		List<InquiryVO> inquiryMyList = inquiryService.searchAllInquiry(userID);
		request.setAttribute("inquiryMyList", inquiryMyList);
		return "/jsp/boardQnA/inquiryList.jsp";
	}

}
