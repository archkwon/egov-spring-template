/**
 * 로그인 DATA ACCESS OBJECT
 * @package egovframework.com.swinnus.login.service.impl
 * @file LoginDAO.java
 * @author 권민관
 * @date 2015. 11. 3. 오후 2:37:53
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
package egovframework.com.swinnus.login.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository("loginDAO")
public class LoginDAO extends EgovComAbstractDAO{

	/**
	 * 로그인처리
	 * <pre>
	 * 1. 메소드명 : loginAction
	 * 2. 작성일   : 2015. 11. 3. 오후 2:58:33
	 * 3. 작성자   : 권민관
	 * 4. 설명     : 로그인처리
	 * </pre>
	 * @param loginVO
	 * @return
	 * @throws Exception
	 */
    public LoginVO loginAction(LoginVO loginVO) throws Exception {
    	return (LoginVO)select("loginDAO.loginAction", loginVO);
    }
}

