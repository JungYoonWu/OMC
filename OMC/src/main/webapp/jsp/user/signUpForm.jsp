<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Form</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section class="section-container form-container">
        <c:if test="${empty sessionScope.loginVO}">
            <form action="/OMC/users/signUpProcess.yoon" method="post" name="signUpForm">
                <label for="userID">ID</label>
                <input type="text" id="userID" name="userID" required />

                <label for="pwd">PASSWORD</label>
                <input type="password" id="pwd" name="password" required />

                <label for="email">Email</label>
                <input type="email" id="email" name="email" required />

                <label for="name">이름</label>
                <input type="text" id="name" name="name" required />

                <label for="phone">전화번호</label>
                <input type="tel" id="phone" name="phone" required />

                <button type="submit">가입하기</button>
            </form>
        </c:if>
        <c:if test="${not empty signUpError}">
            <div class="errorMsg">${signUpError}</div>
        </c:if>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
