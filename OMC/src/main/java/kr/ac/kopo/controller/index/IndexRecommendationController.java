package kr.ac.kopo.controller.index;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardHerbal.service.BoardHerbalService;
import kr.ac.kopo.boardHerbal.vo.HerbalVO;
import kr.ac.kopo.controller.Controller;

public class IndexRecommendationController implements Controller{

	private BoardHerbalService boardService;
	
	public IndexRecommendationController() {
		boardService = new BoardHerbalService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<HerbalVO> herbalSRList = boardService.searchHerbalBySR();
		request.setAttribute("herbalSRList", herbalSRList);
		return "/index.jsp";
	}

	
}
