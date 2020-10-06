/**
 * 로그인 컨트롤러
 * @package egovframework.com.swinnus.login
 * @file LoginController.java
 * @author 권민관
 * @date 2015. 11. 3. 오후 2:35:41
 * @version 1.0 
 * @see
 *
 * <pre>
 
 *   수정일          수정자         수정내용 
 *  -------       --------     --------------------------- 
 *  2015. 11. 3.   권민관         최초 생성 
 * 
 * Copyright (C) 2015 by (주)에스위너스 All right reserved.
 *
 * </pre>
 */
package egovframework.com.swinnus.login.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.swinnus.login.service.LoginService;

@Controller
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	/** 메시지프로퍼티 */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	
	/** 로그인서비스 */
	@Resource(name = "loginService")
	private LoginService loginService;
	
	/**
	 * 로그인 페이지로 이동
	 * <pre>
	 * 1. 메소드명 : loginView
	 * 2. 작성일   : 2015. 11. 3. 오후 2:42:55
	 * 3. 작성자   : 권민관
	 * 4. 설명     : 로그인 페이지로 이동
	 * </pre>
	 * @param loginVO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/swinnus/login/loginView.do")
	public String loginView(@ModelAttribute("loginVO") LoginVO loginVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		return "egovframework/com/swinnus/login/loginView";
	}
	
	/**
	 * 메인페이지로 이동
	 * <pre>
	 * 1. 메소드명 : mainView
	 * 2. 작성일   : 2015. 11. 3. 오후 2:46:02
	 * 3. 작성자   : 권민관
	 * 4. 설명     : 메인페이지로 이동 
	 * </pre>
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/swinnus/main/mainView.do")
	public String mainView(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {

		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
		if (!isAuthenticated) {
			model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
			return "egovframework/com/swinnus/login/loginView";
		}
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		LOGGER.debug("User Id : {}", user.getUserId());

		return "egovframework/com/swinnus/main/mainView";
	}
}
