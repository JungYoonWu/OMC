package kr.ac.kopo.controller.users;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.service.UserService;
import kr.ac.kopo.user.service.UserServiceImpl;
import kr.ac.kopo.user.vo.UserVO;

public class UserDetailController implements Controller {

	private UserService userService;
	
	public UserDetailController() {
		userService = new UserServiceImpl();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = request.getParameter("userID");
		System.out.println("UserDetail회원아이디: " + userID);
		UserVO userVO = userService.searchUserByUserID(userID);
		request.setAttribute("userVO", userVO);
		return "/jsp/user/userDetail.jsp";
	}

}
