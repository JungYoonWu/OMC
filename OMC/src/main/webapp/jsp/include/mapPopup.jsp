<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>오시는 길</title>
</head>
<body>

<!-- 지도를 표시할 영역 -->
<div id="map" style="width: 100%; height: 90%;"></div>

<!-- 카카오 지도 API 로드 (appkey는 본인의 키로 교체) -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7419f38f96eae0c7069568086a844265"></script>
<script>
    var container = document.getElementById('map');
    var options = {
        center: new kakao.maps.LatLng(37.2362783, 127.2038322), // 약손한의원
        level: 3
    };

    // 지도 표시
    var map = new kakao.maps.Map(container, options);

    // 마커 표시
    var markerPosition  = new kakao.maps.LatLng(37.2362783, 127.2038322);
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });
    marker.setMap(map);

    // 인포윈도우(말풍선)
    var infowindow = new kakao.maps.InfoWindow({
        content: '<div style="padding:5px;">오시는 길 안내</div>'
    });
    infowindow.open(map, marker);
</script>

</body>
</html>
