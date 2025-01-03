package kr.ac.kopo.boardQnA.service;

import java.util.List;

import kr.ac.kopo.boardQnA.dao.InquiryDAO;
import kr.ac.kopo.boardQnA.dao.InquiryDAOImpl;
import kr.ac.kopo.boardQnA.vo.InquiryVO;

public class BoardInquiryService implements InquiryService{

	private InquiryDAO inquiryDao;
	
	public BoardInquiryService () {
		inquiryDao = new InquiryDAOImpl();
	}
	
	@Override
	public List<InquiryVO> searchAllInquiry() throws Exception {
		List<InquiryVO> inquiryList = inquiryDao.selectAllInquiry();
		return inquiryList;
	}

	@Override
	public List<InquiryVO> searchAllInquiry(String userID) throws Exception {
		List<InquiryVO> inquiryList = inquiryDao.selectMyInquiry(userID);
		return inquiryList;
	}

	@Override
	public InquiryVO searchInquiryByUserID(String userID, int inquiryID) throws Exception {
		
		InquiryVO inquiryVO = inquiryDao.selectInquiryByUserID(userID, inquiryID);
		return inquiryVO;
	}

	@Override
	public void addInquiry(InquiryVO inquiryVO) throws Exception {
		inquiryDao.insertInquiry(inquiryVO);
	}

	@Override
	public List<InquiryVO> searchMyInquiryByPaging(String userID, int page, int size) throws Exception {
		int offset = (page -1) * size;
		return inquiryDao.selectMyInquiryByPaging(userID, offset, size);
	}

	@Override
	public int countMyInquiry(String userID) throws Exception {
		return inquiryDao.countMyInquiry(userID);
	}

	@Override
	public List<InquiryVO> searchAllInquiryByPaging(int page, int size) throws Exception {
		int offset = (page -1) * size;
		return inquiryDao.selectAllInquiryByPaging(offset, size);
	}

	@Override
	public int countAllInquiry() throws Exception {
		return inquiryDao.countAllInquiry();
	}
	
	
}
