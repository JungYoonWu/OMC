<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticelist</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
<script>
    let doAction = function(noticeID) {
        location.href = '/OMC/notice/detail.yoon?noticeID=' + noticeID;
    }
</script>
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section>
        <h2>공지사항</h2>
        <div class="list-container">
            <c:forEach items="${boardNoticeList}" var="boardNoticeVO">
                <a href="javascript:doAction(${boardNoticeVO.noticeID})" class="list-item">
                    <div><c:out value="${boardNoticeVO.title}" /></div>
                </a>
            </c:forEach>
            <c:if test="${sessionScope.loginVO.roleID == 4 or sessionScope.loginVO.roleID == 3 or sessionScope.loginVO.roleID == 2}">
                <a href="/OMC/admin/noticeWriteForm.yoon" class="list-button">등록</a>
            </c:if>
        </div>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
