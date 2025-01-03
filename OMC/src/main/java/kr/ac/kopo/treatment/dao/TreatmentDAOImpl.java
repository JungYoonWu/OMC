package kr.ac.kopo.treatment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.boardReservation.vo.ReservationVO;
import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.treatment.vo.DoctorScheduleParam;
import kr.ac.kopo.treatment.vo.DoctorScheduleVO;
import kr.ac.kopo.treatment.vo.DoctorTimelineVO;
import kr.ac.kopo.treatment.vo.TreatmentRoomStatusVO;
import kr.ac.kopo.user.vo.DoctorVO;
import kr.ac.kopo.user.vo.UserVO;

public class TreatmentDAOImpl implements TreatmentDAO{

    private SqlSession sqlSession;

    public TreatmentDAOImpl() {
        sqlSession = new MyConfig().getInstance();
    }

    public List<TreatmentRoomStatusVO> getTreatmentRoomStatus() throws Exception{
    	sqlSession.clearCache();
    	return sqlSession.selectList("dao.TreatmentDAO.getTreatmentRoomStatus");
    }

    public List<DoctorTimelineVO> getDoctorTimeline() throws Exception{
    	sqlSession.clearCache();
    	return sqlSession.selectList("dao.TreatmentDAO.getDoctorTimeline");
    }

	@Override
	public List<ReservationVO> selectTodayReservation() throws Exception {
		sqlSession.clearCache();
		return sqlSession.selectList("dao.TreatmentDAO.selectTodayReservation");
	}
	
	@Override
	public List<DoctorScheduleVO> selectDoctorSchedule(int doctorID, String workDay) throws Exception {
		sqlSession.clearCache();
		DoctorScheduleParam param = new DoctorScheduleParam(doctorID, workDay);
		List<DoctorScheduleVO> scheduleList = sqlSession.selectList("dao.TreatmentDAO.selectDoctorSchedule", param);
		return scheduleList;
	}

	@Override
	public void updateBedStatus(int bedID, String status) throws Exception {
		sqlSession.clearCache();
		TreatmentRoomStatusVO bed = new TreatmentRoomStatusVO();
		bed.setBedID(bedID);
		bed.setBedStatus(status);
		sqlSession.update("dao.TreatmentDAO.updateBedStatus", bed);
		sqlSession.commit();
	}

	@Override
	public List<DoctorVO> selectOMDoctors() throws Exception {
	    sqlSession.clearCache();
	    List<DoctorVO> doctors = sqlSession.selectList("dao.TreatmentDAO.selectOMDoctors");
	    for (DoctorVO doctor : doctors) {
	        System.out.println("Fetched Doctor: " + doctor.toString());
	    }
	    return doctors;
	}


	@Override
	public List<UserVO> selectAllDoctors() throws Exception {
		sqlSession.clearCache();
		return sqlSession.selectList("dao.TreatmentDAO.selectAllDoctors");
	}

	@Override
	public List<TreatmentRoomStatusVO> selectAllTreatmentRoomStatus() throws Exception {
		sqlSession.clearCache();
		return sqlSession.selectList("dao.TreatmentDAO.selectAllTreatmentRoomStatus");
	}

	@Override
	public TreatmentRoomStatusVO findEmptyBed() throws Exception {
		sqlSession.clearCache();
		return sqlSession.selectOne("dao.TreatmentDAO.findEmptyBed");
	}

	@Override
	public List<TreatmentRoomStatusVO> getEmptyBeds() throws Exception {
		sqlSession.clearCache();
		return sqlSession.selectList("dao.TreatmentDAO.selectEmptyBeds");
	}

	@Override
	public int selectDoctorIdByUserID(String userID) throws Exception {
		sqlSession.clearCache();
		return sqlSession.selectOne("dao.TreatmentDAO.selectDoctorIdByUserID", userID);
	}

	@Override
	public String selectUserIdByDoctorId(int omdDoctorID) throws Exception {
		sqlSession.clearCache();
		return sqlSession.selectOne("dao.TreatmentDAO.selectUserIdByDoctorId", omdDoctorID);
	}

	@Override
	public TreatmentRoomStatusVO selectTreatmentRoomStatusByBedID(int bedID) throws Exception {
		sqlSession.clearCache();
		return sqlSession.selectOne("dao.TreatmentDAO.selectTreatmentRoomStatusByBedID", bedID);
	}
	
	
}
