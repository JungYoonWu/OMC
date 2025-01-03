package kr.ac.kopo.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.boardHerbal.service.BoardHerbalService;
import kr.ac.kopo.boardHerbal.service.HerbalService;
import kr.ac.kopo.controller.Controller;

public class AdminHerbalDeleteController implements Controller {

	private HerbalService herbalService;
	
	public AdminHerbalDeleteController() {
		herbalService = new BoardHerbalService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int medicineID = Integer.parseInt(request.getParameter("medicineID"));
		System.out.println("delete용으로 전달받은 한약ID:"+medicineID);
		String name = request.getParameter("name");
		herbalService.removeHerbal(medicineID);
		
		return "redirect:/herbal/list.yoon";
	}

}
