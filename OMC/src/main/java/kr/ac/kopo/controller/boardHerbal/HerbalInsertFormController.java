package kr.ac.kopo.controller.boardHerbal;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;

public class HerbalInsertFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/jsp/boardHerbal/adminHerbalInsertForm.jsp";
	}

}
