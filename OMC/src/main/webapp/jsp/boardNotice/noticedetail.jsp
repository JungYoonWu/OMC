<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticedetail</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section>
        <h2>공지사항</h2>
        <div class="notice-detail">
            <c:if test="${not empty boardNoticeVO}">
                <div><strong>제목:</strong> <c:out value="${boardNoticeVO.title}" /></div>
                <div><strong>내용:</strong> <c:out value="${boardNoticeVO.content}" /></div>
                <div><strong>등록일:</strong> <c:out value="${boardNoticeVO.regDate}" /></div>
                <c:if test="${sessionScope.loginVO.roleID eq 4}">
                    <div>
                        <a href="/OMC/admin/noticeUpdateForm.yoon?noticeID=${boardNoticeVO.noticeID}">수정</a>
                        <a href="/OMC/admin/noticeDelete.yoon?noticeID=${boardNoticeVO.noticeID}">삭제</a>
                    </div>
                </c:if>
            </c:if>
            <c:if test="${empty boardNoticeVO}">
                <div>해당 공지사항이 없습니다.</div>
            </c:if>
        </div>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
