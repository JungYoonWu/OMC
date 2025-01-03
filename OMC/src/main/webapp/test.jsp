<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<script>
	let doAction = function(noticeID){
		location.href = '/OMC/notice/detail.yoon?noticeID='+noticeID
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section id="notice">
		<div id="noticeContainer">
			<div class="container">
				<c:forEach items="${boardNoticeList }" var="boardNoticeVO">
					<a href="javascript:doAction(${boardNoticeVO.noticeID })">
					<div class="noticeTitle">
						<c:out value="${boardNoticeVO.noticeID }"/>
						<c:out value="${boardNoticeVO.title }"/>
					</div>				
					</a>
				</c:forEach>
			</div>
		</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>