/**
 * 로그인 Service
 * @package egovframework.com.swinnus.login.service.impl
 * @file LoginServiceImpl.java
 * @author 권민관
 * @date 2015. 11. 3. 오후 2:37:48
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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.swinnus.common.util.EncryptUtil;
import egovframework.com.swinnus.login.service.LoginService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("loginService")
public class LoginServiceImpl extends EgovAbstractServiceImpl implements LoginService{

	@Resource(name="loginDAO")
    private LoginDAO loginDAO;

	/**
	 * 로그인처리
	 */
	@Override
	public LoginVO loginAction(LoginVO vo) throws Exception {
		String enpassword = EncryptUtil.encryptPassword(vo.getPassword(), vo.getUserId());
    	vo.setPassword(enpassword);

    	LoginVO loginVO = loginDAO.loginAction(vo);

    	if (loginVO != null && !loginVO.getUserId().equals("") && !loginVO.getPassword().equals("")) {
    		return loginVO;
    	} else {
    		loginVO = new LoginVO();
    	}
    	return loginVO;
	}
}

    
