package kr.ac.kopo.boardReservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.boardReservation.vo.ReservationVO;
import kr.ac.kopo.mybatis.MyConfig;

public class ReservationDAOImpl implements ReservationDAO {

	private SqlSession sqlSession;
	
	public ReservationDAOImpl() {
		sqlSession = new MyConfig().getInstance();
	}
	
	@Override
	public List<ReservationVO> selectAllReservation() throws Exception {
		sqlSession.clearCache();
		List<ReservationVO> reservationList = sqlSession.selectList("dao.ReservationDAO.selectAllReservation");
		System.out.println(reservationList.toString());
		return reservationList;
	}

	@Override
	public ReservationVO selectReservationByReservationID(int reservationID) throws Exception {
		sqlSession.clearCache();
		ReservationVO reservationVO = sqlSession.selectOne("dao.ReservationDAO.selectReservationByReservationID",reservationID);
		if(reservationVO == null) {
				System.out.println("reservationVO is null");
		}else{System.out.println(reservationVO.toString());
		}
		return reservationVO;
	}

	@Override
	public List<ReservationVO> selectWeekReservation() throws Exception {
		sqlSession.clearCache();
		List<ReservationVO> reservationList = sqlSession.selectList("dao.ReservationDAO.selectWeekReservation");
		System.out.println(reservationList.toString());
		return reservationList;
	}

	@Override
	public void insertReservation(ReservationVO reservationVO) throws Exception {
		try {
			sqlSession.insert("dao.ReservationDAO.insertReservation", reservationVO);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		}
	}

	@Override
	public List<ReservationVO> selectMyReservation(String userID) {
		sqlSession.clearCache();
		List<ReservationVO> reservationList = sqlSession.selectList("dao.ReservationDAO.selectMyReservation", userID);
		return reservationList;
	}

	@Override
	public boolean isReservationAvailable(String doctorID, String reservationTime) throws Exception {
		sqlSession.clearCache();
		Map<String, Object> params = new HashMap<>();
		params.put("doctorID", doctorID);
		System.out.println("예약확인을 위한 doctorID="+doctorID);
		params.put("reservationTime", reservationTime);
		System.out.println("예약확인을위한 reservationTime="+reservationTime);
		int count = sqlSession.selectOne("dao.ReservationDAO.countReservations", params);
		System.out.println("sqlSession했을때 나오는 결과 수 count="+count);
		return count == 0;
	}

	@Override
	public void updateReservationStatus(int reservationID, String status) throws Exception {
		sqlSession.clearCache();
		Map<String, Object> params = new HashMap<>();
		params.put("reservationID", reservationID);
		params.put("status", status);
		sqlSession.update("dao.ReservationDAO.updateReservationStatus", params);
		sqlSession.commit();
	}

	@Override
	public void updateReservationBedID(int reservationID, int bedID) throws Exception {
		System.out.println("updateReservationBedID()호출: reservationID=" + reservationID + ", bedID="+bedID);
		
		sqlSession.clearCache();
		Map<String, Object> params = new HashMap<>();
		params.put("reservationID", reservationID);
		params.put("bedID", bedID);
		params.put("status", "ING");
		int updateCount = sqlSession.update("dao.ReservationDAO.updateReservationBedID", params);
		if(updateCount != 0) {
			System.out.println("updateReservationBedID() DB update row count=" + updateCount);
		}else {
			System.out.println("updateReservationBedID()로 바뀐 컬럼이 없습니다.");
		}
		sqlSession.commit();
	}

	@Override
	public int selectBedIDByReservationID(int reservationID) throws Exception {
		sqlSession.clearCache();
		Integer bedID = sqlSession.selectOne("dao.ReservationDAO.selectBedIDByReservationID", reservationID);
		return bedID != null ? bedID : 0;
	}

	@Override
	public boolean isDoubleReservation(String userID, String reservationDate) {
		sqlSession.clearCache();
		Map<String, Object> params = new HashMap<>();
		params.put("userID", userID);
		params.put("reservationDate", reservationDate);
		int dr = sqlSession.selectOne("dao.ReservationDAO.checkIsDoubleReservation", params);
		return dr != 0;
	}

	@Override
	public int countAllReservation() throws Exception {
		sqlSession.clearCache();
		int totalCount = sqlSession.selectOne("dao.ReservationDAO.countAllReservation");
		return totalCount;
	}

	@Override
	public List<ReservationVO> selectAllReservationByPaging(Map<String, Object> param) throws Exception {
		sqlSession.clearCache();
		List<ReservationVO> list = sqlSession.selectList("dao.ReservationDAO.selectAllReservationByPaging", param);
		return list;
	}
	
	
}
