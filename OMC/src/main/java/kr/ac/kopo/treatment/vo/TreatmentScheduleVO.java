package kr.ac.kopo.treatment.vo;

public class TreatmentScheduleVO {

	private int treatmentID;
	private int doctorID;
	private int bedID;
	private String startTime;
	private String endTime;
	private String treatmentDate;
	public TreatmentScheduleVO(int treatmentID, int doctorID, int bedID, String startTime, String endTime,
			String treatmentDate) {
		this.treatmentID = treatmentID;
		this.doctorID = doctorID;
		this.bedID = bedID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.treatmentDate = treatmentDate;
	}
	public TreatmentScheduleVO() {
	}
	public int getTreatmentID() {
		return treatmentID;
	}
	public void setTreatmentID(int treatmentID) {
		this.treatmentID = treatmentID;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public int getBedID() {
		return bedID;
	}
	public void setBedID(int bedID) {
		this.bedID = bedID;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getTreatmentDate() {
		return treatmentDate;
	}
	public void setTreatmentDate(String treatmentDate) {
		this.treatmentDate = treatmentDate;
	}
	@Override
	public String toString() {
		return "TreatmentScheduleVO [treatmentID=" + treatmentID + ", doctorID=" + doctorID + ", bedID=" + bedID
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", treatmentDate=" + treatmentDate + "]";
	}
	
	
}
