package kr.ac.kopo.controller.index;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardHerbal.service.BoardHerbalService;
import kr.ac.kopo.boardHerbal.vo.HerbalVO;
import kr.ac.kopo.boardNotice.service.BoardNoticeService;
import kr.ac.kopo.boardNotice.vo.BoardNoticeVO;
import kr.ac.kopo.boardReservation.service.BoardReservationService;
import kr.ac.kopo.boardReservation.service.ReservationService;
import kr.ac.kopo.boardReservation.vo.ReservationVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.treatment.service.TreatmentService;
import kr.ac.kopo.treatment.service.TreatmentServiceImpl;
import kr.ac.kopo.user.vo.UserVO;

public class IndexController implements Controller{

	private BoardNoticeService boardNoticeService;
	private BoardHerbalService boardHerbalService;
	private TreatmentService treatmentService;
	public IndexController() {
		boardNoticeService = new BoardNoticeService();
		boardHerbalService = new BoardHerbalService();
		treatmentService = new TreatmentServiceImpl();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<BoardNoticeVO> boardNoticeList = boardNoticeService.searchAllBoard();
		List<HerbalVO> herbalSRList = boardHerbalService.searchHerbalBySR();
		List<ReservationVO> todayReservation = treatmentService.searchTodayReservation();
		request.setAttribute("boardNoticeList", boardNoticeList);
		System.out.println("index page에 등록된 boardNoticeList : " + boardNoticeList.toString());
		request.setAttribute("herbalSRList", herbalSRList);
		System.out.println("index page에 등록된 herbalSRList : " + herbalSRList.toString());
		request.getSession().setAttribute("todayReservation", todayReservation);
		if(todayReservation.isEmpty()) {
			System.out.println("금일 예약이 없습니다. 망했네");
		}else {
			System.out.println("index page에 등록된 todayReservation : "+ todayReservation.toString());			
		}

		return "/index.jsp";
	}
}
