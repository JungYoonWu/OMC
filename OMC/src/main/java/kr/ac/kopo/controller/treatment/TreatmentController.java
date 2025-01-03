package kr.ac.kopo.controller.treatment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardReservation.service.BoardReservationService;
import kr.ac.kopo.boardReservation.service.ReservationService;
import kr.ac.kopo.boardReservation.vo.ReservationVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.treatment.service.TreatmentService;
import kr.ac.kopo.treatment.service.TreatmentServiceImpl;
import kr.ac.kopo.treatment.vo.DoctorData;
import kr.ac.kopo.treatment.vo.DoctorScheduleVO;
import kr.ac.kopo.treatment.vo.TreatmentRoomStatusVO;
import kr.ac.kopo.user.service.UserService;
import kr.ac.kopo.user.service.UserServiceImpl;
import kr.ac.kopo.user.vo.UserVO;

/*
	/treatment/treatment.yoon 기본화면
	/reservation/getTreatmentRoomStatus.yoon?action=getTreatmentRoomStatus -> getTreatmentRoomStatus() (Ajax)
*/

public class TreatmentController implements Controller {

    private TreatmentService treatmentService;
    private ReservationService reservationService;
    private UserService userService;
    private Gson gson;
    
    public TreatmentController() {
        treatmentService = new TreatmentServiceImpl();
        reservationService = new BoardReservationService();
        userService = new UserServiceImpl();
        gson = new Gson();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        String action = request.getParameter("action");
        if ("getTreatmentRoomStatus".equals(action)) {
            // AJAX 요청에 대한 처리
            return getTreatmentRoomStatus(request, response);
        }

        // -------------------------------
        // 1. 오늘 요일 구하기
        // -------------------------------
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        String today = sdf1.format(new Date());
        System.out.println("오늘은 : " + today + " 입니다.");

        // -------------------------------
        // 2. 오늘 근무하는 의사 목록 가져오기
        // -------------------------------
        List<UserVO> doctorList = userService.getDoctorsByWorkDay(today);
        System.out.println("오늘 근무하는 의사목록 : " + doctorList);
        if (doctorList.isEmpty()) {
            System.out.println("근무하는 의사가 없습니다.");
        }

        // -------------------------------
        // 3. 오늘 예약 목록 가져오기
        // -------------------------------
        List<ReservationVO> todayReservation = treatmentService.searchTodayReservation();
        if (todayReservation.isEmpty()) {
            System.out.println("오늘 예약된 환자가 없습니다.");
        } else {
            System.out.println("오늘 예약 목록 : " + todayReservation);
        }

        // -------------------------------
        // 4. 의사별 예약 매핑 (doctorReservationMap)
        // -------------------------------
        Map<String, DoctorData> doctorReservationMap = makeDoctorReservationMap(doctorList, todayReservation);

        // -------------------------------
        // 5. 치료실 상태(침대목록) 가져오기
        // -------------------------------
        List<TreatmentRoomStatusVO> treatmentRoomStatusList = treatmentService.getTreatmentRoomStatus();
        System.out.println("Total beds fetched: " + treatmentRoomStatusList.size());

//        // -------------------------------
//        // 6. 비어있는 침대 찾기
//        // -------------------------------
//        List<TreatmentRoomStatusVO> emptyBeds = new ArrayList<>();
//        for (TreatmentRoomStatusVO bed : treatmentRoomStatusList) {
//            if (bed == null) continue;
//            System.out.printf("Bed ID: %d, Status: %s, Number: %d\n",
//                              bed.getBedID(), bed.getBedStatus(), bed.getBedNumber());
//            if ("empty".equalsIgnoreCase(bed.getBedStatus())) {
//                emptyBeds.add(bed);
//            }
//        }
//        System.out.println("Empty beds count: " + emptyBeds.size());

        // 세션에 저장된 (reservationID->bed) 매핑 가져오기
        Map<Integer, TreatmentRoomStatusVO> reservationBedMap = (Map<Integer, TreatmentRoomStatusVO>)
                request.getSession().getAttribute("reservationBedMap");
        if (reservationBedMap == null) {
            reservationBedMap = new HashMap<>();
        }

//        // -------------------------------
//        // 7. 예약 -> 침대 배정 로직
//        // -------------------------------
//        SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date now = new Date();
//
//        Iterator<TreatmentRoomStatusVO> bedIterator = emptyBeds.iterator();
//
//        for (UserVO doctor : doctorList) {
//            DoctorData doctorData = doctorReservationMap.get(doctor.getUserID());
//            if (doctorData == null) continue;
//
//            List<ReservationVO> reservations = doctorData.getReservations();
//            if (reservations == null) continue;
//
//            for (ReservationVO reservation : reservations) {
//                // 7-1) 이미 BED가 할당된( bedID != 0 ) 예약이거나, 이미 ING인 예약이면 "재할당" 막을 수도 있음
//                //      -> 아래는 "YES 상태인 예약"만 배정(=기존 ING면 건너뜀)
//                if (!"YES".equalsIgnoreCase(reservation.getStatus())) {
//                    // ING or DONE 등등이면 넘어감
//                    continue;
//                }
//
//                // 7-2) 예약시각이 현재시각 <= 조건일 때만 배정
//                Date rTime = null;
//                try {
//                    rTime = sdfDateTime.parse(reservation.getReservationTime());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                if (rTime == null) continue;
//                
//                if (now.getTime() >= rTime.getTime()) {
//                    // 7-3) 아직 배정 가능한 침대가 남아있는지 체크
//                    if (bedIterator.hasNext()) {
//                        TreatmentRoomStatusVO assignedBed = bedIterator.next();
//                        // assignedBedToReservation() 내부에서 bed status='ing', reservation status='ING' 반영
//                        // + DB updateReservationBedID(...) 호출
//                        TreatmentRoomStatusVO retBed = treatmentService.assignedBedToReservation(reservation);
//                        if (retBed != null) {
//                            // 로컬 map에도 반영
//                            reservationBedMap.put(reservation.getReservationID(), retBed);
//                        } else {
//                            System.out.println("비어있는 침대가 없습니다. 예약ID:" + reservation.getReservationID());
//                        }
//                    } else {
//                        // 더이상 빈침대가 없으면 대기처리 등
//                        System.out.println("더 이상 비어있는 침대가 없습니다. -> 대기목록 처리 로직(추가구현가능)");
//                    }
//                }
//            }
//        }

//        // 바뀐 reservationBedMap 세션에 다시 저장
//        request.getSession().setAttribute("reservationBedMap", reservationBedMap);

        // -------------------------------
        // 8. 최종 결과를 JSP로 전달
        // -------------------------------
        // 의사 목록
        request.setAttribute("doctorList", doctorList);

        // JSON 직렬화
        String todayReservationJson = gson.toJson(todayReservation);
        String reservationBedMapJson = gson.toJson(reservationBedMap);
        String doctorReservationMapJson = gson.toJson(doctorReservationMap);

        request.setAttribute("todayReservation", todayReservationJson);
        request.setAttribute("reservationBedMap", reservationBedMapJson);
        request.setAttribute("doctorReservationMapJson", doctorReservationMapJson);
        request.setAttribute("treatmentRoomStatusList", treatmentRoomStatusList);

        System.out.println("객체등록완료");

        return "/jsp/treatment/treatmentRoom.jsp"; // 기본 치료실 페이지
    }
    
