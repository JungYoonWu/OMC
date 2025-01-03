package kr.ac.kopo.boardReservation.vo;

public class ReservationVO {
	private int reservationID;
	private String userID;
	private String reservationDate;
	private String reservationTime;
	private String status;
	private int treatmentID;
	private String doctor;
	private String doctorName;
//	private int doctorID;
	private String doctorID; //role_id = 2 Doctor user의 user_id
	private int bedID;
	
	public ReservationVO(int reservationID, String userID, String reservationDate, String reservationTime, String status,
			int treatmentID) {
		this.reservationID = reservationID;
		this.userID = userID;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.status = status;
		this.treatmentID = treatmentID;
	}
	
		
	public ReservationVO(int reservationID, String userID, String reservationDate, String reservationTime,
			String status, int treatmentID, String doctor) {
		this.reservationID = reservationID;
		this.userID = userID;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.status = status;
		this.treatmentID = treatmentID;
		this.doctor = doctor;
	}	
	public ReservationVO(int reservationID, String userID, String reservationDate, String reservationTime,
			String status, int treatmentID, String doctor, String doctorName) {
		this.reservationID = reservationID;
		this.userID = userID;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.status = status;
		this.treatmentID = treatmentID;
		this.doctor = doctor;
		this.doctorName = doctorName;
	}

	public ReservationVO(int reservationID, String userID, String reservationDate, String reservationTime,
			String status, int treatmentID, String doctor, String doctorName, String doctorID) {
		this.reservationID = reservationID;
		this.userID = userID;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.status = status;
		this.treatmentID = treatmentID;
		this.doctor = doctor;
		this.doctorName = doctorName;
		this.doctorID = doctorID;
	}
	
	


	public ReservationVO(int reservationID, String userID, String reservationDate, String reservationTime,
			String status, int treatmentID, String doctor, String doctorName, String doctorID, int bedID) {
		this.reservationID = reservationID;
		this.userID = userID;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.status = status;
		this.treatmentID = treatmentID;
		this.doctor = doctor;
		this.doctorName = doctorName;
		this.doctorID = doctorID;
		this.bedID = bedID;
	}


	public ReservationVO() {
	}
	
	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public String getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTreatmentID() {
		return treatmentID;
	}
	public void setTreatmentID(int treatmentID) {
		this.treatmentID = treatmentID;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorID() {
		return doctorID;
	}


	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	
	public int getBedID() {
		return bedID;
	}

	public void setBedID(int bedID) {
		this.bedID = bedID;
	}

	@Override
	public String toString() {
		return "ReservationVO [reservationID=" + reservationID + ", userID=" + userID + ", reservationDate="
				+ reservationDate + ", reservationTime=" + reservationTime + ", status=" + status + ", treatmentID="
				+ treatmentID + ", doctor=" + doctor + ", doctorName=" + doctorName + ", doctorID=" + doctorID +", bedID=" + bedID + "]";
	}


	

}
