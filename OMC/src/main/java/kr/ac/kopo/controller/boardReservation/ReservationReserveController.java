package kr.ac.kopo.controller.boardReservation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardReservation.service.BoardReservationService;
import kr.ac.kopo.boardReservation.service.ReservationService;
import kr.ac.kopo.boardReservation.vo.ReservationVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.treatment.service.TreatmentService;
import kr.ac.kopo.treatment.service.TreatmentServiceImpl;
import kr.ac.kopo.user.vo.UserVO;

public class ReservationReserveController implements Controller {

    private ReservationService reservationService;
    private TreatmentService treatmentService;

    public ReservationReserveController() {
        reservationService = new BoardReservationService();
        treatmentService = new TreatmentServiceImpl();
    }
    
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String userID = request.getParameter("userID");
        String reservationDate = request.getParameter("reservationDate");
        String reservationTime = request.getParameter("reservationTime");
        String omdDoctorIDStr = request.getParameter("doctorID"); // 의사 ID (String) 가져오기
        int omdDoctorID = Integer.parseInt(omdDoctorIDStr);
        int treatmentID = Integer.parseInt(request.getParameter("treatmentID"));

        String status = request.getParameter("status");
        if(status == null || status.isEmpty()) {
            status = "YES";
        }
        System.out.println("예약날짜: " + reservationDate);
        System.out.println("예약시간: " + reservationTime);
        System.out.println("선택한 의사ID: " + omdDoctorIDStr);
        
        String doctorUserID = treatmentService.getUserIdByDoctorId(omdDoctorID);
        System.out.println("해당 omdDoctorID의 userID:" + doctorUserID);
        
        // 예약 시간 형식 맞추기
        String combinedDateTime = reservationDate + " " + reservationTime + ":00";
        
        //동일날짜에 로그인한 유저의 예약이 있는지 확인
        UserVO loginVO = (UserVO) request.getSession().getAttribute("loginVO");
        boolean isDoubleReservation = reservationService.checkDoubleReservation(loginVO.getUserID(), reservationDate);
        if(isDoubleReservation) {
        	request.setAttribute("errorMessage", "동일날짜에 예약이 존재합니다.");
        	return "/jsp/boardReservation/reservationForm.jsp";
        }
        
        // 동일 의사와 시간에 예약이 있는지 확인
        boolean isAvailable = reservationService.checkReservationAvailability(doctorUserID, combinedDateTime); // 이 함수도 작동안했는데 이유 체크해야됨
        if (!isAvailable) {
            // 예약 불가 시 오류 메시지 표시
            request.setAttribute("errorMessage", "선택한 의사와 시간에 이미 예약이 있습니다.");
            return "/jsp/boardReservation/reservationForm.jsp";
            //redirect:/reservation/list.yoon
        }
        
        // ReservationVO 객체 생성 및 설정
        ReservationVO reservationVO = new ReservationVO();
        reservationVO.setUserID(userID);
        reservationVO.setReservationDate(reservationDate);
        reservationVO.setReservationTime(combinedDateTime);
        reservationVO.setStatus(status);
        reservationVO.setTreatmentID(treatmentID);
        reservationVO.setDoctorID(doctorUserID); // 의사 ID 설정 (String)
        
        // 예약 추가
        reservationService.addReservation(reservationVO);
        System.out.println("예약내용: " + reservationVO.toString());

        // 예약 목록 페이지로 리다이렉트
        return "redirect:/reservation/list.yoon";
    }
}
