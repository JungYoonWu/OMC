package kr.ac.kopo.treatment.vo;

public class DoctorScheduleParam {
    private int doctorID; // int로 변경
    private String workDay;
	public DoctorScheduleParam() {
	}
	public DoctorScheduleParam(int doctorID, String workDay) {
		this.doctorID = doctorID;
		this.workDay = workDay;
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
	@Override
	public String toString() {
		return "DoctorScheduleParam [doctorID=" + doctorID + ", workDay=" + workDay + "]";
	}

   
}
