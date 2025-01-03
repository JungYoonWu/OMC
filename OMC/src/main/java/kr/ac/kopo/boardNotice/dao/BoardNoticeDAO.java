package kr.ac.kopo.boardNotice.dao;

import java.util.List;

import kr.ac.kopo.boardNotice.vo.BoardNoticeVO;

public interface BoardNoticeDAO {

	/**
	 * 데이터베이스에서 공지게시판에 전체 글을 가지고오는 메소드
	 * @return
	 * @throws Exception
	 */
	List<BoardNoticeVO> selectAllBoard() throws Exception;
	
	/**
	 * id값이 일치하는 NoticeVO값을 가지고오는 메소드
	 * @return
	 * @throws Exception
	 */
	BoardNoticeVO selectBoardByID(int noticeID) throws Exception;
	
	
	/**
	 * DB에 공지사항을 추가하는 메소드
	 * @param boardNoticeVO
	 */
	void insertNotice(BoardNoticeVO boardNoticeVO) throws Exception;

	/**
	 * DB에서 지움
	 * @param noticeID
	 * @return 
	 * @throws Exception
	 */
	int deleteNotice(int noticeID) throws Exception;
}
