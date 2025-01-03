<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Treatment Room</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
<style>
.bed {
    position: relative;
    width: 100px;
    height: 100px;
    border: 1px solid #000;
    margin: 10px;
    display: inline-block;
}

.status {
    width: 100%;
    height: 80%;
    background-color: white; /* 기본 색상 */
}

.status.empty {
    background-color: white;
}

.status.ing {
    background-color: orange;
}

.status.done {
    background-color: grey;
}

.doctor {
    text-align: center;
    font-weight: bold;
}

.blinking {
    animation: blinker 1s linear infinite;
}

@keyframes blinker {  
    50% { opacity: 0; }
}
</style>
<script src="/OMC/resources/js/jquery-3.7.1.min.js"></script>
<script src="/OMC/resources/js/OMC.js"></script>
<script>
$(document).ready(function () {
	fetchTreatmentRoomStatus();
	
    function fetchTreatmentRoomStatus() {
        $.ajax({
            url: '/OMC/reservation/getTreatmentRoomStatus.yoon',
            type: 'GET',
            data: { action: 'getTreatmentRoomStatus' },
            dataType: 'json',
            success: function(data){
            	//data : {treatmentRoomStatusList, doctorReservationMap, reservationBedMap, doctorTimeSlotsMap}
                //1.의사별 예약 갱신
            	renderDoctorSections(data.doctorReservationMap, data.doctorTimeSlotsMap);
                //2.침대 상태 갱신
                renderTreatmentRoomStatus(data.treatmentRoomStatusList);
            },
            error: function(xhr, status, error){
                console.error('Error fetching treatment room status:', error);
            }
        });
    }

    //의사별 예약 시간 + 예약 현황 표시 
    function renderDoctorSections(doctorReservationMap, doctorTimeSlotsMap) {
        let container = $('#doctorSections');
        container.empty();
        
        $.each(doctorReservationMap, function(userID, doctorData){
            let doctorDiv = $('<div class="doctor-section"></div>');
            doctorDiv.append('<h3>한의사 ' + doctorData.name + '</h3>');
            
            let timeSlots = doctorTimeSlotsMap[userID];
            let timeList = $('<div class="time-slots"></div>');
            
            $.each(timeSlots, function(index, slotTime){
                let timeBox = $('<div class="time-box"></div>');
                let foundReservation = findReservationAtTime(doctorData.reservations, slotTime);
                
                if(foundReservation){
                	if(foundReservation.status==='YES'){
                		timeBox.addClass('reserved');
                		timeBox.text(slotTime+ ' 예약됨')
                	}else if(foundReservation.status==='ING'){
                		timeBox.addClass('reserved');
                		timeBox.text(slotTime + '치료중');
                	}else if(foundReservation.status==='DONE'){
                		timeBox.addClass('done');
                		timeBox.text(slotTime + ' 완료')
                	}else{
                		timeBox.addClass('available')
                		timeBox.text(slotTime + ' 비어있음')
                	}
                }else{
                	timeBox.addClass('available')
                	timeBox.text(slotTime + ' 비어있음')
                }
             
                timeList.append(timeBox);
            });
            doctorDiv.append(timeList);
            container.append(doctorDiv);
        });
    }

	function findReservationAtTime(reservations, slotTime){
		for(let i = 0; i < reservations.length; i++){
			let reservTime = reservations[i].reservationTime.substring(11,16); //HH:mm
			if(reservTime === slotTime){
				return reservations[i];
			}
		}
		return null;
	}
    
    function renderTreatmentRoomStatus(treatmentRoomStatusList) {
        let container = $('#treatmentRoomStatus');
        container.empty();
        
        $.each(treatmentRoomStatusList, function(index, bed){
            let bedDiv = $('<div class="bed"></div>');
            bedDiv.attr('id', 'bed' + bed.bedNumber);
            let statusDiv = $('<div class="status"></div>');
            let doctorDiv = $('<div class="doctor"></div>');

            if(bed.bedStatus === 'ing') {
                statusDiv.addClass('ing');
                doctorDiv.text(bed.doctorName);
                // 깜빡임 효과 추가
                statusDiv.addClass('blinking');
            } else if(bed.bedStatus === 'done') {
                statusDiv.addClass('done');
                statusDiv.removeClass('blinking');
                doctorDiv.text('');
            } else {
                statusDiv.addClass('empty');
                statusDiv.removeClass('blinking');
                doctorDiv.text('');
            }

            bedDiv.append(statusDiv);
            bedDiv.append(doctorDiv);
            container.append(bedDiv);
        });
    }


    // 초기 데이터 로드
    fetchTreatmentRoomStatus();

    // 1분마다 데이터 업데이트
    setInterval(fetchTreatmentRoomStatus, 60*1000);
});
</script>
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    
    <section>
        <!-- 의사별 예약 정보 출력 -->
        <div id="doctorSections">
            <!-- AJAX로 동적으로 채워질 부분 -->
        </div>
        
        <!-- 침대 상태 표시 -->
        <div id="treatmentRoomStatus">
            <!-- AJAX로 동적으로 채워질 부분 -->
        </div>
    </section>
    
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
