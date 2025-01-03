package kr.ac.kopo.controller.boardReservation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardReservation.vo.ReservationVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.treatment.service.TreatmentService;
import kr.ac.kopo.treatment.service.TreatmentServiceImpl;
import kr.ac.kopo.treatment.vo.DoctorScheduleVO;
import kr.ac.kopo.user.vo.DoctorVO;

public class DoctorScheduleController implements Controller {

    private TreatmentService treatmentService;

    public DoctorScheduleController() {
        treatmentService = new TreatmentServiceImpl();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if ("getDoctors".equals(action)) {
            return getDoctors(request, response);
        } else if ("getTimeSlots".equals(action)) {
            return getTimeSlots(request, response);
        }
        // 기타 다른 액션 처리
        return null;
    }

    private String getDoctors(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String reservationDate = request.getParameter("reservationDate");

        if (reservationDate == null || reservationDate.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid reservationDate");
            return null;
        }

        // 예약 날짜의 요일 계산
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse(reservationDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String dayOfWeek = getDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));

        // 모든 의사를 가져온 후, 해당 요일에 근무하는 의사 필터링
        List<DoctorVO> allDoctors = treatmentService.getOMDoctors(); // 수정: List<DoctorVO> 반환
        List<DoctorVO> availableDoctors = new ArrayList<>();
        for (DoctorVO doctor : allDoctors) {
            List<DoctorScheduleVO> schedules = treatmentService.getDoctorSchedule(doctor.getOmdDoctorID(), dayOfWeek);
            if (schedules != null && !schedules.isEmpty()) {
                availableDoctors.add(doctor);
            }
        }
        
        // 디버깅을 위한 로그 추가
        for (DoctorVO doctor : availableDoctors) {
            System.out.println("Available Doctor: " + doctor.toString());
        }

        // JSON 변환
        Gson gson = new Gson();
        String json = gson.toJson(availableDoctors);

        // 응답 작성
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

        return null;
    }

    private String getTimeSlots(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String doctorIDParam = request.getParameter("doctorID"); // userID으로 변경
        System.out.println("doctorIDParam:"+doctorIDParam);
        String reservationDate = request.getParameter("reservationDate"); // format 'yyyy-mm-dd'

        // 입력 검증
        if (doctorIDParam == null || reservationDate == null || doctorIDParam.isEmpty() || reservationDate.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameters");
            return null;
        }
        // 예약 날짜의 요일 계산
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse(reservationDate);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DATE, 1); // 내일 날짜
        Date minDate = cal.getTime();
        
        if(date.before(minDate)) {
        	response.sendError(HttpServletResponse.SC_BAD_REQUEST, "예약 날짜는 오늘 이후여야 합니다.");
            return null;        	
        }
        
        int doctorID;
        try {
            doctorID = Integer.parseInt(doctorIDParam);//treatmentService.getDoctorIdByUserID(doctorIDParam);
        } catch (Exception e) {
            e.printStackTrace(); // 로그 추가
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching doctor ID");
            return null;
        }



        cal.setTime(date);
        String dayOfWeek = getDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));

        // 의사의 근무 일정 조회
        List<DoctorScheduleVO> schedules = treatmentService.getDoctorSchedule(doctorID, dayOfWeek);
        if (schedules == null || schedules.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "해당 의사의 근무 일정이 없습니다.");
            return null;
        }
        
        // 15분 단위 시간대 생성
        List<String> timeSlots = new ArrayList<>();
        for (DoctorScheduleVO schedule : schedules) {
            String startTimeStr = schedule.getWorkStartTime(); // 'HH:mm:ss'
            String endTimeStr = schedule.getWorkEndTime();     // 'HH:mm:ss'

            // 시간 파싱
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            java.util.Date startTime = timeFormat.parse(startTimeStr);
            java.util.Date endTime = timeFormat.parse(endTimeStr);

            Calendar startCalTime = Calendar.getInstance();
            startCalTime.setTime(startTime);
            Calendar endCalTime = Calendar.getInstance();
            endCalTime.setTime(endTime);

            while (startCalTime.before(endCalTime)) {
                String hour = String.format("%02d", startCalTime.get(Calendar.HOUR_OF_DAY));
                String minute = String.format("%02d", startCalTime.get(Calendar.MINUTE));
                timeSlots.add(hour + ":" + minute);
                startCalTime.add(Calendar.MINUTE, 15);
            }
        }

        // 중복 제거 및 정렬
        List<String> uniqueTimeSlots = new ArrayList<>();
        for (String slot : timeSlots) {
            if (!uniqueTimeSlots.contains(slot)) {
                uniqueTimeSlots.add(slot);
            }
        }
        uniqueTimeSlots.sort(null); // 자연 순서 정렬

        // 예약된 시간대 가져오기
        List<ReservationVO> reservations = treatmentService.searchTodayReservation(); // 오늘 예약 조회
        List<String> reservedTimes = new ArrayList<>();
        for (ReservationVO reservation : reservations) {
            if (reservation.getDoctorID() != null && reservation.getDoctorID() == doctorIDParam && reservation.getReservationDate().equals(reservationDate)) {
                String time = reservation.getReservationTime().substring(0, 5); // 'HH:mm'
                reservedTimes.add(time);
            }
        }

        // 예약된 시간대를 제외하거나 마킹
        List<Map<String, String>> availableTimeSlots = new ArrayList<>();
        for (String slot : uniqueTimeSlots) {
            Map<String, String> timeSlot = new HashMap<>();
            timeSlot.put("time", slot);
            if (reservedTimes.contains(slot)) {
                timeSlot.put("status", "reserved");
            } else {
                timeSlot.put("status", "available");
            }
            availableTimeSlots.add(timeSlot);
        }
//        List<String> availableTimeSlots = new ArrayList<>();
//        for (String slot : uniqueTimeSlots) {
//            if (!reservedTimes.contains(slot)) {
//                availableTimeSlots.add(slot);
//            }
//        }

        // JSON 변환
        Gson gson = new Gson();
        String json = gson.toJson(availableTimeSlots);

        // 응답 작성
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

        return null;
    }

    private String getDayOfWeek(int dayOfWeek) {
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            default:
                return "";
        }
    }
}
