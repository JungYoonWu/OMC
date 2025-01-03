<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation Detail</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section class="section-reservation">
        <h2>예약 내용</h2>
        <div class="reservation-details">
            <c:if test="${not empty reservationVO}">
                <div><strong>사용자 ID:</strong> <c:out value="${reservationVO.userID}" /></div>
                <div><strong>예약 날짜:</strong> <c:out value="${reservationVO.reservationDate}" /></div>
                <div><strong>예약 시간:</strong> <c:out value="${reservationVO.reservationTime}" /></div>
                <div><strong>상태:</strong> <c:out value="${reservationVO.status}" /></div>
            </c:if>
            <c:if test="${empty reservationVO}">
                <div class="reservation-empty">예약 내용이 없습니다.</div>
            </c:if>
        </div>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
