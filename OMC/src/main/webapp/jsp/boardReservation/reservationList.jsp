<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation List</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
<script>
    let doAction = function(reservationID) {
        location.href = '/OMC/reservation/detail.yoon?reservationID=' + reservationID;
    }
    
    let doReserve = function() {
        location.href = '/OMC/reservation/form.yoon';
    }
</script>
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>

    <section class="section-reservation">
        <h2>예약 목록</h2>

        <div class="reservation-container">
            <c:choose>
                <c:when test="${sessionScope.loginVO.roleID != 1 or empty sessionScope.loginVO}">
                    <c:forEach items="${reservationList}" var="reservationVO">
                        <div class="reservationList">
                            <span>ID:</span>
                            <span><c:out value="${reservationVO.userID}" /></span>
                            
                            <span>예약 날짜:</span>
                            <span><c:out value="${reservationVO.reservationDate}" /></span>
                            
                            <span>예약 시간:</span>
                            <span><c:out value="${reservationVO.reservationTime}" /></span>
                            
                            <a href="javascript:doAction(${reservationVO.reservationID})">확인</a>
                        </div>
                    </c:forEach>
                </c:when>

                <c:otherwise>
                    <c:forEach items="${reservationMyList}" var="reservationVO">
                        <div class="reservationList">
                            <span>ID:</span>
                            <span><c:out value="${reservationVO.userID}" /></span>
                            
                            <span>예약 날짜:</span>
                            <span><c:out value="${reservationVO.reservationDate}" /></span>
                            
                            <span>예약 시간:</span>
                            <span><c:out value="${reservationVO.reservationTime}" /></span>
                            
                            <a href="javascript:doAction(${reservationVO.reservationID})">확인</a>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>

        <button id="reserveBtn">
            <a href="javascript:doReserve()">예약</a>
        </button>

        <c:if test="${not empty totalPage && totalPage > 1}">
            <div class="paging">

                <!-- 이전 페이지 -->
                <c:if test="${currentPage > 1}">
                    <a href="?page=${currentPage - 1}">이전</a>
                </c:if>

                <c:forEach begin="1" end="${totalPage}" var="p">
                    <c:choose>
                        <c:when test="${p == currentPage}">
                            <strong>[${p}]</strong>
                        </c:when>
                        <c:otherwise>
                            <a href="?page=${p}">${p}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${currentPage < totalPage}">
                    <a href="?page=${currentPage + 1}">다음</a>
                </c:if>

            </div>
        </c:if>
    </section>

    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
