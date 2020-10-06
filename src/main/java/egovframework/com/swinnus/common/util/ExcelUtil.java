/**
 * 엑셀업로드 다운로드 관련 유틸
 * @package egovframework.com.swinnus.cmm.util
 * @file ExcelUtil.java
 * @author 권민관
 * @date 2015. 2. 9. 오전 9:28:04
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

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcelUtil {

	@SuppressWarnings("rawtypes")
	public static void outputExcel(HttpServletRequest request, HttpServletResponse response){
		Map inHm = new HashMap();
		
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		
		PrintWriter out = null;
		
		String xlsData = new String();
		String xlsName = new String();
		
		try {
			
			inHm = DataUtil.getHashMapExcel(request);
			
			out = response.getWriter();
			
			xlsData = StringUtil.null2void(inHm.get("xlsData"));
			
			xlsName = StringUtil.null2void(inHm.get("xlsName")) + ".xls";
			String orgName = URLEncoder.encode(xlsName, "UTF-8");
			response.setHeader("Cache-control","no_cache");
			response.setHeader("Content-Type", "application/octet-stream;"); 
			response.setHeader("Content-Disposition", "attachment; filename="+orgName); 
			response.setHeader("Content-Description", "JSP Generated Data"); 
			response.setHeader("Pragma", "no_cache"); 
			response.setHeader("Expires", "-1"); 
			
			xlsData = xlsData.replaceAll("border=\"0\"","border=\"1\"");
			xlsData = xlsData.replaceAll("border=0","border=1");
			xlsData = "<html><head><meta http-equiv='Content-Type' content='application/vnd.ms-excel;charset=utf-8'></head>" + xlsData;
			out.print(xlsData);
			
		} catch (Exception e) {
			out.println("Error Occured<br>");
			out.println(e.toString());
		} finally{
			out.close();
		}
	}
}
