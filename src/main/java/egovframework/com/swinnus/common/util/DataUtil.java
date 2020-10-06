/**
 * DataUtil
 * @package egovframework.com.swinnus.cmm.util
 * @file DataUtil.java
 * @author 권민관
 * @date 2015. 2. 9. 오전 9:27:33
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

import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class DataUtil {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map getHashMapExcel(HttpServletRequest request) throws Exception {
		Map hm = new HashMap();
		Map map = new HashMap();
		
		try {
			
			hm = getParameterMapExcel(request.getParameterMap(), "", "");
			
			map = getCookie(request.getCookies());
			
			Iterator it = map.keySet().iterator();
			
			while (it.hasNext()) {
				Object key = it.next();
				String[] value = (String[]) map.get(key);
				
				hm.remove(key);
				hm.put(key, value);
			}
		} catch(Exception e) {
			throw e;
		}
		
		return hm;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map getParameterMapExcel(Map map, String fromCharset, String toCharset) throws Exception {
		
		Map hm = new HashMap();
		
		try {
			Iterator it = map.keySet().iterator();
			
			while (it.hasNext()) {
				Object key = it.next();
				String[] value = (String[]) map.get(key);
				
				if (fromCharset != null && !fromCharset.equals("") && toCharset != null && !toCharset.equals("")) {
					for (int i=0; i<value.length; i++) {
						value[i] = new String(value[i].getBytes(fromCharset), toCharset);
						
					}
				}
				
				for (int i=0; i<value.length; i++) {
					
				}
				hm.put(key, value);
			}
		} catch(Exception e) {
			throw e;
		}
		
		return hm;
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map getCookie(Cookie [] cookies) throws Exception {
		
		Map hm = new HashMap();
		try {
			if (cookies != null) {
				
				for (int i=0; i<cookies.length; i++) {
					String[] value = {URLDecoder.decode(cookies[i].getValue(), "UTF-8")};
					hm.put(cookies[i].getName(), value);
				}
			}
		} catch(Exception e) {
			throw e;
		}
		return hm;
	}
	
	@SuppressWarnings("rawtypes")
	public static Map getHashMap(HttpServletRequest request) throws Exception {
		Map hm = new HashMap();

		try {
			hm = getHashMap(request, "", "");
		} catch(Exception e) {
			throw e;
		}
		
		return hm;
	}

	@SuppressWarnings("rawtypes")
	public static Map getHashMap(HttpServletRequest request, String fromCharset, String toCharset) throws Exception {
		Map hm = new HashMap();

		try {
			hm = getHashMap(request, fromCharset, toCharset, "");
		} catch(Exception e) {
			throw e;
		}
		
		return hm;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map getHashMap(HttpServletRequest request, String fromCharset, String toCharset, String filePath) throws Exception {

		Map hm = new HashMap();
		Map map = new HashMap();

		try {
			/*if(ServletFileUpload.isMultipartContent(request)) {
				List fileList = new ArrayList();
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				
				if (fromCharset == null || fromCharset.equals("")) {
					fromCharset = "8859_1";
				}
				
				if (toCharset == null || toCharset.equals("")) {
					toCharset = request.getCharacterEncoding();
				}
				
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					
					if (item.isFormField()) {
						String fieldName = item.getFieldName();
						String fieldValue = item.getString();
						String[] oldValue, newValue;

						fieldValue = new String(fieldValue.getBytes(fromCharset), toCharset);
						String[] value = {fieldValue};
						
						if(hm.containsKey(fieldName)) {
							oldValue = (String[])hm.get(fieldName);
							hm.remove(fieldName);
							newValue = new String[oldValue.length+1];
							
							for(int j=0; j<oldValue.length; j++) {
								newValue[j] = oldValue[j];
							}
							
							newValue[oldValue.length] = value[0];
							hm.put(fieldName, newValue);
						} else {
							hm.put(fieldName, value);
						}
					} else {
						Map fileMap = new HashMap();
						String fieldName = item.getFieldName();
						String fileName = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
						String contentType = item.getContentType();
						long fileSize = item.getSize();
						
						if (fileSize > 0) {
							fileMap.put("fieldName", fieldName);
							fileMap.put("contentType", contentType);
							fileMap.put("fileSize", fileSize);
							
							if (filePath == null || filePath.equals("")) {
								fileMap.put("fileName", fileName);
								fileMap.put("fileData", item.get());
							} else {
								String tmpFileNm = FileUtil.getFileName(fileName,filePath);
								FileUtil.fileSave(item.get(), filePath, tmpFileNm);
								fileMap.put("filePath", filePath);
								fileMap.put("fileName", tmpFileNm);
							}
							
							fileList.add(fileMap);
						}
					}
				}
				
				hm.put("fileList", fileList);
			} else {
				hm = getParameterMap(request.getParameterMap(), fromCharset, toCharset);
			}*/
			hm = getParameterMap(request.getParameterMap(), fromCharset, toCharset);
			map = getCookie(request.getCookies());
	
			Iterator it = map.keySet().iterator();
			
			while (it.hasNext()) {
				Object key = it.next();
				String[] value = (String[]) map.get(key);
				
				hm.remove(key);
				hm.put(key, value);
			}
		} catch(Exception e) {
			throw e;
		}
		
		return hm;
	}
	
	@SuppressWarnings("rawtypes")
	public static Map getParameterMap(Map map) throws Exception {
		Map hm = new HashMap();
		
		try {
			hm = getParameterMap(map, "", "");
		} catch(Exception e) {
			throw e;
		}
		
		return hm;
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map getParameterMap(Map map, String fromCharset, String toCharset) throws Exception {
		Map hm = new HashMap();
		
		try {
			Iterator it = map.keySet().iterator();
	
			while (it.hasNext()) {
				Object key = it.next();
				String[] value = (String[]) map.get(key);
				
				if (fromCharset != null && !fromCharset.equals("") && toCharset != null && !toCharset.equals("")) {
					for (int i=0; i<value.length; i++) {
						value[i] = new String(value[i].getBytes(fromCharset), toCharset);
					}
				}
				hm.put(key, value);
			}
		} catch(Exception e) {
			throw e;
		}
		return hm;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map getOutput(Map map) throws Exception {
		Map hm = new HashMap();
		
		if(null == map || map.isEmpty())
			return hm;
		
		try {
			Iterator it = map.keySet().iterator();
	
			while (it.hasNext()) {
				Object key = it.next();
				Object value = map.get(key);
				
				if (value != null) {
					if (value instanceof String) {
						hm.put(key, (String)value);
					} else if (value instanceof String[]) {
						if (((String[]) value).length > 1) {
							hm.put(key, (String[])value);
						} else {
							hm.put(key, ((String[])value)[0] == null ? "" : ((String[])value)[0]);
						}
					} else {
						hm.put(key, value);
					}
				} else {
					hm.put(key, "");
				}
			}
		} catch(Exception e) {
			throw e;
		}
		return hm;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map getObjectToMap(Object obj) throws Exception{
        try {
        	if(obj == null){
        		return null;
        	}else{
        		//Field[] fields = obj.getClass().getFields(); //private field는 나오지 않음.
                Field[] fields = obj.getClass().getDeclaredFields();
                Map resultMap = new HashMap();
                for(int i=0; i<=fields.length-1;i++){
                    fields[i].setAccessible(true);
                    resultMap.put(fields[i].getName(), fields[i].get(obj));
                }
                return resultMap;
        	}
            
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
