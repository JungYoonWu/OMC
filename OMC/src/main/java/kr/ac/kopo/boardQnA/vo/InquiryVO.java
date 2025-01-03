package kr.ac.kopo.boardQnA.vo;

public class InquiryVO {

	private int inquiryID;
	private String userID;
	private String title;
	private String content;
	private String regDate;
	private String status;
	
	public InquiryVO(int inquiryID, String userID, String title, String content, String regDate, String status) {
		this.inquiryID = inquiryID;
		this.userID = userID;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.status = status;
	}
	
	public InquiryVO(String userID, String title, String content) {
		this.userID = userID;
		this.title = title;
		this.content = content;
	}

	public InquiryVO() {
	}
	public int getInquiryID() {
		return inquiryID;
	}
	public void setInquiryID(int inquiryID) {
		this.inquiryID = inquiryID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "QnAVO [inquiryID=" + inquiryID + ", userID=" + userID + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", status=" + status + "]";
	}
	
	
}
