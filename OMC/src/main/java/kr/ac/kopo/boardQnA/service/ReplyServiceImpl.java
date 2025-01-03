package kr.ac.kopo.boardQnA.service;

import kr.ac.kopo.boardQnA.dao.ReplyDAO;
import kr.ac.kopo.boardQnA.dao.ReplyDAOImpl;
import kr.ac.kopo.boardQnA.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {

	private ReplyDAO replyDao;
	
	public ReplyServiceImpl () {
		replyDao = new ReplyDAOImpl();
	}
	
	@Override
	public void addReply(ReplyVO replyVO) throws Exception {
		replyDao.insertReply(replyVO);
		replyDao.updateInquiryStatus(replyVO.getInquiryID(), "응답완료");
	}

	@Override
	public ReplyVO getReplyByInquiryID(int inquiryID) throws Exception {
		return replyDao.selectReplyByInquiryID(inquiryID);
	}

}
