package kr.ac.kopo.treatment.vo;

public class TreatmentRoomStatusVO {

	private int bedID;
	private int roomID;
	private int bedNumber;
    private String bedStatus; // 각 침대의 상태 (empty/ing)
    
    public TreatmentRoomStatusVO() {
	}

	public TreatmentRoomStatusVO(int bedID, int roomID, int bedNumber, String bedStatus) {
		this.bedID = bedID;
		this.roomID = roomID;
		this.bedNumber = bedNumber;
		this.bedStatus = bedStatus;
	}

	public int getBedID() {
		return bedID;
	}

	public void setBedID(int bedID) {
		this.bedID = bedID;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public int getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(int bedNumber) {
		this.bedNumber = bedNumber;
	}

	public String getBedStatus() {
		return bedStatus;
	}

	public void setBedStatus(String bedStatus) {
		this.bedStatus = bedStatus;
	}

	@Override
    public String toString() {
        // 침대 상태를 표시하는 로직 (각 침대 상태는 'ing' 또는 'empty' 등으로 표시)
        return this.bedStatus;
    }
}
