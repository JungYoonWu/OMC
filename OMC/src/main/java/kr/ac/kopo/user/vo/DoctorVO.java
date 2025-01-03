package kr.ac.kopo.user.vo;

public class DoctorVO {

	private int omdDoctorID;//omdoctor에 연결된 doctorID
	private String userID;
	private String doctorName;
	public DoctorVO() {
	}
	public DoctorVO(int omdDoctorID, String userID, String doctorName) {
		this.omdDoctorID = omdDoctorID;
		this.userID = userID;
		this.doctorName = doctorName;
	}
	public int getOmdDoctorID() {
		return omdDoctorID;
	}
	public void setOmdDoctorID(int omdDoctorID) {
		this.omdDoctorID = omdDoctorID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	@Override
	public String toString() {
		return "DoctorVO [omdDoctorID=" + omdDoctorID + ", userID=" + userID + ", doctorName=" + doctorName + "]";
	}
	
	
	
	
	
}
