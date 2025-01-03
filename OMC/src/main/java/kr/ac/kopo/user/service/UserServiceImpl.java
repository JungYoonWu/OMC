package kr.ac.kopo.user.service;

import java.util.List;

import kr.ac.kopo.user.dao.UserDAO;
import kr.ac.kopo.user.dao.UserDAOImpl;
import kr.ac.kopo.user.vo.DoctorVO;
import kr.ac.kopo.user.vo.UserVO;

public class UserServiceImpl implements UserService{
	
	private UserDAO userDao;

	public UserServiceImpl() {
		userDao = new UserDAOImpl();
	}
	
	public List<UserVO> searchAllUser() throws Exception{
		List<UserVO> userList = userDao.selectAllUser();
		return userList;
	}

	@Override
	public UserVO searchUserByUserID(String userID) throws Exception {
		UserVO userVO = userDao.selectUserByUserID(userID);
		return userVO;
	}

	@Override
	public UserVO loginProcess(String userID, String password) throws Exception {
		UserVO userVO = userDao.selectUserLogin(userID, password);
		return userVO;
	}

	@Override
	public List<UserVO> searchUserByRoleName(String roleName) throws Exception {
		List<UserVO> userList = userDao.selectUserByType(roleName);
		return userList;
	}

	@Override
	public boolean signUpProcess(UserVO userVO) throws Exception {
		
		UserVO existUser = userDao.selectUserByUserID(userVO.getUserID());
		if(existUser != null) {
			System.out.println("중복된 아이디로 가입신청했습니다.");
			return false;
		}
		return userDao.insertPatientUser(userVO);
	}

	@Override
	public List<UserVO> getDoctorsByWorkDay(String workDay) throws Exception {
		return userDao.selectDoctorsByWorkDay(workDay);
	}

	@Override
	public List<DoctorVO> searchDoctors(int roleID) throws Exception {
		List<DoctorVO> doctorList = userDao.selectDoctors(roleID);
		return doctorList;
	}

	@Override
	public List<UserVO> searchDoctor(int roleID) throws Exception {
		List<UserVO> doctorList = userDao.selectUserByType(roleID);
		return doctorList;
	}
	
	
}
