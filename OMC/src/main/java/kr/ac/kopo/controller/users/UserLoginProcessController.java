package kr.ac.kopo.controller.users;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.service.UserService;
import kr.ac.kopo.user.service.UserServiceImpl;
import kr.ac.kopo.user.vo.UserVO;

public class UserLoginProcessController implements Controller {

	private UserService userService;
	
	public UserLoginProcessController() {
		userService = new UserServiceImpl();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		System.out.println("로그인 시도하는 ID:"+userID+"비밀번호:"+password);
		UserVO userVO = userService.loginProcess(userID, password);
		if(userVO == null) {
			return "/jsp/user/loginFail.jsp";
		}else {
			request.getSession().setAttribute("loginVO", userVO);
			return "/index.jsp";
		}
	}

}
