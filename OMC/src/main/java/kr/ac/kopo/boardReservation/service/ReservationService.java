package kr.ac.kopo.boardReservation.service;

import java.util.List;

import kr.ac.kopo.boardReservation.vo.ReservationVO;

public interface ReservationService {
	
	/**
	 * 전체예약목록을 보여주는 메소드
	 * @return
	 * @throws Exception
	 */
	List<ReservationVO> searchAllReservation() throws Exception;

	
	/**
	 * 현제날짜 기주능로 1주일 예약목록을 보여주는 메소드
	 * @return
	 * @throws Exception
	 */
	List<ReservationVO> searchWeekReservation() throws Exception;
	
	
	/**
	 * 파라미터로 전달된 userID의 예약내용을 보여주는 메소드
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	ReservationVO searchReservationByReservationID(int reservationID) throws Exception;

	/**
	 * 예약하는 메소드
	 */
	void addReservation(ReservationVO reservationVO) throws Exception;
	
	
	/**
	 * 자신이 예약한 예약내용을 보여주는 메소드
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	List<ReservationVO> searchMyReservation(String userID) throws Exception;

	boolean checkReservationAvailability(String doctorID, String reservationTime) throws Exception;
	
	void updateReservationStatus(int reservationID, String status) throws Exception;

	int selectBedIDByReservationID(int reservationID) throws Exception;
	
	List<ReservationVO> searchAllReservationByPaging(int page, int size) throws Exception;
	
	boolean checkDoubleReservation(String userID, String reservationDate) throws Exception;


	int countAllReservation() throws Exception;
}
