/**
 * 문자관련 유틸
 * @package egovframework.com.swinnus.cmm.util
 * @file StringUtil.java
 * @author 권민관
 * @date 2015. 2. 9. 오전 9:28:37
 * @version 1.0 
 * @see
 *
 * <pre>
 
 *   수정일          수정자         수정내용 
 *  -------       --------     --------------------------- 
 *  2015. 2. 9.   권민관         최초 생성 
 * 
 * Copyright (C) 2015 by (주)에스위너스 All right reserved.
 *
 * </pre>
 */
package egovframework.com.swinnus.common.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class StringUtil {

	/**
	 * NULL 값을 "" 형태로 치환해주는 메소드
	 * <pre>
	 * 1. 메소드명 : null2void
	 * 2. 작성일   : 2014. 12. 23. 오전 11:20:56
	 * 3. 작성자   : 권민관
	 * 4. 설명     : NULL 값을 "" 형태로 치환해주는 메소드
	 * </pre>
	 * @param Object 유형의 치환 대상
	 * @return 치환된 문자열
	 */
	public static String null2void(Object param) throws Exception{
		String str = new String();
		
		if (param == null) {
			return "";
		}
		
		if (param instanceof String) {
			str = (String) param;
		} else if (param instanceof String[]) {
			str = ((String[]) param)[0];
		} else if (param instanceof Date) {
			str = ((Date)param).toString();
		} else {
			str = String.valueOf(param);
		}
		
		if (str.equals("")) {
			return "";
		} else {
			return str.trim();
		}
	}
	
	/**
	 * null값을 0으로 치환해주는 메소드
	 * <pre>
	 * 1. 메소드명 : null2Int
	 * 2. 작성일   : 2014. 12. 24. 오후 1:50:19
	 * 3. 작성자   : 권민관
	 * 4. 설명     : null값을 0으로 치환해주는 메소드
	 * </pre>
	 * @param Object 유형의 치환 대상
	 * @return 치환된 숫자
	 */
	public static int null2Int(Object param) throws Exception{
		String str = new String();
		
		if (param == null) {
			return 0;
		}

		if (param instanceof String) {
			str = (String) param;
		} else if (param instanceof String[]) {
			str = ((String[]) param)[0];
		} else {
			str = String.valueOf(param);
		}
		
		if (str.equals("")) {
			return 0;
		} else {
			return Integer.parseInt(str);
		}
	}
	
	/**
	 * 클라이언트 IP주소 가져오기
	 * <pre>
	 * 1. 메소드명 : getUserIp
	 * 2. 작성일   : 2015. 1. 6. 오후 5:01:35
	 * 3. 작성자   : 권민관
	 * 4. 설명     : 
	 * </pre>
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static String getUserIp(HttpServletRequest request) throws Exception{
		String ipAddr = "";
		try {
			ipAddr = StringUtil.null2void(request.getRemoteAddr());
			if(ipAddr.equals("0:0:0:0:0:0:0:1")){
				ipAddr = "127.0.0.1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ipAddr;
	}
	
	/**
	 * 클라이언트 IP주소 가져오기2
	 * <pre>
	 * 1. 메소드명 : getUserIp
	 * 2. 작성일   : 2014. 12. 24. 오후 1:50:19
	 * 3. 작성자   : 권민관
	 * 4. 설명     : 클라이언트 IP주소 가져오기2
	 * </pre>
	 * @param request
	 * @return IPv4
	 */
	public static String getUserIp2(HttpServletRequest request) throws Exception{
        String clientIp = request.getHeader("x-forwarded-for");

        if(clientIp == null){
        	clientIp = request.getHeader("WL-Proxy-Client-IP");
		    if(clientIp == null){
		        clientIp = request.getHeader("Proxy-Client-IP");
		        if(clientIp == null){
		        	clientIp = request.getRemoteAddr();
		        }
		    }
	    }
        return clientIp;
	}
	
	/**
	 * 서버 IP주소 가져오기
	 * <pre>
	 * 1. 메소드명 : getServerIp
	 * 2. 작성일   : 2015. 8. 24. 오전 11:24:42
	 * 3. 작성자   : 권민관
	 * 4. 설명     : 서버 IP주소 가져오기
	 * </pre>
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static String getServerIp(HttpServletRequest request) throws Exception{
		String hostAddr = "";

		try {
			Enumeration<NetworkInterface> nienum = NetworkInterface.getNetworkInterfaces();
			while (nienum.hasMoreElements()) {
				NetworkInterface ni = nienum.nextElement();
				Enumeration<InetAddress> kk= ni.getInetAddresses();

				while (kk.hasMoreElements()) {
					InetAddress inetAddress = kk.nextElement();
					if (!inetAddress.isLoopbackAddress() && 
							!inetAddress.isLinkLocalAddress() && 
								inetAddress.isSiteLocalAddress()) {
					 hostAddr = inetAddress.getHostAddress().toString();
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return hostAddr; 
	}
	
	/**
	 * 전화번호, 휴대폰번호 자르기 정규식
	 * <pre>
	 * 1. 메소드명 : getTelPhoneSpliter
	 * 2. 작성일   : 2015. 1. 29. 오전 9:58:06
	 * 3. 작성자   : 권민관
	 * 4. 설명     : 전화번호, 휴대폰번호 자르기 정규식
	 * </pre>
	 * @param noStr
	 * @return
	 */
    public static String[] getTelPhoneSpliter(String noStr) throws Exception{
        Pattern tellPattern = Pattern.compile( "^(01\\d{1}|02|0505|0502|0506|0\\d{1,2})-?(\\d{3,4})-?(\\d{4})");
        if(noStr == null) return new String[]{ "", "", ""};
        
        Matcher matcher = tellPattern.matcher( noStr);

		if(matcher.matches()) {
		    return new String[]{ matcher.group( 1), matcher.group( 2), matcher.group( 3)};
	    }else{
			String str1 = StringUtil.null2void(noStr).substring(0, 3);
			String str2 = StringUtil.null2void(noStr).substring(3, 7);
			String str3 = StringUtil.null2void(noStr).substring(7, 11);
		    return new String[]{ str1, str2, str3};
		}
	}
    
    /**
     * 특수문자제거
     * <pre>
     * 1. 메소드명 : StrReplace
     * 2. 작성일   : 2015. 5. 21. 오후 5:42:20
     * 3. 작성자   : 권민관
     * 4. 설명     : 특수문자제거
     * </pre>
     * @param str
     * @return
     */
    public static String replaceStrUtil(String str) throws Exception{       
        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
        str = str.replaceAll(match, "");
        return str;
     }

    /**
     * 중복배열제거
     * <pre>
     * 1. 메소드명 : removeDuplicateArray
     * 2. 작성일   : 2015. 6. 9. 오후 1:22:49
     * 3. 작성자   : 권민관
     * 4. 설명     : 중복배열제거
     * </pre>
     * @param array
     * @return
     * @throws Exception
     */
    public static Object[] removeDuplicateArray(String[] array) throws Exception{
    	Object[] removeArray = null;
  	  	TreeSet<String> ts= new TreeSet<String>();
  	  	for(int i=0; i<array.length; i++){
  	  	    ts.add(array[i]);
  	  	}
  	  	removeArray= ts.toArray();
     	return removeArray;
    }
    
}