    /*
     Ajax 에서 주기적으로 호출하는 메소드
     1) updateReservationStatuses()로 예약시간이 되어서 ING가 된 예약이 15분이 지나면 DONE으로 처리
     2) 예약/침대 상태 JSON변환
    */
    private String getTreatmentRoomStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 1. 현재시간 기준 예약 상태 업데이트 (ex. 15분 지났으면 DONE 처리 등)
        updateReservationStatuses();

        // 2. 치료실 침대 상태
        List<TreatmentRoomStatusVO> treatmentRoomStatusList = treatmentService.getTreatmentRoomStatus();

        // 3. 오늘 예약 목록
        List<ReservationVO> todayReservation = treatmentService.searchTodayReservation();

        // 4. 오늘 근무 의사 목록
        String todayDayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(new Date());
        List<UserVO> doctorList = userService.getDoctorsByWorkDay(todayDayOfWeek);
        System.out.println("오늘 근무하는 의사 목록: " + doctorList);

        // 5. 의사별 예약 매핑, 타임슬롯
        Map<String, DoctorData> doctorReservationMap = makeDoctorReservationMap(doctorList, todayReservation);
        Map<String, List<String>> doctorTimeSlotsMap = buildDoctorTimeSlotsMap(doctorList, todayDayOfWeek);

        // 6. 세션에 있던 (reservation->bed) 매핑 가져오기
        @SuppressWarnings("unchecked")
        Map<Integer, TreatmentRoomStatusVO> reservationBedMap =
            (Map<Integer, TreatmentRoomStatusVO>) request.getSession().getAttribute("reservationBedMap");
        if (reservationBedMap == null) {
            reservationBedMap = new HashMap<>();
        }

        //7. 예약시간이 된 예약환자를 침대에 배정후 status YES -> ING로 변경
        List<TreatmentRoomStatusVO> emptyBeds = new ArrayList<>();
        for (TreatmentRoomStatusVO bed : treatmentRoomStatusList) {
            if (bed != null && "empty".equalsIgnoreCase(bed.getBedStatus())) {
                emptyBeds.add(bed);
            }
        }
        Iterator<TreatmentRoomStatusVO> bedIterator = emptyBeds.iterator();

        SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();

        for (UserVO doctor : doctorList) {
            DoctorData doctorData = doctorReservationMap.get(doctor.getUserID());
            if (doctorData == null) continue;

            for (ReservationVO reservation : doctorData.getReservations()) {
                if ("YES".equalsIgnoreCase(reservation.getStatus())) {
                    // 예약 시각이 이미 지났으면 침대 배정
                    Date rTime = sdfDateTime.parse(reservation.getReservationTime());
                    if (now.getTime() >= rTime.getTime()) {
                        if (bedIterator.hasNext()) {
                            // assignedBedToReservation() = bed→'ing', reservation→'ING' DB 업데이트
                            TreatmentRoomStatusVO retBed = treatmentService.assignedBedToReservation(reservation);
                            if (retBed != null) {
                                reservationBedMap.put(reservation.getReservationID(), retBed);
                            } else {
                                System.out.println("비어있는 침대가 없습니다. 예약ID:" + reservation.getReservationID());
                            }
                        } else {
                            System.out.println("더 이상 비어있는 침대가 없습니다. (대기처리 등)");
                        }
                    }
                }
            }
        }
        
