package kr.ac.kopo.controller.users;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.service.UserService;
import kr.ac.kopo.user.service.UserServiceImpl;
import kr.ac.kopo.user.vo.UserVO;

public class UserSignUpProcessController implements Controller {

	private UserService userService;
	
	public UserSignUpProcessController() {
		userService = new UserServiceImpl();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = request.getParameter("userID");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		UserVO userVO = new UserVO(userID, name, email, password, phone);
		
		
		if(userService.signUpProcess(userVO)) {
			
			return "/jsp/user/loginForm.jsp";
		}else {
			request.setAttribute("signUpError", "이미 존재하는 ID 입니다.");
			return "/jsp/user/signUpForm.jsp";
		}
	}

}
