package test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import kr.ac.kopo.boardHerbal.dao.HerbalDAOImpl;
import kr.ac.kopo.boardHerbal.vo.HerbalVO;
import kr.ac.kopo.boardNotice.dao.BoardNoticeDAOImpl;
import kr.ac.kopo.boardNotice.vo.BoardNoticeVO;
import kr.ac.kopo.boardQnA.dao.InquiryDAOImpl;
import kr.ac.kopo.boardQnA.vo.InquiryVO;
import kr.ac.kopo.boardReservation.dao.ReservationDAOImpl;
import kr.ac.kopo.boardReservation.vo.ReservationVO;
import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.user.dao.UserDAO;
import kr.ac.kopo.user.dao.UserDAOImpl;
import kr.ac.kopo.user.vo.UserVO;

class OMCTest {

	//session연결확인테스트
	@Disabled
	@Test
	void test() {
		SqlSession session = new MyConfig().getInstance();
		assertNotNull(session);
	}

	//공지게시글 확인 테스트
	@Disabled
	@Test
	void 전체게시글조회Test() throws Exception{
		SqlSession session = new MyConfig().getInstance();
		//전체게시글조회테스트
//		List<BoardVO> list = session.selectList("dao.BoardDAO.selectBoard");
		List<BoardNoticeVO> list = new BoardNoticeDAOImpl().selectAllBoard();
		assertNotEquals(list.size(), 0);
	}
	
	//세부공지사항확인테스트
	@Disabled
	@Test
	void 공지사항확인Test()throws Exception{
		SqlSession session = new MyConfig().getInstance();
		BoardNoticeVO boardNoticeVO = new BoardNoticeDAOImpl().selectBoardByID(1);
		assertNotEquals(boardNoticeVO, null);
	}
	
	//회원목록 확인테스트
	@Disabled
	@Test
	void 회원목록Test() throws Exception{
		SqlSession session = new MyConfig().getInstance();
		List<UserVO> list = new UserDAOImpl().selectAllUser();
		assertNotEquals(list.size(), 0);
	}
	
	@Disabled
	@Test
	void 회원정보Test() throws Exception{
		SqlSession session = new MyConfig().getInstance();
		UserVO userVO = new UserDAOImpl().selectUserByUserID("test_user");
		assertNotEquals(userVO, null);
	}
	
	
	//예약목록 확인테스트
	@Disabled
	@Test
	void 예약목록Test() throws Exception{
		SqlSession session = new MyConfig().getInstance();
		List<ReservationVO> list = new ReservationDAOImpl().selectAllReservation();
		assertNotEquals(list.size(), 0);
	}
	
	
	//세부예약내용 테스트
	//@Disabled
	@Disabled
	@Test
	void 세부예약내용Test() throws Exception{
		SqlSession session = new MyConfig().getInstance();
		ReservationVO reservationVO = new ReservationDAOImpl().selectReservationByReservationID(5);
		assertNotEquals(reservationVO, null);
	}
	
	//문의글 불러오기 테스트
	@Disabled
	@Test
	void QnA게시판Test() throws Exception{
		SqlSession session = new MyConfig().getInstance();
		List<InquiryVO> inquiryList = new InquiryDAOImpl().selectAllInquiry();
		assertNotEquals(inquiryList.size(), 0);
	}
	
	@Disabled
	@Test
	void 한약상품추천리스트Test() throws Exception{
		SqlSession session = new MyConfig().getInstance();
		List<HerbalVO> herbalList = new HerbalDAOImpl().selectHerbalBySR();
		assertNotEquals(herbalList.size(), 0);		
	}
	
	@Disabled
	@Test
	void 한약상품전체리스트Test() throws Exception{
		SqlSession session = new MyConfig().getInstance();
		List<HerbalVO> herbalList = new HerbalDAOImpl().selectAllHerbal();
		assertNotEquals(herbalList.size(), 0);		
	}
	
	@Disabled
	@Test
	void 한약세부내용Test() throws Exception{
		SqlSession session = new MyConfig().getInstance();
		HerbalVO herbalVO = new HerbalDAOImpl().selectHerbalByName("임시한약");
		assertNotEquals(herbalVO, null);		
	}
	@Disabled
	@Test
	void 타입별회원목록Test() throws Exception{
		SqlSession session = new MyConfig().getInstance();
		List<UserVO> userList = new UserDAOImpl().selectUserByType("patient");
		assertNotEquals(userList.size(), 0);
	}
	
	@Disabled
	@Test
	void 로그인Test() throws Exception{
		SqlSession session = new MyConfig().getInstance();
		UserVO userVO = new UserDAOImpl().selectUserLogin("test_user", "asdf");
		assertNotEquals(userVO, null);
	}
	
	@Test
	void 회원가입Test() throws Exception{
		SqlSession session = new MyConfig().getInstance();
		UserDAO userDao = new UserDAOImpl();
		UserVO userVO = new UserVO("testID", "testName", "testEmail", "testPWD", "testPhone", 1, 10000);
		assertNotEquals(userDao.insertPatientUser(userVO), true);
	}
}
