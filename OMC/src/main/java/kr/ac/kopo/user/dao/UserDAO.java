package kr.ac.kopo.user.dao;

import java.util.List;

import kr.ac.kopo.user.vo.DoctorVO;
import kr.ac.kopo.user.vo.UserVO;

public interface UserDAO {

	/**
	 * 전체유저목록을 불러오는 메소드
	 * @return
	 * @throws Exception
	 */
	List<UserVO> selectAllUser() throws Exception;
	
	/**
	 * userID와 일치하는 유저를 찾는 메소드
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	UserVO selectUserByUserID(String userID) throws Exception;
	
	/**
	 * 타입별로 검색하는
	 * @param roleName
	 * @return
	 * @throws Exception
	 */
	List<UserVO> selectUserByType(String roleName) throws Exception;
	
	/**
	 * 입력받은 ID,PASSWORD와 일치하는 값을 DB에서 가지고오는 메소드
	 * @param userID
	 * @param password
	 * @return
	 * @throws Exception
	 */
	UserVO selectUserLogin(String userID, String password) throws Exception;
	
	
	/**
	 * UserVO에 저장된 내용을 DB에 저장하는 메소드
	 * @param userVO
	 * @return 성공하면 true
	 * @throws Exception
	 */
	boolean insertPatientUser(UserVO userVO) throws Exception;

	List<UserVO> selectUserByType(int roleID) throws Exception;

	List<DoctorVO> selectDoctors(int roleID) throws Exception;

	List<UserVO> selectDoctorsByWorkDay(String workDay) throws Exception;
}
