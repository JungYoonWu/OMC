package kr.ac.kopo.boardNotice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.boardNotice.vo.BoardNoticeVO;
import kr.ac.kopo.mybatis.MyConfig;

public class BoardNoticeDAOImpl implements BoardNoticeDAO {

	private SqlSession sqlSession;
	
	public BoardNoticeDAOImpl() {
		sqlSession = new MyConfig().getInstance();
	}

	@Override
	public List<BoardNoticeVO> selectAllBoard() throws Exception {
		sqlSession.clearCache();
		List<BoardNoticeVO> boardNoticeList = sqlSession.selectList("dao.BoardNoticeDAO.selectNoticeBoard");
		System.out.println("DB에서 가지고온 공지리스트 : "+boardNoticeList);
		return boardNoticeList;
	}

	@Override
	public BoardNoticeVO selectBoardByID(int noticeID) throws Exception {
		BoardNoticeVO boardNoticeVO = sqlSession.selectOne("dao.BoardNoticeDAO.selectNoticeBoardByID", noticeID);
		return boardNoticeVO;
	}

	@Override
	public void insertNotice(BoardNoticeVO boardNoticeVO) throws Exception {
		//insertNotice
		sqlSession.clearCache();
		try {
			sqlSession.insert("dao.BoardNoticeDAO.insertNotice", boardNoticeVO);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		}
	}

	@Override
	public int deleteNotice(int noticeID) throws Exception {
		try {
			sqlSession.delete("dao.BoardNoticeDAO.deleteNotice", noticeID);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		}
	}
	
	
	
}
