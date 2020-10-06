var browserBoolean = true;
$(function(){
	var IEIndex = navigator.appVersion.indexOf("MSIE");
	var IE8Over = navigator.userAgent.indexOf("Trident");
	var IEVer = 0;
  	if( IEIndex > 0 || IE8Over > 0 )  {
   		var trident = navigator.userAgent.match(/Trident\/(\d.\d)/i);
   		if (trident != null){
    		switch (trident[1]) {
     			case "7.0" :
     				IEVer = 11;
      				break;
     			case "6.0" :
     				IEVer = 10;
      				break;
   				case "5.0" :
   					IEVer = 9;
      				break;      
     			case "4.0" :
     				IEVer = 8;
      				break;
     			default :
      			break;
    		}
   		}   
   		if(IEVer < 9){
   	  		browserBoolean = false;
   	  		return;
   	  	}
  	}
});

$(document).ready(function () {
	var userId = $.cookie('userCookieId');
    if(userId != undefined) {
        $("#userId").val(userId);
        $("#checkId").prop("checked",true);
    }
});


function setCheckId(){
	var userId = document.loginForm.userId.value;
	$.cookie('userCookieId', userId, { expires: 365, secure: false });
}

function checkLogin(userSe) {
	// 일반회원
	if (userSe == "GNR") {
    	document.loginForm.rdoSlctUsr[0].checked = true;
    	document.loginForm.rdoSlctUsr[1].checked = false;
    	document.loginForm.rdoSlctUsr[2].checked = false;
    	document.loginForm.userSe.value = "GNR";
	// 기업회원
	} else if (userSe == "ENT") {
    	document.loginForm.rdoSlctUsr[0].checked = false;
    	document.loginForm.rdoSlctUsr[1].checked = true;
    	document.loginForm.rdoSlctUsr[2].checked = false;
    	document.loginForm.userSe.value = "ENT";
	// 업무사용자
	} else if (userSe == "SYS") {
    	document.loginForm.rdoSlctUsr[0].checked = false;
    	document.loginForm.rdoSlctUsr[1].checked = false;
    	document.loginForm.rdoSlctUsr[2].checked = true;
    	document.loginForm.userSe.value = "SYS";
	}
}

function loginAction() {
	
	if(browserBoolean == false){
		alert("익스플로러 9버전부터 사용하실수 있습니다.\n본사이트는 Internet Explorer 10에 최적화 되어있습니다.");
		return;
	}
	
    if (document.loginForm.userId.value =="") {
        alert("아이디를 입력하세요");
    } else if (document.loginForm.password.value =="") {
        alert("비밀번호를 입력하세요");
    } else {
        document.loginForm.action="/swinnus/login/loginAction.do";
        document.loginForm.submit();
    }
}
