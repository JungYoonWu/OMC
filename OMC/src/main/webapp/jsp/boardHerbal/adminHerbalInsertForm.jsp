<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminherbalinsertform</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section>
        <c:if test="${sessionScope.loginVO.roleID eq 4}">
        <div>
            <form action="/OMC/admin/herbalInsert.yoon" method="post" name="herbalInsertForm" class="herbal-form">
                <!-- 한약명 -->
                <div class="form-group">
                    <label for="name">한약명</label>
                    <input type="text" id="name" name="name" required />
                </div>
                <!-- 설명 -->
                <div class="form-group">
                    <label for="description">설명</label>
                    <textarea rows="10" cols="20" id="description" name="description">${description}</textarea>
                </div>
                <!-- 추천 여부 -->
                <div class="form-group">
                    <fieldset class="form-fieldset">
                        <legend>추천 여부:</legend>
                        <span class="form-radio-group">
                            <input type="radio" id="yes" name="seasonalRecommendation" value="Y" />
                            <label for="yes">Y</label>
                        </span>
                        <span class="form-radio-group">
                            <input type="radio" id="no" name="seasonalRecommendation" value="N" checked />
                            <label for="no">N</label>
                        </span>
                    </fieldset>
                </div>
                <!-- 등록 버튼 -->
                <div class="form-group">
                    <button type="submit" class="form-submit">등록</button>
                </div>
            </form>
        </div>
        </c:if>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>