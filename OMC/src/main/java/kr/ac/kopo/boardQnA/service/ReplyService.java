package kr.ac.kopo.boardQnA.service;

import kr.ac.kopo.boardQnA.vo.ReplyVO;

public interface ReplyService {
	
	void addReply(ReplyVO replyVO) throws Exception;
	
	ReplyVO getReplyByInquiryID(int inquiryID) throws Exception;
}
