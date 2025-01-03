package kr.ac.kopo.boardQnA.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.boardQnA.vo.InquiryVO;
import kr.ac.kopo.mybatis.MyConfig;

public class InquiryDAOImpl implements InquiryDAO{

	private SqlSession sqlSession;
	
	public InquiryDAOImpl() {
		sqlSession = new MyConfig().getInstance();
	}
	
	@Override
	public List<InquiryVO> selectAllInquiry() throws Exception {
		sqlSession.clearCache();
		List<InquiryVO> inquiryList = sqlSession.selectList("dao.InquiryDAO.selectAllInquiry");
		System.out.println(inquiryList.toString());
		return inquiryList;
	}
	
	@Override
	public List<InquiryVO> selectMyInquiry(String userID) throws Exception{
		sqlSession.clearCache();
		List<InquiryVO> inquiryList = sqlSession.selectList("dao.InquiryDAO.selectAllInquiry", userID);
		return inquiryList;
	}
	
	@Override
	public InquiryVO selectInquiryByUserID(String userID, int inquiryID) throws Exception {
		sqlSession.clearCache();
		Map<String, Object> params = new HashMap<>();
		params.put("userID", userID);
		params.put("inquiryID", inquiryID);
		InquiryVO inquiryVO = sqlSession.selectOne("dao.InquiryDAO.selectInquiryByUserID", params);
		System.out.println("UserID : " + userID + "Inquiry : " + inquiryVO.toString());
		return inquiryVO;
	}

	@Override
	public List<InquiryVO> selectInquiryByStatus(String status) throws Exception {
		sqlSession.clearCache();
		List<InquiryVO> inquiryList = sqlSession.selectList("dao.InquiryDAO.selectInquiryByStatus",status);
		return inquiryList;
	}

	@Override
	public void insertInquiry(InquiryVO inquiryVO) throws Exception {
		try {
			sqlSession.insert("dao.InquiryDAO.insertInquiry", inquiryVO);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		}
	}

	@Override
	public List<InquiryVO> selectMyInquiryByPaging(String userID, int offset, int limit) throws Exception {
		sqlSession.clearCache();
		Map<String, Object> param = new HashMap<>();
		param.put("userID", userID);
		param.put("offset", offset);
		param.put("limit", limit);
		return sqlSession.selectList("dao.InquiryDAO.selectMyInquiryByPaging", param);
	}

	@Override
	public int countMyInquiry(String userID) throws Exception {
		sqlSession.clearCache();
		return sqlSession.selectOne("dao.InquiryDAO.countMyInquiry", userID);
	}

	@Override
	public List<InquiryVO> selectAllInquiryByPaging(int offset, int limit) throws Exception {
		sqlSession.clearCache();
		Map<String, Object> param = new HashMap<>();
		param.put("offset", offset);
		param.put("limit", limit);
		return sqlSession.selectList("dao.InquiryDAO.selectAllInquiryByPaging", param);
	}

	@Override
	public int countAllInquiry() throws Exception {
		sqlSession.clearCache();
		return sqlSession.selectOne("dao.InquiryDAO.countAllInquiry");
	}

	
}
