<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<nav class="navBox">
		<span>
			<a href="/OMC/index.jsp">
				<img src="/OMC/resources/img/logo.jpeg" alt="Logo" />
			</a>
		</span>
		
		<c:if test="${sessionScope.loginVO.roleID eq 2 or sessionScope.loginVO.roleID eq 3 or sessionScope.loginVO.roleID eq 4}">
		<span>
			<a href="/OMC/users/userinfo.yoon">회원관리</a>
		</span>
		<span>
			<a href="/OMC/notice/list.yoon">공지관리</a>
		</span>
		<span>
			<a href="/OMC/reservation/list.yoon">예약관리</a>
		</span>
		<span>
			<a href="/OMC/qna/list.yoon">문의관리</a>
		</span>
		</c:if>
		<c:if test="${sessionScope.loginVO.roleID eq 4 }">
		<span>
			<a href="/OMC/herbal/list.yoon">상품관리</a>
		</span>		
		</c:if>
		<c:if test="${empty sessionScope.loginVO or sessionScope.loginVO.roleID == 1}">
		<span>
			<a href="/OMC/reservation/list.yoon">예약</a>
		</span>
		<span>
			<a href="/OMC/notice/list.yoon">공지</a>
		</span>
		<span>
			<a href="/OMC/qna/list.yoon">문의</a>
		</span>
		<span>
			<a href="/OMC/herbal/list.yoon">한약구매</a>
		</span>
		<span>
			<a href="/OMC/treatment/treatment.yoon">침방확인</a>
		</span>		
		</c:if>
		<c:choose>
			<c:when test="${empty sessionScope.loginVO }">
				<span><a href="/OMC/users/login.yoon">로그인</a></span>
				<span><a href="/OMC/users/signUpForm.yoon">회원가입</a></span>
			</c:when>
			<c:when test="${not empty sessionScope.loginVO }">
				<span><a href="/OMC/users/mypage.yoon">회원정보</a></span>
				<span><a href="/OMC/users/logoutProcess.yoon">로그아웃</a></span>
			</c:when>
		</c:choose>
		<c:if test="${not empty sessionScope.loginVO }">
			<span>${sessionScope.loginVO.userID }님 환영합니다.</span>
		</c:if>
	</nav>
</div>