package kr.ac.kopo.user.service;

import java.util.List;

import kr.ac.kopo.user.vo.DoctorVO;
import kr.ac.kopo.user.vo.UserVO;

public interface UserService {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<UserVO> searchAllUser() throws Exception;
	
	/**
	 * 의사목록
	 * @param roleID
	 * @return
	 * @throws Exception
	 */
	List<DoctorVO> searchDoctors(int roleID) throws Exception;
	
	/**
	 * 파라미터로 전달받은 UserID값으로 검색한 UserVO값을 찾는 메소드 
	 * @return
	 * @throws Exception
	 */
	UserVO searchUserByUserID(String userID) throws Exception;
	
	
	/**
	 * 유저타입별로 검색하는 메소드
	 * @param roleName
	 * @return
	 * @throws Exception
	 */
	List<UserVO> searchUserByRoleName(String roleName) throws Exception;
	
	
	/**
	 * loginForm에서 입력한 ID,PASSWORD값이 일치하는 userVO를 반환하는 메소드
	 * @param userID
	 * @param password
	 * @return
	 * @throws Exception
	 */
	UserVO loginProcess(String userID, String password) throws Exception;
	
	/**
	 * 회원가입성공시 true/ 실패시false 
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	boolean signUpProcess(UserVO userVO) throws Exception;


	List<UserVO> searchDoctor(int roleID) throws Exception;

	List<UserVO> getDoctorsByWorkDay(String workDay) throws Exception;
}
