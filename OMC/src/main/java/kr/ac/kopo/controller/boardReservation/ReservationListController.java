package kr.ac.kopo.controller.boardReservation;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.boardReservation.service.BoardReservationService;
import kr.ac.kopo.boardReservation.service.ReservationService;
import kr.ac.kopo.boardReservation.vo.ReservationVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.vo.UserVO;

public class ReservationListController implements Controller{

	private ReservationService reservationService;
	
	public ReservationListController() {
		reservationService = new BoardReservationService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		UserVO loginVO = (UserVO) session.getAttribute("loginVO");
		
		String pageStr = request.getParameter("page");
		String sizeStr = request.getParameter("size");
		int page = (pageStr == null) ? 1 : Integer.parseInt(pageStr);
		int size = (sizeStr == null) ? 10 : Integer.parseInt(sizeStr);
		
		if(loginVO == null) {
			List<ReservationVO> reservationList = reservationService.searchWeekReservation();
			request.setAttribute("reservationList", reservationList);
			return "/jsp/boardReservation/reservationList.jsp";
		}else {
			//일반사용자(환자)
			if(loginVO.getRoleID() == 1) {
				String userID = loginVO.getUserID();
				System.out.println("로그인된ID:"+userID);
				List<ReservationVO> reservationList = reservationService.searchMyReservation(userID);
				request.setAttribute("reservationMyList", reservationList);
				return "/jsp/boardReservation/reservationList.jsp";	
			}else {
				//관리자 전체 예약 목록 페이징
//				List<ReservationVO> reservationList = reservationService.searchAllReservation();
//				request.setAttribute("reservationList", reservationList);
				
				List<ReservationVO> reservationList = reservationService.searchAllReservationByPaging(page, size);
				request.setAttribute("reservationList", reservationList);
				
				int totalCount = reservationService.countAllReservation();
				int totalPage = (int) Math.ceil((double)totalCount / size);
				
				request.setAttribute("totalPage", totalPage);
				request.setAttribute("currentPage", page);
				
				return "/jsp/boardReservation/reservationList.jsp";
			}
		}
	}
}
