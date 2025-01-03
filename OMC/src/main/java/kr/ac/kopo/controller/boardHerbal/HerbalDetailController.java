package kr.ac.kopo.controller.boardHerbal;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardHerbal.service.BoardHerbalService;
import kr.ac.kopo.boardHerbal.service.HerbalService;
import kr.ac.kopo.boardHerbal.vo.HerbalVO;
import kr.ac.kopo.controller.Controller;

public class HerbalDetailController implements Controller{

	private HerbalService herbalService;
	
	public HerbalDetailController() {
		herbalService = new BoardHerbalService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String herbalName = request.getParameter("name");
		System.out.println("전달받은 약이름 : "+herbalName);
		
		HerbalVO herbalVO = herbalService.searchHerbalByName(herbalName);
		request.setAttribute("herbalVO", herbalVO);
		return "/jsp/boardHerbal/herbalDetail.jsp";
	}
	
}
