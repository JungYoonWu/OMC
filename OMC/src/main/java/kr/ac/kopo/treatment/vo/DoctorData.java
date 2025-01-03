package kr.ac.kopo.treatment.vo;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.boardReservation.vo.ReservationVO;

public class DoctorData {
    private String name;
    private List<ReservationVO> reservations;
    
    public DoctorData(String name) {
        this.name = name;
        this.reservations = new ArrayList<>();
    }

    public DoctorData() {
        this.reservations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<ReservationVO> getReservations() {
        return reservations;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReservations(List<ReservationVO> reservations) {
        this.reservations = reservations;
    }

	@Override
	public String toString() {
		return "DoctorData [name=" + name + ", reservations=" + reservations + "]";
	}
    
    
}
