/**
 * 공통 컨트롤러
 * @package egovframework.com.swinnus.common.web
 * @file CommonController.java
 * @author 권민관
 * @date 2015. 11. 3. 오후 3:01:03
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
package egovframework.com.swinnus.common.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.EgovMessageSource;

@Controller
public class CommonController {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);
	
	/** 메세지프로퍼티 */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	
	/**
	 * 접근제한 페이지로이동
	 * <pre>
	 * 1. 메소드명 : accessDenied
	 * 2. 작성일   : 2015. 11. 3. 오전 9:27:50
	 * 3. 작성자   : 권민관
	 * 4. 설명     : 접근제한 페이지로이동
	 * </pre>
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/swinnus/common/accessDenied.do")
	public String accessDenied(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
	    return "/egovframework/com/cmm/error/accessDenied";
	} 
}
