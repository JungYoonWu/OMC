package kr.ac.kopo.boardQnA.service;

import java.util.List;

import kr.ac.kopo.boardQnA.vo.InquiryVO;

public interface InquiryService {
	
	/**
	 * 모든 문의를 보여주는 메소드
	 * @return
	 * @throws Exception
	 */
	List<InquiryVO> searchAllInquiry() throws Exception;

	/**
	 * 파라미터로 접속한 유저의 ID를 넘겨주고 접속유저가 문의한 내용을 보여주는 메소드
	 * @param userID
	 * @return
	 */
	List<InquiryVO> searchAllInquiry(String userID) throws Exception;
	
	/**
	 * 사용자ID로 사용자가 문의한 문의내용을 보여주는 메소드
	 * @return
	 * @throws Exception
	 */
	InquiryVO searchInquiryByUserID(String userID, int inquiryID) throws Exception;

	/**
	 * 문의등록메소드
	 * @param inquiryVO
	 * @throws Exception
	 */
	void addInquiry(InquiryVO inquiryVO) throws Exception;

	List<InquiryVO> searchMyInquiryByPaging(String userID, int page, int size) throws Exception;

	int countMyInquiry(String userID) throws Exception;

	List<InquiryVO> searchAllInquiryByPaging(int page, int size) throws Exception;

	int countAllInquiry() throws Exception;


}
