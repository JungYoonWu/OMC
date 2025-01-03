<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation Form</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
<script src="/OMC/resources/js/jquery-3.7.1.min.js"></script>
<script src="/OMC/resources/js/OMC.js"></script>
<script>
$(document).ready(function(){
	
    var today = new Date();
    today.setDate(today.getDate() + 1); // 내일 날짜로 설정
    var year = today.getFullYear();
    var month = ('0' + (today.getMonth() + 1)).slice(-2);
    var day = ('0' + today.getDate()).slice(-2);
    var minDate = year + '-' + month + '-' + day;
    $('#reservationDate').attr('min', minDate);
	
    function updateDoctors(){
        var reservationDate = $('#reservationDate').val();
        
        if(reservationDate){
            // AJAX 호출하여 의사 목록 가져오기
            $.ajax({
                url: '/OMC/reservation/getDoctors.yoon', // URL 수정
                type: 'GET',
                data: {
                    action: 'getDoctors',
                    reservationDate: reservationDate
                },
                dataType: 'json',
                success: function(data){
                    // 기존 옵션 제거
                    $('#doctorID').empty();
                    $('#doctorID').append('<option value="">-- 선택 --</option>');
                    // 새로운 옵션 추가
                    $.each(data, function(index, doctor){
                        $('#doctorID').append('<option value="' + doctor.omdDoctorID + '">' + doctor.doctorName + '</option>');
                    });
                },
                error: function(xhr, status, error){
                    console.error('Error fetching doctors:', error);
                    alert('의사 목록을 불러오는 데 실패했습니다.');
                }
            });
        } else {
            // 날짜가 선택되지 않은 경우 의사 목록 초기화
            $('#doctorID').empty();
            $('#doctorID').append('<option value="">-- 선택 --</option>');
        }
    }

    function updateTimeSlots(){
        var doctorID = $('#doctorID').val();
        var reservationDate = $('#reservationDate').val();
        
        if(doctorID && reservationDate){
            // AJAX 호출하여 시간대 가져오기
            $.ajax({
                url: '/OMC/reservation/getTimeSlots.yoon', // URL 수정
                type: 'GET',
                data: {
                    action: 'getTimeSlots',
                    doctorID: doctorID,
                    reservationDate: reservationDate
                },
                dataType: 'json',
                success: function(data){
                    // 기존 옵션 제거
                    $('#reservationTime').empty();
                    $('#reservationTime').append('<option value="">-- 선택 --</option>');
                    // 새로운 옵션 추가
                    $.each(data, function(index, slot){
                        if(slot.status === "reserved"){
                            $('#reservationTime').append('<option value="' + slot.time + '" disabled>' + slot.time + ' (예약됨)</option>');
                        } else {
                            $('#reservationTime').append('<option value="' + slot.time + '">' + slot.time + '</option>');
                        }
                    });
                },
                error: function(xhr, status, error){
                    console.error('Error fetching time slots:', error);
                    alert('의사의 근무 시간을 불러오는 데 실패했습니다.');
                }
            });
        } else {
            // 의사 또는 날짜가 선택되지 않은 경우 시간대 초기화
            $('#reservationTime').empty();
            $('#reservationTime').append('<option value="">-- 선택 --</option>');
        }
    }

    // 이벤트 리스너 추가
    $('#reservationDate').change(function(){
        updateDoctors();
        updateTimeSlots();
    });

    $('#doctorID').change(function(){
        updateTimeSlots();
    });

    // 페이지 로드 시 초기화
    updateDoctors();
    updateTimeSlots();

    function checkForm() {
        const reservationDate = document.getElementById('reservationDate').value;
        const reservationTime = document.getElementById('reservationTime').value;
        const treatmentID = document.getElementById('treatmentID').value;
        const doctorID = document.getElementById('doctorID').value;
        
        if (!reservationDate) {
            alert('예약 날짜를 선택해주세요.');
            return false;
        }
        if (!reservationTime) {
            alert('예약 시간을 선택해주세요.');
            return false;
        }
        if (!treatmentID) {
            alert('치료를 선택해주세요.');
            return false;
        }
        if (!doctorID) {
            alert('의사를 선택해주세요.');
            return false;
        }
        return true;
    }
});
</script>
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section class="section-reservation">
        <c:if test="${not empty sessionScope.loginVO}">
            <form action="/OMC/reservation/reserve.yoon" method="post" name="reservationForm" class="reservation-form" onsubmit="return checkForm()">
                <label for="reservationDate">예약 날짜:</label>
                <input type="date" id="reservationDate" name="reservationDate" required />

                <label for="doctorID">의사 선택:</label>
                <select id="doctorID" name="doctorID" required>
                    <option value="">-- 선택 --</option>
                    <!-- 의사 목록은 AJAX로 동적으로 로드 -->
                </select>
                
                <label for="reservationTime">예약 시간:</label>
                <select id="reservationTime" name="reservationTime" required>
                    <option value="">-- 선택 --</option>
                </select>
                
                <label for="treatmentID">치료 선택:</label>
                <select id="treatmentID" name="treatmentID" required>
                    <option value="2">침치료</option>
                </select>

                <input type="hidden" name="userID" value="${sessionScope.loginVO.userID}" />
                
                <button type="submit">예약하기</button>
            </form>
        </c:if>
        <c:if test="${not empty errorMessage }">
        	<script>
        		alert("${errorMessage}");
        	</script>
        </c:if>
        <c:if test="${empty sessionScope.loginVO}">
            <div class="reservation-empty">로그인 후 예약이 가능합니다.</div>
        </c:if>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
