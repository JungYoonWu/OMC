package kr.ac.kopo.controller.boardQnA;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.boardQnA.service.BoardInquiryService;
import kr.ac.kopo.boardQnA.service.InquiryService;
import kr.ac.kopo.boardQnA.vo.InquiryVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.vo.UserVO;

public class InquiryListController implements Controller {

	private InquiryService inquiryService;
	
	public InquiryListController() {
		inquiryService = new BoardInquiryService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		UserVO loginVO = (UserVO) session.getAttribute("loginVO");
		
		String pageStr = request.getParameter("page");
		String sizeStr = request.getParameter("size");
		
		int page = (pageStr == null) ? 1 : Integer.parseInt(pageStr);
		int size = (sizeStr == null) ? 5 : Integer.parseInt(sizeStr) ;
		
		if(loginVO == null) {
			System.out.println("로그인된 사용자가 없습니다.");
			return "/jsp/boardQnA/inquiryList.jsp";
		}else {
			if(loginVO.getRoleID() == 1) {
				//일반사용자 로그인 자기 문의글 페이징처리
//				List<InquiryVO> inquiryList = inquiryService.searchAllInquiry(loginVO.getUserID());
//				request.setAttribute("inquiryMyList", inquiryList);
				
				List<InquiryVO> inquiryMyList = inquiryService.searchMyInquiryByPaging(loginVO.getUserID(), page, size);
				
				int totalCount = inquiryService.countMyInquiry(loginVO.getUserID());
				int totalPage = (int) Math.ceil((double) totalCount / size);
				
				request.setAttribute("inquiryMyList", inquiryMyList);
				request.setAttribute("currentPage", page);
				request.setAttribute("totalPage", totalPage);
				
				return "/jsp/boardQnA/inquiryList.jsp";
			}else {
				// 관리자 권한 로그인 전체 문의글
//				List<InquiryVO> inquiryList = inquiryService.searchAllInquiry();
//				request.setAttribute("inquiryList", inquiryList);
//				System.out.println(inquiryList.toString());
				
				List<InquiryVO> inquiryList = inquiryService.searchAllInquiryByPaging(page, size);
				
				int totalCount = inquiryService.countAllInquiry();
				int totalPage = (int) Math.ceil((double) totalCount / size);
				
				request.setAttribute("inquiryList", inquiryList);
				request.setAttribute("currentPage", page);
				request.setAttribute("totalPage", totalPage);
				
				return "/jsp/boardQnA/inquiryList.jsp";				
			}
		}
	}
}
