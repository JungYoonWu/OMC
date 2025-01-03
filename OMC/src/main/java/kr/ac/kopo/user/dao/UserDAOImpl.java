package kr.ac.kopo.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.TransferHandler;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.user.vo.DoctorVO;
import kr.ac.kopo.user.vo.UserVO;

public class UserDAOImpl implements UserDAO{

	private SqlSession sqlSession;
	
	public UserDAOImpl() {
		sqlSession = new MyConfig().getInstance();
	}

	@Override
	public List<UserVO> selectAllUser() throws Exception {
		sqlSession.clearCache();
		List<UserVO> userList = sqlSession.selectList("dao.UserDAO.selectAllUser");
		return userList;
	}

	@Override
	public UserVO selectUserByUserID(String userID) throws Exception {
		sqlSession.clearCache();
		UserVO userVO = sqlSession.selectOne("dao.UserDAO.selectUserByUserID",userID);
		return userVO;
	}
	
	@Override
	public List<UserVO> selectUserByType(String roleName) throws Exception {
		sqlSession.clearCache();
		List<UserVO> userList = sqlSession.selectList("dao.UserDAO.selectUserByType", roleName);
		return userList;
	}

	@Override
	public UserVO selectUserLogin(String userID, String password) throws Exception {
		sqlSession.clearCache();
		Map<String, Object> params = new HashMap<>();
		params.put("userID", userID);
		params.put("password", password);
		UserVO userVO = sqlSession.selectOne("dao.UserDAO.selectUserLogin", params);
		if(userVO != null) {
			System.out.println("DAO에서 가지고온 UserVO: " + userVO.toString());
		}else {
			System.out.println("로그인된 값이 없습니다.");
		}
		return userVO;
	}

	@Override
	public boolean insertPatientUser(UserVO userVO) throws Exception {
		try {
			sqlSession.insert("dao.UserDAO.insertPatientUser", userVO);
			sqlSession.commit();
			return true;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		}
	}

	@Override
	public List<UserVO> selectDoctorsByWorkDay(String workDay) throws Exception {
		sqlSession.clearCache();
		return sqlSession.selectList("dao.UserDAO.selectDoctorsByWorkDay", workDay);
	}

	@Override
	public List<UserVO> selectUserByType(int roleID) throws Exception {
		sqlSession.clearCache();
		List<UserVO> userList = sqlSession.selectList("dao.UserDAO.selectUserByRoleID", roleID);
		return userList;
	}

	@Override
	public List<DoctorVO> selectDoctors(int roleID) throws Exception {
		sqlSession.clearCache();
		List<DoctorVO> doctors = sqlSession.selectList("dao.UserDAO.selectDoctors", roleID);
		return doctors; 
	}
	
	
}
