package kr.ac.kopo.boardNotice.vo;

public class BoardNoticeVO {
	private int noticeID;
	private String title;
	private String content;
	private String regDate;
	public BoardNoticeVO() {
	
	}
	
	public BoardNoticeVO(int noticeID, String title, String content, String regDate) {
		this.noticeID = noticeID;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}

	public int getNoticeID() {
		return noticeID;
	}
	public void setNoticeID(int noticeID) {
		this.noticeID = noticeID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardNoticeVO [noticeID=" + noticeID + ", title=" + title + ", content=" + content + ", regDate="
				+ regDate + "]";
	}
	
	
}
