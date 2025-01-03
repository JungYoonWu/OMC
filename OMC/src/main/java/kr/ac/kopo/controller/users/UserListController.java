package kr.ac.kopo.controller.users;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardNotice.service.BoardNoticeService;
import kr.ac.kopo.boardNotice.vo.BoardNoticeVO;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.service.UserService;
import kr.ac.kopo.user.service.UserServiceImpl;
import kr.ac.kopo.user.vo.UserVO;

public class UserListController implements Controller {

	private UserService userService;
	
	
	
	public UserListController() {
		userService = new UserServiceImpl();
	}



	@Override
	//반환값이 String인 이유는 JSP주소를 String으로 표현해서
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<UserVO> userList = userService.searchAllUser();
		request.setAttribute("userList", userList);
		System.out.println(userList.toString());
		//forward용 주소라서 contextPath 뒤를 뜻함
		return "/jsp/user/user.jsp";
	}
}
