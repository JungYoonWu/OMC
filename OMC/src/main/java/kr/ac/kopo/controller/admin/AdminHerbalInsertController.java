package kr.ac.kopo.controller.admin;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardHerbal.service.BoardHerbalService;
import kr.ac.kopo.boardHerbal.service.HerbalService;
import kr.ac.kopo.boardHerbal.vo.HerbalVO;
import kr.ac.kopo.controller.Controller;

public class AdminHerbalInsertController implements Controller {
	private HerbalService herbalService;
	
	public AdminHerbalInsertController() {
		herbalService = new BoardHerbalService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String seasonalRecommendation = request.getParameter("seasonalRecommendation");
		System.out.println("상품등록폼에서 전달받은 파라미터 : " + name + ", " + description +", " + seasonalRecommendation);
		
		HerbalVO herbalVO = new HerbalVO(name, description, seasonalRecommendation);
		
		herbalService.addHerbal(herbalVO);
		List<HerbalVO> herbalList = herbalService.searchAllHerbal();
		request.setAttribute("herbalList", herbalList);
		return "/jsp/boardHerbal/herbalList.jsp";
	}

}
