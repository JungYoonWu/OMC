<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 등록</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section class="section-container inquiry-form">
        <c:if test="${not empty sessionScope.loginVO}">
            <form action="/OMC/qna/qProcess.yoon" method="post" name="qForm">
                <input type="hidden" name="userID" value="${sessionScope.loginVO.userID}" />
                <label for="qTitle">제목</label>
                <input type="text" id="qTitle" name="title" required />
                <label for="qContent">내용</label>
                <textarea rows="10" cols="30" id="qContent" name="content" required></textarea>
                <button type="submit">등록</button>
            </form>
        </c:if>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
