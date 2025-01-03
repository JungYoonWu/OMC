package kr.ac.kopo.boardQnA.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.boardQnA.vo.ReplyVO;
import kr.ac.kopo.mybatis.MyConfig;

public class ReplyDAOImpl implements ReplyDAO{

	private SqlSession sqlSession;
	
	public ReplyDAOImpl() {
		this.sqlSession = new MyConfig().getInstance();
	}

	@Override
	public void insertReply(ReplyVO replyVO) throws Exception {
		sqlSession.insert("dao.ReplyDAO.insertReply", replyVO);
		sqlSession.commit();
	}

	@Override
	public ReplyVO selectReplyByInquiryID(int inquiryID) throws Exception {
		sqlSession.clearCache();
		return sqlSession.selectOne("dao.ReplyDAO.selectReplyByInquiryID", inquiryID);
	}

	@Override
	public void updateInquiryStatus(int inquiryID, String status) throws Exception {
		sqlSession.clearCache();
		Map<String, Object> param = new HashMap<>();
		param.put("inquiryID", inquiryID);
		param.put("status", status);
		sqlSession.update("dao.ReplyDAO.updateInquiryStatus", param);
		sqlSession.commit();
	}
	
}
