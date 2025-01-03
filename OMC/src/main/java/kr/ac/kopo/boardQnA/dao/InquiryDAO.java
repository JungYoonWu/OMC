package kr.ac.kopo.boardQnA.dao;

import java.util.List;

import kr.ac.kopo.boardQnA.vo.InquiryVO;

public interface InquiryDAO {

	/**
	 * 모든 문의를 보여주는 메소드
	 * @return
	 * @throws Exception
	 */
	List<InquiryVO> selectAllInquiry () throws Exception;
	
	
	/**
	 * 사용자가 물어본 문의 상세내용을 보여주는 메소드
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	InquiryVO selectInquiryByUserID(String userID, int inquiryID) throws Exception;
	
	
	/**
	 * 응답상태에 따라 문의글을 보여주는 메소드
	 * @param status
	 * @return
	 * @throws Exception
	 */
	List<InquiryVO> selectInquiryByStatus(String status) throws Exception;


	/**
	 * 접속유저의 ID와 일치하는 문의내용만 보여주는 메소드
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	List<InquiryVO> selectMyInquiry(String userID) throws Exception;


	/**
	 * DB에 문의저장
	 * @param inquiryVO
	 * @throws Exception
	 */
	void insertInquiry(InquiryVO inquiryVO) throws Exception;


	List<InquiryVO> selectMyInquiryByPaging(String userID, int offset, int limit) throws Exception;


	int countMyInquiry(String userID) throws Exception;


	List<InquiryVO> selectAllInquiryByPaging(int offset, int limit) throws Exception;


	int countAllInquiry() throws Exception;
}