        // 8. JSON 응답 구성
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("treatmentRoomStatusList", treatmentRoomStatusList);
        responseMap.put("doctorReservationMap", doctorReservationMap);
        responseMap.put("reservationBedMap", reservationBedMap);
        responseMap.put("doctorTimeSlotsMap", doctorTimeSlotsMap);

        String jsonResponse = gson.toJson(responseMap);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);

        return null; // AJAX 이므로 JSP 이동 x
    }
    
    //의사 목록 + 예약목록으로 의사별 ReservationVO 리스트를 맵으로 생성 key=userID(의사의 userID), value=DoctorData(의사이름 + 예약목록)
    private Map<String, DoctorData> makeDoctorReservationMap(List<UserVO> doctorList, List<ReservationVO> reservationList) {
        Map<String, DoctorData> map = new HashMap<>();

        // 1) 의사 목록을 먼저 key로 세팅
        for (UserVO doc : doctorList) {
            // userID: test_doctor2, doc.getName(): "이국정"
            DoctorData docData = new DoctorData(doc.getName());
            map.put(doc.getUserID(), docData);
        }

        // 2) 오늘 예약 목록을 돌면서, 해당 doctorID에 매핑
        for (ReservationVO r : reservationList) {
            String docId = r.getDoctorID();
            if (map.containsKey(docId)) {
                map.get(docId).getReservations().add(r);
            } else {
                // 오늘 근무 x인 의사? or doctorID=null인 예약?
                // 예: docId가 null인 경우
                System.out.println("해당 doctorID가 오늘 근무하는 의사 목록에 없음: " + docId);
            }
        }
        return map;
    }
    
    //doctor_schedule table에서 workDay=todayDayOfWeek 에 해당하는 start end 조회 후 15분 간격 timeslot생성
    private Map<String, List<String>> buildDoctorTimeSlotsMap(List<UserVO> doctorList, String todayDayOfWeek) throws Exception {

        Map<String, List<String>> doctorTimeSlotsMap = new HashMap<>();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        for (UserVO doc : doctorList) {
            // doc.getUserID() => "test_doctor2"
            // -> omdoctor.doctor_id(정수) 찾기
            int omdDoctorID = treatmentService.getDoctorIdByUserID(doc.getUserID());

            // DB에서 doctor_schedule(work_day=todayDayOfWeek) 로 스케줄 조회
            List<DoctorScheduleVO> schedules = treatmentService.getDoctorSchedule(omdDoctorID, todayDayOfWeek);

            if (schedules == null || schedules.isEmpty()) {
                doctorTimeSlotsMap.put(doc.getUserID(), new ArrayList<>());
                continue;
            }

            
            Date earliest = null;
            Date latest   = null;
            for (DoctorScheduleVO sc : schedules) {
                Date start = timeFormat.parse(sc.getWorkStartTime()); 
                Date end   = timeFormat.parse(sc.getWorkEndTime());   
                if (earliest == null || start.before(earliest)) earliest = start;
                if (latest == null || end.after(latest)) latest = end;
            }
            // earliest~latest를 15분 단위로 쪼개
            List<String> slotList = new ArrayList<>();
            Calendar cal = Calendar.getInstance();
            cal.setTime(earliest);
            while (!cal.getTime().after(latest)) {
                String hhmm = String.format("%02d:%02d",
                        cal.get(Calendar.HOUR_OF_DAY),
                        cal.get(Calendar.MINUTE));
                slotList.add(hhmm);
                cal.add(Calendar.MINUTE, 15);
            }
            doctorTimeSlotsMap.put(doc.getUserID(), slotList);
        }
        return doctorTimeSlotsMap;
    }    

    
    private void updateReservationStatuses() throws Exception {
    	//전체예약리스트 가지고오기 -> 나중에 오늘예약만 가지고오는 Service, DAO쪽으로 변환해야함.ㅜㅁ ㅜ
        List<ReservationVO> reservations = reservationService.searchAllReservation();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //예약리스트 순회
        for (ReservationVO reservation : reservations) {
            try {
                Date reservationDate = sdf.parse(reservation.getReservationTime());
                long diff = now.getTime() - reservationDate.getTime();
                if (diff >= (15 * 60 * 1000) && "ING".equalsIgnoreCase(reservation.getStatus())) {
                    // 15분이 지나고 상태가 'ING'인 경우 'DONE'으로 변경
                    reservationService.updateReservationStatus(reservation.getReservationID(), "DONE");
                    // 침대 상태 업데이트 (완료)
                    treatmentService.updateBedStatusByReservation(reservation.getReservationID(), "empty");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
