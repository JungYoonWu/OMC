package kr.ac.kopo.controller.boardHerbal;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardHerbal.service.BoardHerbalService;
import kr.ac.kopo.boardHerbal.service.HerbalService;
import kr.ac.kopo.boardHerbal.vo.HerbalVO;
import kr.ac.kopo.controller.Controller;

public class HerbalListController implements Controller{

	private HerbalService herbalService;
	
	public HerbalListController() {
		herbalService = new BoardHerbalService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<HerbalVO> herbalList = herbalService.searchAllHerbal();
		request.setAttribute("herbalList", herbalList);
		System.out.println(herbalList.toString());
		return "/jsp/boardHerbal/herbalList.jsp";
	}
	
}
