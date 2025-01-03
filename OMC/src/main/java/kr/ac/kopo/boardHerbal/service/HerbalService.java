package kr.ac.kopo.boardHerbal.service;

import java.util.List;

import kr.ac.kopo.boardHerbal.vo.HerbalVO;

public interface HerbalService {

	List<HerbalVO> searchAllHerbal() throws Exception;
	
	List<HerbalVO> searchHerbalBySR() throws Exception;
	
	HerbalVO searchHerbalByName(String name) throws Exception;

	void removeHerbal(int medicineID) throws Exception;

	void addHerbal(HerbalVO herbalVO) throws Exception;
	
}
