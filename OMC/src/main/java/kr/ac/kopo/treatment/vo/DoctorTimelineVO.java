package kr.ac.kopo.treatment.vo;

public class DoctorTimelineVO {

    private String doctorName;
    private String timelineStatus; // 각 시간대별 예약 상태 (비어있음/예약됨)

    public DoctorTimelineVO(String doctorName, String timelineStatus) {
		this.doctorName = doctorName;
		this.timelineStatus = timelineStatus;
	}

	public DoctorTimelineVO() {
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getTimelineStatus() {
		return timelineStatus;
	}

	public void setTimelineStatus(String timelineStatus) {
		this.timelineStatus = timelineStatus;
	}

	@Override
    public String toString() {
        // 타임라인 정보를 표시하는 로직
        return this.timelineStatus;
    }
}
