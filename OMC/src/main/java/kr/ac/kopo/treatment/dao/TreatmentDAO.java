package kr.ac.kopo.treatment.dao;

import java.util.List;

import kr.ac.kopo.boardReservation.vo.ReservationVO;
import kr.ac.kopo.treatment.vo.DoctorScheduleVO;
import kr.ac.kopo.treatment.vo.DoctorTimelineVO;
import kr.ac.kopo.treatment.vo.TreatmentRoomStatusVO;
import kr.ac.kopo.user.vo.DoctorVO;
import kr.ac.kopo.user.vo.UserVO;

public interface TreatmentDAO {

	public List<TreatmentRoomStatusVO> getTreatmentRoomStatus() throws Exception;
	
	public List<DoctorTimelineVO> getDoctorTimeline() throws Exception;

	public List<ReservationVO> selectTodayReservation() throws Exception;

	public void updateBedStatus(int bedID, String status) throws Exception;

	public List<DoctorScheduleVO> selectDoctorSchedule(int doctorID, String workDay) throws Exception;

	public List<UserVO> selectAllDoctors() throws Exception;

	public List<DoctorVO> selectOMDoctors() throws Exception;
	
	public List<TreatmentRoomStatusVO> selectAllTreatmentRoomStatus() throws Exception;
	
	public TreatmentRoomStatusVO findEmptyBed() throws Exception;

	public List<TreatmentRoomStatusVO> getEmptyBeds() throws Exception;

	public int selectDoctorIdByUserID(String userID) throws Exception;

	public String selectUserIdByDoctorId(int omdDoctorID) throws Exception;

	public TreatmentRoomStatusVO selectTreatmentRoomStatusByBedID(int bedID) throws Exception;
	

//	int getDoctorIdByUserId(String userID) throws Exception;
}
