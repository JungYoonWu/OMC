package kr.ac.kopo.boardHerbal.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.boardHerbal.vo.HerbalVO;
import kr.ac.kopo.mybatis.MyConfig;

public class HerbalDAOImpl implements HerbalDAO{

	private SqlSession sqlSession;
	
	public HerbalDAOImpl() {
		sqlSession = new MyConfig().getInstance();
	}
	
	@Override
	public List<HerbalVO> selectAllHerbal() throws Exception {
		sqlSession.clearCache();
		List<HerbalVO> herbalList = sqlSession.selectList("dao.HerbalDAO.selectAllHerbal");
		System.out.println(herbalList.toString());
		return herbalList;
	}

	@Override
	public List<HerbalVO> selectHerbalBySR() throws Exception {
		sqlSession.clearCache();
		List<HerbalVO> herbalList = sqlSession.selectList("dao.HerbalDAO.selectHerbalBySR");
		System.out.println(herbalList.toString());
		return herbalList;
	}

	@Override
	public HerbalVO selectHerbalByName(String name) throws Exception {
		HerbalVO herbalVO = sqlSession.selectOne("dao.HerbalDAO.selectHerbalByName", name);
		System.out.println(herbalVO.toString());
		return herbalVO;
	}

	@Override
	public void deleteHerbal(int medicineID) throws Exception {
		try {
			sqlSession.delete("dao.HerbalDAO.deleteHerbal", medicineID);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		}
	}

	@Override
	public void insertHerbal(HerbalVO herbalVO) throws Exception {
		try {
			sqlSession.insert("dao.HerbalDAO.insertHerbal", herbalVO);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		}
	}
}
