<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>herbalDetail</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section>
        <div class="herbal-detail">
            <!-- 일반 사용자 또는 비로그인 사용자 -->
            <c:if test="${empty sessionScope.loginVO or sessionScope.loginVO.roleID eq 1}">
                <c:if test="${not empty herbalVO}">
                    <div><strong>상품명:</strong> <c:out value="${herbalVO.name}" /></div>
                    <div><strong>설명:</strong> <c:out value="${herbalVO.description}" /></div>
                    <div>
                        <a href="/OMC/herbal/cart.yoon"><span>장바구니 추가</span></a>
                    </div>
                </c:if>
                <c:if test="${empty herbalVO}">
                    <div class="no-product">판매중인 상품이 없습니다.</div>
                </c:if>
            </c:if>

            <!-- 관리자 -->
            <c:if test="${sessionScope.loginVO.roleID == 4}">
                <c:if test="${not empty herbalVO}">
                    <div><strong>상품명:</strong> <c:out value="${herbalVO.name}" /></div>
                    <div><strong>설명:</strong> <c:out value="${herbalVO.description}" /></div>
                    <div><strong>추천 여부:</strong> <c:out value="${herbalVO.seasonalRecommendation}" /></div>
                    <div>
                        <a href="/OMC/admin/herbalUpdate.yoon?medicineID=${herbalVO.medicineID}"><span>상품 수정</span></a>
                        <a href="/OMC/admin/herbalDelete.yoon?medicineID=${herbalVO.medicineID}"><span>상품 삭제</span></a>
                    </div>
                </c:if>
            </c:if>
        </div>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
