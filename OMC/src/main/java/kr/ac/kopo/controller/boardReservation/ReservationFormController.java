package kr.ac.kopo.controller.boardReservation;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.service.UserService;
import kr.ac.kopo.user.service.UserServiceImpl;
import kr.ac.kopo.user.vo.DoctorVO;

public class ReservationFormController implements Controller {

	private UserService userService;
	
	public ReservationFormController() {
		userService = new UserServiceImpl();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<DoctorVO> doctorList = userService.searchDoctors(2);
		System.out.println("한의사 : " + doctorList.toString());
		request.setAttribute("doctorList", doctorList);
		
		return "/jsp/boardReservation/reservationForm.jsp";
	}

}
