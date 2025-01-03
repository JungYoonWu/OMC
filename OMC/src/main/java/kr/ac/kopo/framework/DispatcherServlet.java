package kr.ac.kopo.framework;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;


public class DispatcherServlet extends HttpServlet{

	private HandlerMapping mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String propName = config.getInitParameter("propName");
//		System.out.println("propName : " + propName);
		mappings = new HandlerMapping(propName);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		uri = uri.substring(contextPath.length());
		System.out.println("요청 uri : " + uri);

		try {
			Controller control = mappings.getController(uri);
			String callPage = control.handleRequest(request, response);
			if(callPage == null || callPage.isEmpty()) {
				return;
			}
			if(callPage.startsWith("redirect:")) {
				//callPage = "redirect:login.do"
				callPage = callPage.substring("redirect:".length());
				response.sendRedirect(request.getContextPath() + callPage);
			}else {
				//callPage = "/jsp/board/write.jsp"
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage); //forward시키려는 주소 callPage를 알려줌
				dispatcher.forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
	}

	/*
	 		기능			uri						controller						jsp
		전체게시글조회	/board/list.do			BoardListController 		/jsp/board/list.jsp
		새글등록폼		/board/writeForm.do		BoardWriteFormController	/jsp/board/writeForm.jsp
		새글등록		/board/write.do			BoardWriteController		/jsp/board/write.jsp
		로그인폼		/login					LoginController				/jsp/member/login.jsp
	*/
}
