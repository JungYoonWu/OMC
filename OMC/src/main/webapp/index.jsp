<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
<script>
    if (window.location.pathname === '/OMC/index.jsp' || window.location.pathname ==='/OMC/users/loginProcess.yoon'
        || window.location.pathname ==='/OMC/users/logoutProcess.yoon') {
        window.location.href = '/OMC/OMC.yoon';
    }

    let doNoticeAction = function(noticeID) {
        location.href = '/OMC/notice/detail.yoon?noticeID=' + noticeID;
    }

    let doHerbalAction = function(name) {
        location.href = '/OMC/herbal/detail.yoon?name=' + name;
    }
</script>
</head>
<body class="index-page">
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section id="notice" class="index-notice-section">
        <div id="noticeContainer" class="index-notice-container">
            <c:forEach items="${requestScope.boardNoticeList}" var="boardNoticeVO">
                <a href="javascript:doNoticeAction(${boardNoticeVO.noticeID})" class="notice-title">
                    <c:if test="${sessionScope.loginVO.roleID eq 4}">
                        <c:out value="${boardNoticeVO.noticeID}" />
                    </c:if>
                    <c:out value="${boardNoticeVO.title}" />
                </a>
            </c:forEach>
        </div>
    </section>
    <section id="herbal" class="index-herbal-section">
        <div id="seasonalContainer" class="index-herbal-container">
            <c:forEach items="${herbalSRList}" var="herbalVO">
                <a href="javascript:doHerbalAction('${herbalVO.name}')" class="herbal-title">
                    <c:out value="${herbalVO.name}" />
                </a>
            </c:forEach>
        </div>
    </section>
    <section id="intro" class="index-intro-section">
        <div id="introContainer" class="index-intro-container">
            기사내용
        </div>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
