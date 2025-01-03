<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inquiryDetail</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section class="section-container inquiry-detail-container">
        <div>
            <strong>제목:</strong> <c:out value="${inquiryVO.title}" />
        </div>
        <div>
            <strong>내용:</strong> <c:out value="${inquiryVO.content}" />
        </div>
        <div>
            <strong>등록일:</strong> <c:out value="${inquiryVO.regDate}" />
        </div>
        <div>
            <strong>상태:</strong> <c:out value="${inquiryVO.status}" />
        </div>

        <c:if test="${not empty replyVO}">
            <hr />
            <h3>답변</h3>
            <div>
                <strong>답변 내용:</strong> <c:out value="${replyVO.content}" />
            </div>
            <div>
                <strong>답변일:</strong> <c:out value="${replyVO.regDate}" />
            </div>
        </c:if>

        <c:if test="${sessionScope.loginVO.roleID == 4 or sessionScope.loginVO.roleID == 3 or sessionScope.loginVO.roleID == 2}">
            <form action="/OMC/qna/replyProcess.yoon" method="post">
                <input type="hidden" name="inquiryID" value="${inquiryVO.inquiryID}" />
                <input type="hidden" name="userID" value="${inquiryVO.userID}" />
                <label for="replyContent">답변 내용</label>
                <textarea id="replyContent" name="content" required></textarea>
                <button type="submit">답변 등록</button>
            </form>
        </c:if>

        <c:if test="${sessionScope.loginVO.roleID == 1}">
            <form action="/OMC/qna/qProcess.yoon" method="post">
                <input type="hidden" name="inquiryID" value="${inquiryVO.inquiryID}" />
                <label for="additionalContent">추가 문의</label>
                <textarea id="additionalContent" name="content" required></textarea>
                <button type="submit">문의 등록</button>
            </form>
        </c:if>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
