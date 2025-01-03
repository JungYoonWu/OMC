package kr.ac.kopo.controller.users;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.user.service.UserService;
import kr.ac.kopo.user.service.UserServiceImpl;
import kr.ac.kopo.user.vo.UserVO;

public class UserMyPageController implements Controller {

	private UserService userService;
	
	public UserMyPageController() {
		userService = new UserServiceImpl();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserVO loginVO = (UserVO) request.getSession().getAttribute("loginVO");
		if(loginVO == null) {
			System.out.println("세션값이 없습니다.");
			return "/jsp/user/loginForm.jsp";
		}else {
			System.out.println("로그인된 사용자정보는 : "+loginVO.toString());
			request.setAttribute("loginVO", loginVO);
			return "/jsp/user/userMyPage.jsp";
		}
	}
}
