package kr.ac.kopo.treatment.service;

import java.util.List;

import kr.ac.kopo.boardReservation.dao.ReservationDAO;
import kr.ac.kopo.boardReservation.dao.ReservationDAOImpl;
import kr.ac.kopo.boardReservation.vo.ReservationVO;
import kr.ac.kopo.treatment.dao.TreatmentDAO;
import kr.ac.kopo.treatment.dao.TreatmentDAOImpl;
import kr.ac.kopo.treatment.vo.DoctorScheduleVO;
import kr.ac.kopo.treatment.vo.DoctorTimelineVO;
import kr.ac.kopo.treatment.vo.TreatmentRoomStatusVO;
import kr.ac.kopo.user.vo.DoctorVO;
import kr.ac.kopo.user.vo.UserVO;

public class TreatmentServiceImpl implements TreatmentService{

    private TreatmentDAO treatmentDao;
    private ReservationDAO reservationDao;

    public TreatmentServiceImpl() {
        treatmentDao = new TreatmentDAOImpl();
        reservationDao = new ReservationDAOImpl();
    }

    //
    public List<TreatmentRoomStatusVO> getTreatmentRoomStatus() throws Exception{
        // 치료실 상태 정보를 DB에서 가져오는 로직
        return treatmentDao.selectAllTreatmentRoomStatus();
    }

    public List<DoctorTimelineVO> getDoctorTimeline() throws Exception{
        // 한의사 타임라인을 DB에서 가져오는 로직
        return treatmentDao.getDoctorTimeline();
    }

	@Override
	public List<ReservationVO> searchTodayReservation() throws Exception {
		List<ReservationVO> todayReservation = treatmentDao.selectTodayReservation();
		return todayReservation;
	}

	@Override
	public void updateBedStatus(int bedID, String status) throws Exception {
		treatmentDao.updateBedStatus(bedID, status);
	}

	@Override
	public List<DoctorScheduleVO> getDoctorSchedule(int doctorID, String workDay) throws Exception {
		List<DoctorScheduleVO> doctorSchedule = treatmentDao.selectDoctorSchedule(doctorID, workDay);
		return doctorSchedule;
	}

	@Override
	public List<UserVO> getAllDoctors() throws Exception {
		return treatmentDao.selectAllDoctors();
	}

	@Override
	public List<DoctorVO> getOMDoctors() throws Exception {
		return treatmentDao.selectOMDoctors();
	}

	@Override
	public TreatmentRoomStatusVO assignedBedToReservation(ReservationVO reservation) throws Exception {
		TreatmentRoomStatusVO bed = treatmentDao.findEmptyBed();
		if(bed != null) {
			System.out.println("Assigning Bed ID: " + bed.getBedID() + " to Reservation ID: " + reservation.getReservationID());
			treatmentDao.updateBedStatus(bed.getBedID(), "ing");
			//DB에서 치료배정 받으면 ING로 status컬럼값 변경
			System.out.println("몇번 침대에 배정됐는지 : " + bed.getBedID());
			
			reservationDao.updateReservationBedID(reservation.getReservationID(), bed.getBedID());
			System.out.println("몇번예약에 침대가 배정됐느지 : " + reservation.getReservationID() + "예약VO에 배정된 bedID " + reservation.getBedID() + "환자가 들어간 bedID" + bed.getBedID());
			
			reservationDao.updateReservationStatus(reservation.getReservationID(), "ING");
			System.out.println("ING된 reservationID : " + reservation.getReservationID());
			
			//메모리에서 status값 ING로 변경
			reservation.setBedID(bed.getBedID());
			System.out.println("reservationVO에 설정된 getBedID : " + bed.getBedID());
			reservation.setStatus("ING");
			return bed;
		}
		System.out.println("No empty beds available for Reservation ID: " + reservation.getReservationID());
		return null; //비어있는 침대가 없는경우
	}

	@Override
	public void updateBedStatusByReservation(int reservationID, String status) throws Exception {
		int bedID = reservationDao.selectBedIDByReservationID(reservationID);
		System.out.println("치료완료된 BedID : " + bedID);
		if(bedID != 0) {
			treatmentDao.updateBedStatus(bedID, status);
		}
	}

	@Override
	public List<TreatmentRoomStatusVO> getEmptyBeds() throws Exception {
		return treatmentDao.getEmptyBeds();
	}

	@Override
	public int getDoctorIdByUserID(String userID) throws Exception {
		return treatmentDao.selectDoctorIdByUserID(userID);
	}

	@Override
	public String getUserIdByDoctorId(int omdDoctorID) throws Exception {
		return treatmentDao.selectUserIdByDoctorId(omdDoctorID);
	}

	@Override
	public TreatmentRoomStatusVO getTreatmentRoomStatusByBedID(int bedID) throws Exception {
		
		return treatmentDao.selectTreatmentRoomStatusByBedID(bedID);
	}

	@Override
	public TreatmentRoomStatusVO getEmptyBed() throws Exception {
		
		return treatmentDao.findEmptyBed();
	}
    
	
	
}
