package kr.ac.kopo.boardNotice.service;

import java.util.List;

import kr.ac.kopo.boardNotice.vo.BoardNoticeVO;

public interface NoticeService {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<BoardNoticeVO> searchAllBoard() throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	BoardNoticeVO searchBoardByID(int noticeID) throws Exception;
	
	
	/**
	 * 공지등록메소드
	 * @param boardNoticeVO
	 * @throws Exception
	 */
	void addNotice(BoardNoticeVO boardNoticeVO) throws Exception;

	/**
	 * 공지삭제
	 * @param noticeID
	 * @throws Exception
	 */
	void deleteNotice(int noticeID) throws Exception;
}
