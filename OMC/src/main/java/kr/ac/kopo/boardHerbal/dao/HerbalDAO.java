package kr.ac.kopo.boardHerbal.dao;

import java.util.List;

import kr.ac.kopo.boardHerbal.vo.HerbalVO;

public interface HerbalDAO {

	/**
	 * 모든한약리스트
	 * @return
	 * @throws Exception
	 */
	List<HerbalVO> selectAllHerbal () throws Exception;
	
	
	/**
	 * 추천한약리스트
	 * @return
	 * @throws Exception
	 */
	List<HerbalVO> selectHerbalBySR () throws Exception;
	
	
	/**
	 * 이름으로검색한 한약
	 * @param name
	 * @return
	 * @throws Exception
	 */
	HerbalVO selectHerbalByName(String name) throws Exception;


	/**
	 * 한약삭제
	 * @param medicineID
	 * @throws Exception
	 */
	void deleteHerbal(int medicineID) throws Exception;


	void insertHerbal(HerbalVO herbalVO) throws Exception;
}
