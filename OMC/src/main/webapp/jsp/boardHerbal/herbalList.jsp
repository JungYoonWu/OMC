<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>herbalList</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
<script>
let doHerbalAction = function(name) {
    location.href = '/OMC/herbal/detail.yoon?name=' + name;
}
</script>
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section>
        <div class="container">
            <!-- 상품 목록 -->
            <c:forEach items="${herbalList}" var="herbalVO">
                <div class="herbal-item">
                    <a href="javascript:doHerbalAction('${herbalVO.name}')">
                        <div class="herbalTitle">
                            <c:out value="${herbalVO.name}" />
                        </div>
                    </a>
                    <!-- 관리자 버튼 -->
                    <c:if test="${sessionScope.loginVO.roleID eq 4}">
                        <div>
                            <a href="/OMC/admin/herbalUpdate.yoon?medicineID=${herbalVO.medicineID}" class="herbal-button">
                                <span>상품 수정</span>
                            </a>
                            <a href="/OMC/admin/herbalDelete.yoon?medicineID=${herbalVO.medicineID}" class="herbal-button">
                                <span>상품 삭제</span>
                            </a>
                        </div>
                    </c:if>
                </div>
            </c:forEach>
            <!-- 관리자: 상품 등록 버튼 -->
 
            <!-- 상품이 없을 때 -->
            <c:if test="${empty herbalList and sessionScope.loginVO.roleID eq 4}">
                <div class="no-products">
                    등록된 상품이 없습니다.
                    <a href="/OMC/herbal/insertForm.yoon" class="herbal-add-button">상품 등록</a>
                </div>
            </c:if>
        </div>
            <div>
            <c:if test="${sessionScope.loginVO.roleID eq 4}">
                <a href="/OMC/herbal/insertForm.yoon" class="herbal-add-button">상품 등록</a>
            </c:if>
            </div>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
