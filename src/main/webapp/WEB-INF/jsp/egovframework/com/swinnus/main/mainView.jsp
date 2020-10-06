<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp" %>
<!doctype html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><%=application.getInitParameter("pageTitle") %></title>
        <%@ include file="../include/common.jsp" %>
        <script src="/js/egovframework/com/swinnus/main/swinnus.black.main.js" type="text/javascript"></script>
	</head>
	<body>
		<form name="mainForm" action ="#" method="post">
			<h1>${loginVO.userNm }님 환영합니다. <a href="${pageContext.request.contextPath }/swinnus/login/logoutAction.do">로그아웃</a></h1>
			<br/>
			<h3>세션정보</h3>
			<h5>고유아이디 : ${loginVO.uniqId }</h5>
			<h5>아이디 : ${loginVO.userId }</h5>
			<h5>비밀번호 : ${loginVO.password }</h5>
			<h5>이름 : ${loginVO.userNm }</h5>
			<h5>이메일주소 : ${loginVO.emailAdres }</h5>
			<h5>휴대폰번호 : ${loginVO.mbtlNum }</h5>
			<h5>우편번호 : ${loginVO.zip }</h5>
			<h5>주소 : ${loginVO.adres }</h5>
			<h5>상세주소 : ${loginVO.detailAdres }</h5>
			<h5>그룹아이디 : ${loginVO.groupId }</h5>
			<h5>사용자상태코드 : ${loginVO.userSttusCode }</h5>
			<h5>사용자구분 : ${loginVO.userSe }</h5>
			<h5>조직(부서)아이디 : ${loginVO.orgnztId }</h5>
			<h5>조직(부서)명 : ${loginVO.orgnztNm }</h5>
			<h5>로그인 후 이동할 페이지 : ${loginVO.url }</h5>
		</form>
	</body>
</html>
