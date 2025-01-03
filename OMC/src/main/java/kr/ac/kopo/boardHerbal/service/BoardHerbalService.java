package kr.ac.kopo.boardHerbal.service;

import java.util.List;

import kr.ac.kopo.boardHerbal.dao.HerbalDAO;
import kr.ac.kopo.boardHerbal.dao.HerbalDAOImpl;
import kr.ac.kopo.boardHerbal.vo.HerbalVO;

public class BoardHerbalService implements HerbalService{

	private HerbalDAO herbalDao;
	
	public BoardHerbalService() {
		herbalDao = new HerbalDAOImpl();
	}
	
	@Override
	public List<HerbalVO> searchAllHerbal() throws Exception {
		List<HerbalVO> herbalList = herbalDao.selectAllHerbal();
		return herbalList;
	}

	@Override
	public List<HerbalVO> searchHerbalBySR() throws Exception {
		List<HerbalVO> herbalList = herbalDao.selectHerbalBySR();
		return herbalList;
	}

	@Override
	public HerbalVO searchHerbalByName(String name) throws Exception {
		HerbalVO herbalVO = herbalDao.selectHerbalByName(name);
		return herbalVO;
	}

	@Override
	public void removeHerbal(int medicineID) throws Exception {
		herbalDao.deleteHerbal(medicineID);
	}

	@Override
	public void addHerbal(HerbalVO herbalVO) throws Exception {
		herbalDao.insertHerbal(herbalVO);
	}

	
}
