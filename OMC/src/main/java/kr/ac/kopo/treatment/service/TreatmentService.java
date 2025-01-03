package kr.ac.kopo.treatment.service;

import java.util.List;

import kr.ac.kopo.boardReservation.vo.ReservationVO;
import kr.ac.kopo.treatment.vo.DoctorScheduleVO;
import kr.ac.kopo.treatment.vo.DoctorTimelineVO;
import kr.ac.kopo.treatment.vo.TreatmentRoomStatusVO;
import kr.ac.kopo.user.vo.DoctorVO;
import kr.ac.kopo.user.vo.UserVO;

public interface TreatmentService {

	public List<DoctorTimelineVO> getDoctorTimeline() throws Exception;
	
	public List<TreatmentRoomStatusVO> getTreatmentRoomStatus() throws Exception;

	public List<ReservationVO> searchTodayReservation() throws Exception;

	public void updateBedStatus(int bedID, String status) throws Exception;
	
	public List<DoctorScheduleVO> getDoctorSchedule(int doctorID, String workDay) throws Exception;

	public List<UserVO> getAllDoctors() throws Exception;
	
	public List<DoctorVO> getOMDoctors() throws Exception;
	
	public TreatmentRoomStatusVO assignedBedToReservation(ReservationVO reservation) throws Exception;
	
	public void updateBedStatusByReservation(int reservationID, String status) throws Exception;

	public List<TreatmentRoomStatusVO> getEmptyBeds() throws Exception;
	
	public TreatmentRoomStatusVO getEmptyBed() throws Exception;

	public int getDoctorIdByUserID(String userID) throws Exception;
	
	public String getUserIdByDoctorId(int omdDoctorID) throws Exception;

	public TreatmentRoomStatusVO getTreatmentRoomStatusByBedID(int bedID) throws Exception;
	
}
