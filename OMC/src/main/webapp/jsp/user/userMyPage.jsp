<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
<section class="section-container">
    <h2>회원정보</h2>
    <div class="userInfo">
        <c:if test="${not empty loginVO}">
            <div><strong>ID:</strong> <c:out value="${loginVO.userID}" /></div>
            <div><strong>이름:</strong> <c:out value="${loginVO.name}" /></div>
            <div><strong>Email:</strong> <c:out value="${loginVO.email}" /></div>
            <div><strong>전화번호:</strong> <c:out value="${loginVO.phone}" /></div>
        </c:if>
        <c:if test="${empty loginVO}">
            <div>회원정보가 없습니다.</div>
        </c:if>
    </div>
</section>

	<footer>
		<%@ include file="/jsp/include/footer.jsp" %>
	</footer>
		
</body>
</html>