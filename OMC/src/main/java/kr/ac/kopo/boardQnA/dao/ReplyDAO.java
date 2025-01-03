package kr.ac.kopo.boardQnA.dao;

import kr.ac.kopo.boardQnA.vo.ReplyVO;

public interface ReplyDAO {

	void insertReply(ReplyVO replyVO) throws Exception;
	
	ReplyVO selectReplyByInquiryID(int inquiryID) throws Exception;
	
	void updateInquiryStatus(int inquiryID, String status) throws Exception;
}
