<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet" href="/OMC/resources/css/OMC_1.css">
<link rel="stylesheet" href="/OMC/resources/css/OMC_2.css">
<script src="/OMC/resources/js/OMC.js"></script>
<script>
    let checkForm = function() {
        let id = document.loginForm.userID;
        let password = document.loginForm.password;
        if (checkBlank(id, 'ID를 입력하세요')) {
            return false;
        }
        if (checkBlank(password, 'PASSWORD를 입력하세요')) {
            return false;
        }
        return true;
    };
</script>
</head>
<body>
    <header>
        <jsp:include page="/jsp/include/topMenu.jsp" />
    </header>
    <section class="section-container">
        <div class="loginBox">
            <form action="/OMC/users/loginProcess.yoon" method="post" name="loginForm" onsubmit="return checkForm()">
                <div>
                    <label for="userID">ID</label>
                    <input type="text" id="userID" name="userID" />
                </div>
                <div>
                    <label for="password">PASSWORD</label>
                    <input type="password" id="password" name="password" />
                </div>
                <div>
                    <input id="loginBtn" type="submit" value="로그인" />
                </div>
            </form>
        </div>
    </section>
    <footer>
        <%@ include file="/jsp/include/footer.jsp" %>
    </footer>
</body>
</html>
