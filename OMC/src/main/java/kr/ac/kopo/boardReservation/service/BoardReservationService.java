package kr.ac.kopo.boardReservation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.ac.kopo.boardReservation.dao.ReservationDAO;
import kr.ac.kopo.boardReservation.dao.ReservationDAOImpl;
import kr.ac.kopo.boardReservation.vo.ReservationVO;

public class BoardReservationService implements ReservationService{

	private ReservationDAO reservationDao;
	
	public BoardReservationService() {
		reservationDao = new ReservationDAOImpl();
	}
	
	@Override
	public List<ReservationVO> searchAllReservation() throws Exception {
		List<ReservationVO> reservationList = reservationDao.selectAllReservation();
		return reservationList;
	}
	
	@Override
	public List<ReservationVO> searchWeekReservation() throws Exception {
		List<ReservationVO> reservationList = reservationDao.selectWeekReservation();
		return reservationList;
	}

	@Override
	public ReservationVO searchReservationByReservationID(int reservationID) throws Exception {
		ReservationVO reservationVO = reservationDao.selectReservationByReservationID(reservationID);
		return reservationVO;
	}

	@Override
	public void addReservation(ReservationVO reservationVO) throws Exception {
		reservationDao.insertReservation(reservationVO);
	}

	@Override
	public List<ReservationVO> searchMyReservation(String userID) throws Exception {
		List<ReservationVO> reservationVO = reservationDao.selectMyReservation(userID);
		return reservationVO;
	}

	@Override
	public boolean checkReservationAvailability(String doctorID, String reservationTime) throws Exception {
		return reservationDao.isReservationAvailable(doctorID, reservationTime);
	}

	@Override
	public void updateReservationStatus(int reservationID, String status) throws Exception {
		reservationDao.updateReservationStatus(reservationID, status);
	}

	@Override
	public int selectBedIDByReservationID(int reservationID) throws Exception {
		int result = reservationDao.selectBedIDByReservationID(reservationID);
		return result;
	}

	@Override
	public boolean checkDoubleReservation(String userID, String reservationDate) throws Exception {
		return reservationDao.isDoubleReservation(userID, reservationDate);
	}

	@Override
	public List<ReservationVO> searchAllReservationByPaging(int page, int size) throws Exception {
		int tatalCount = reservationDao.countAllReservation();
		
		int startRow = (page - 1) * size + 1;
		int endRow = page * size;
		
		Map<String, Object> param = new HashMap<>();
		param.put("startRow", startRow);
		param.put("endRow", endRow);
		
		List<ReservationVO> reservationList = reservationDao.selectAllReservationByPaging(param);
		return reservationList;
	}

	@Override
	public int countAllReservation() throws Exception {
		return reservationDao.countAllReservation();
	}	
	
	
}
