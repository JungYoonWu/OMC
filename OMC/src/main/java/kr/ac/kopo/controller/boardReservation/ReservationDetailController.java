package kr.ac.kopo.controller.boardReservation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardReservation.service.BoardReservationService;
import kr.ac.kopo.boardReservation.service.ReservationService;
import kr.ac.kopo.boardReservation.vo.ReservationVO;
import kr.ac.kopo.controller.Controller;

public class ReservationDetailController implements Controller{

	private ReservationService boardService;
	
	public ReservationDetailController() {
		boardService = new BoardReservationService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int reservationID = Integer.parseInt(request.getParameter("reservationID"));
		
		ReservationVO reservationVO = boardService.searchReservationByReservationID(reservationID);
		if(reservationVO == null) {
			System.out.println("예약객체가 비어있읍니다.");
		}
		request.setAttribute("reservationVO", reservationVO);
		
		return "/jsp/boardReservation/reservationDetail.jsp";
	}

	
}
