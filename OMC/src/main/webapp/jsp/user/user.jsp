<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
<script>
    let doAction = function(userID) {
        location.href = '/OMC/users/userdetail.yoon?userID=' + userID;
    };
</script>
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section class="section-container">
        <h2>사용자 목록</h2>
        <div class="container">
            <c:forEach items="${userList}" var="userVO">
                <a href="javascript:doAction('${userVO.userID}')">
                    <div class="userInfo">
                        <c:out value="${userVO.userID}" />
                    </div>
                </a>
            </c:forEach>
        </div>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
