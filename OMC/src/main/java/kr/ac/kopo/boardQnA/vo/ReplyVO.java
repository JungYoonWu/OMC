package kr.ac.kopo.boardQnA.vo;

public class ReplyVO {

	private int replyID;
	private int inquiryID;
	private String adminID;
	private String content;
	private String regDate;

	public ReplyVO() {
	}

	public ReplyVO(int replyID, int inquiryID, String adminID, String content, String regDate) {
		this.replyID = replyID;
		this.inquiryID = inquiryID;
		this.adminID = adminID;
		this.content = content;
		this.regDate = regDate;
	}
	
	public ReplyVO(int inquiryID, String adminID, String content) {
		this.inquiryID = inquiryID;
		this.adminID = adminID;
		this.content = content;
	}

	public int getReplyID() {
		return replyID;
	}

	public void setReplyID(int replyID) {
		this.replyID = replyID;
	}

	public int getInquiryID() {
		return inquiryID;
	}

	public void setInquiryID(int inquiryID) {
		this.inquiryID = inquiryID;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
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
		return "ReplyVO [replyID=" + replyID + ", inquiryID=" + inquiryID + ", adminID=" + adminID + ", content="
				+ content + ", regDate=" + regDate + "]";
	}
	
	
}
