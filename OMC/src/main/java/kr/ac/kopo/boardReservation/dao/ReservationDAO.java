package kr.ac.kopo.boardReservation.dao;

import java.util.List;
import java.util.Map;

import kr.ac.kopo.boardReservation.vo.ReservationVO;

public interface ReservationDAO {

	/**
	 * 예약된 전체 리스트를 반환하는 메소드
	 * @return
	 * @throws Exception
	 */
	List<ReservationVO> selectAllReservation() throws Exception;
	
	
	/**
	 * 예약된 예약중 현제날짜 기준으로 1주일예약을 보여주는 메소드
	 * @return
	 * @throws Exception
	 */
	List<ReservationVO> selectWeekReservation() throws Exception;
	
	
	/**
	 * 파라미터로 전달받은 아이디를 통해 예약날짜를 확인하는 메소드
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	ReservationVO selectReservationByReservationID(int reservationID) throws Exception;


	/**
	 * 예약추가하는 메소드
	 * @param reservationVO
	 * @throws Exception
	 */
	void insertReservation(ReservationVO reservationVO) throws Exception;

	
	/**
	 * 자신이 예약한 내용들을 보여주는 메소드
	 * @param userID
	 * @return
	 */
	List<ReservationVO> selectMyReservation(String userID) throws Exception;
	
	boolean isReservationAvailable(String doctorID, String reservationTime) throws Exception;
	
	void updateReservationStatus(int reservationID, String status) throws Exception;
	
	void updateReservationBedID(int reservationID, int bedID) throws Exception;
	
	int selectBedIDByReservationID(int reservationID) throws Exception;

	int countAllReservation() throws Exception;
	
	List<ReservationVO> selectAllReservationByPaging(Map<String, Object> param) throws Exception;
	
	boolean isDoubleReservation(String userID, String reservationDate);
}
