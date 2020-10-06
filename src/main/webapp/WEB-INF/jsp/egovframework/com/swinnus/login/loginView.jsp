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
        <script src="/js/egovframework/com/swinnus/login/swinnus.black.login.js" type="text/javascript"></script>
	</head>
	<body>
		<form name="loginForm" action ="#" method="post">
			<input name="userSe" type="hidden" value="SYS"/>
	    	<table>
		    	<tr>
                    <td width="30"></td>
                    <td nowrap><input name="rdoSlctUsr" type="radio" value="radio" onClick="checkLogin('GNR');" tabindex="1">일반</td>
                    <td nowrap><input name="rdoSlctUsr" type="radio" value="radio" onClick="checkLogin('ENT');" tabindex="2">기업</td>
                    <td nowrap><input name="rdoSlctUsr" type="radio" value="radio" checked onClick="checkLogin('SYS');" tabindex="3">시스템</td>
                </tr>
		    </table>
		    <table>
                <tr>
                    <td class="required_text" nowrap><label for="id">아이디&nbsp;&nbsp;</label></td>
                    <td><input type="text" name="userId" id="userId" tabindex="4" maxlength="10"/></td>
                </tr>
                <tr>
                    <td class="required_text" nowrap><label for="password">비밀번호&nbsp;&nbsp;</label></td>
                    <td><input type="password" name="password" id="password" maxlength="12" tabindex="5" onKeyDown="javascript:if (event.keyCode == 13) { loginAction(); }"/></td>
                    <td class="title"><label for="checkId"><input type="checkbox" name="checkId" class="check2" onclick="javascript:setCheckId();" id="checkId" tabindex="6"/>ID저장</label></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td><span class="button"><a href="#LINK" onClick="loginAction();" tabindex="7">로그인</a></span></td>
                </tr>
            </table>
            <br/>
            <br/>
            <br/>
            <h3>※로그인아이디 : TEST1, 비밀번호 : rhdxhd12, 시스템체크 </h3> 		
            
		</form>
	</body>
</html>
