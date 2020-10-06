package egovframework.com.sec.security.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.support.WebApplicationContextUtils;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.swinnus.login.service.LoginService;

/**
 *
 * @author 공통서비스 개발팀 서준식
 * @since 2011. 8. 29.
 * @version 1.0
 * @see
 *
 * <pre>
 * 개정이력(Modification Information)
 *
 *     수정일                 수정자        	  수정내용
 *  -----------    --------   ---------------------------
 *  2011.08.29    	 서준식        	 최초생성
 *  2011.12.12      유지보수        사용자 로그인 정보 간섭 가능성 문제(멤버 변수 EgovUserDetails userDetails를 로컬변수로 변경)
 *  2014.03.07      유지보수        로그인된 상태에서 다시 로그인 시 미처리 되는 문제 수정 (로그인 처리 URL 파라미터화)
 *
 *  </pre>
 */

public class EgovSpringSecurityLoginFilter implements Filter {

	private FilterConfig config;

	private static final Logger LOGGER = LoggerFactory.getLogger(EgovSpringSecurityLoginFilter.class);

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		LOGGER.info("EgovSpringSecurityLoginFilter called...");

		String loginURL = config.getInitParameter("loginURL");
		loginURL = loginURL.replaceAll("\r", "").replaceAll("\n", "");

		String loginProcessURL = config.getInitParameter("loginProcessURL");
		loginProcessURL = loginProcessURL.replaceAll("\r", "").replaceAll("\n", "");

		ApplicationContext act = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		LoginService loginService = (LoginService) act.getBean("loginService");
		EgovMessageSource egovMessageSource = (EgovMessageSource) act.getBean("egovMessageSource");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		String requestURL = ((HttpServletRequest) request).getRequestURI();

		if (EgovUserDetailsHelper.getAuthenticatedUser() == null || requestURL.contains(loginProcessURL)) {
			if (requestURL.contains(loginProcessURL)) {
				String password = httpRequest.getParameter("password");
					
				if (password == null || password.equals("") || password.length() < 8 || password.length() > 20) {
					httpRequest.setAttribute("message", egovMessageSource.getMessage("fail.common.login.password"));
					RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginURL);
					dispatcher.forward(httpRequest, httpResponse);
					return;
				}

				LoginVO loginVO = new LoginVO();

				loginVO.setUserId(httpRequest.getParameter("userId"));
				loginVO.setPassword(password);
				loginVO.setUserSe(httpRequest.getParameter("userSe"));

				try {
					loginVO = loginService.loginAction(loginVO);
					if (loginVO != null && loginVO.getUserId() != null && !loginVO.getUserId().equals("")) {
						session.setAttribute("loginVO", loginVO);

						UsernamePasswordAuthenticationFilter springSecurity = null;

						Map<String, UsernamePasswordAuthenticationFilter> beans = act.getBeansOfType(UsernamePasswordAuthenticationFilter.class);
						if (beans.size() > 0) {
							springSecurity = (UsernamePasswordAuthenticationFilter) beans.values().toArray()[0];
						} else {
							LOGGER.error("No AuthenticationProcessingFilter");
							throw new IllegalStateException("No AuthenticationProcessingFilter");
						}
						springSecurity.setContinueChainBeforeSuccessfulAuthentication(false);

						LOGGER.debug("before security filter call....");
						springSecurity.doFilter(new RequestWrapperForSecurity(httpRequest, loginVO.getUserSe() + loginVO.getUserId(), loginVO.getUniqId()), httpResponse, chain);
						LOGGER.debug("after security filter call....");
					} else {
						httpRequest.setAttribute("message", egovMessageSource.getMessage("fail.common.login"));
						RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginURL);
						dispatcher.forward(httpRequest, httpResponse);
						return;
					}
				} catch (Exception ex) {
					LOGGER.error("Login Exception : {}", ex.getCause(), ex);
					httpRequest.setAttribute("message", egovMessageSource.getMessage("fail.common.login"));
					RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginURL);
					dispatcher.forward(httpRequest, httpResponse);
					return;
				}
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}
}

class RequestWrapperForSecurity extends HttpServletRequestWrapper {
	private String username = null;
	private String password = null;

	public RequestWrapperForSecurity(HttpServletRequest request, String username, String password) {
		super(request);

		this.username = username;
		this.password = password;
	}

	@Override
	public String getRequestURI() {
		return ((HttpServletRequest) super.getRequest()).getContextPath() + "/j_spring_security_check";
	}

	@Override
	public String getParameter(String name) {
		if (name.equals("j_username")) {
			return username;
		}

		if (name.equals("j_password")) {
			return password;
		}

		return super.getParameter(name);
	}
}
