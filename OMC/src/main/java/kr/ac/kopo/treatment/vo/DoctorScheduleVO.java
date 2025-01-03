package kr.ac.kopo.treatment.vo;

public class DoctorScheduleVO {

	private int scheduleID;
	private int doctorID; //omdoctor table pk
	private String workDay;
	private String workStartTime;
	private String workEndTime;
	public DoctorScheduleVO(int scheduleID, int doctorID, String workDay, String workStartTime, String workEndTime) {
		this.scheduleID = scheduleID;
		this.doctorID = doctorID;
		this.workDay = workDay;
		this.workStartTime = workStartTime;
		this.workEndTime = workEndTime;
	}
	public DoctorScheduleVO() {
	}
	public int getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public String getWorkDay() {
		return workDay;
	}
	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}
	public String getWorkStartTime() {
		return workStartTime;
	}
	public void setWorkStartTime(String workStartTime) {
		this.workStartTime = workStartTime;
	}
	public String getWorkEndTime() {
		return workEndTime;
	}
	public void setWorkEndTime(String workEndTime) {
		this.workEndTime = workEndTime;
	}
	@Override
	public String toString() {
		return "DoctorScheduleVO [scheduleID=" + scheduleID + ", doctorID=" + doctorID + ", workDay=" + workDay
				+ ", workStartTime=" + workStartTime + ", workEndTime=" + workEndTime + "]";
	}
	
	
}
