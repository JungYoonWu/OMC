<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminWriteNotice</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section>
        <c:if test="${not empty sessionScope.loginVO and sessionScope.loginVO.roleID != 1}">
            <form action="/OMC/admin/noticeWrite.yoon" method="post" name="noticeWriteForm" class="notice-form">
                <div>
                    <label for="noticeTitle">제목</label>
                    <input type="text" id="noticeTitle" name="title" required />
                </div>
                <div>
                    <label for="noticeContent">내용</label>
                    <input type="text" id="noticeContent" name="content" required />
                </div>
                <div>
                    <button type="submit">등록</button>
                </div>
            </form>
        </c:if>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
