<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 목록</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
<script>
    let doAction = function(userID, inquiryID) {
        location.href = '/OMC/qna/detail.yoon?userID=' + userID + '&inquiryID=' + inquiryID;
    }
</script>
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>

    <section class="section-container inquiry-container">
        
        <c:if test="${empty sessionScope.loginVO}">
            <div class="login-message">로그인 후 이용 가능합니다.</div>
        </c:if>

        <c:if test="${not empty sessionScope.loginVO}">
            <c:choose>
                <c:when test="${sessionScope.loginVO.roleID eq 1}">
                    <c:forEach items="${inquiryMyList}" var="inquiryVO">
                        <a href="javascript:doAction('${inquiryVO.userID}', ${inquiryVO.inquiryID})" 
                           class="inquiry-item">
                            <c:out value="${inquiryVO.title}" />
                        </a>
                    </c:forEach>
                    <a href="/OMC/qna/qForm.yoon" class="link-button">문의 등록</a>

                    <c:if test="${not empty totalPage && totalPage > 1}">
                        <div class="paging">
                            <c:if test="${currentPage > 1}">
                                <a href="?page=${currentPage-1}">이전</a>
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
                                <a href="?page=${currentPage+1}">다음</a>
                            </c:if>
                        </div>
                    </c:if>
                </c:when>
                
                <c:otherwise>
                    <c:forEach items="${inquiryList}" var="inquiryVO">
                        <a href="javascript:doAction('${inquiryVO.userID}', ${inquiryVO.inquiryID})"
                           class="inquiry-item">
                            <c:out value="${inquiryVO.title}" />
                        </a>
                    </c:forEach>

                    <c:if test="${not empty totalPage && totalPage > 1}">
                        <div class="paging">
                            <c:if test="${currentPage > 1}">
                                <a href="?page=${currentPage-1}">이전</a>
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
                                <a href="?page=${currentPage+1}">다음</a>
                            </c:if>
                        </div>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </c:if>
    </section>

    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
