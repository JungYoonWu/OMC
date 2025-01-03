<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<strong>환영합니다.</strong>
<span><a href="javascript:void(0)" onclick="openMapPopup()">오시는길</a>></span>
<script>
	function openMapPopup(){
		window.open(
			"/OMC/jsp/include/mapPopup.jsp",
			"mapPopup",
			"width=600,height=600,scrollbars=yes"
		);
	}
</script>
