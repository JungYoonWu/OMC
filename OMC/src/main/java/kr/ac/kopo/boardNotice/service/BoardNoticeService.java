package kr.ac.kopo.boardNotice.service;

import java.util.List;

import kr.ac.kopo.boardNotice.dao.BoardNoticeDAO;
import kr.ac.kopo.boardNotice.dao.BoardNoticeDAOImpl;
import kr.ac.kopo.boardNotice.vo.BoardNoticeVO;

public class BoardNoticeService implements NoticeService{

	private BoardNoticeDAO boardNoticeDao;
	
	public BoardNoticeService() {
		boardNoticeDao = new BoardNoticeDAOImpl();
	}
	
	public List<BoardNoticeVO> searchAllBoard() throws Exception{
		List<BoardNoticeVO> boardNoticeList = boardNoticeDao.selectAllBoard();
		return boardNoticeList;
	}
	
	public BoardNoticeVO searchBoardByID(int noticeID) throws Exception{
		BoardNoticeVO boardNoticeVO = boardNoticeDao.selectBoardByID(noticeID);
		return boardNoticeVO;
	}

	@Override
	public void addNotice(BoardNoticeVO boardNoticeVO) throws Exception {
		boardNoticeDao.insertNotice(boardNoticeVO);
	}

	@Override
	public void deleteNotice(int noticeID) throws Exception {
		int result = boardNoticeDao.deleteNotice(noticeID);
		if(result == 1) {
			System.out.println(noticeID + "공지 삭제 성공");
		}else {
			System.out.println(noticeID + "공지 삭제 실패");
		}
	}
}
