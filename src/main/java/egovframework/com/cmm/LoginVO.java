/**
 * 로그인VO
 * @package egovframework.com.cmm
 * @file LoginVO.java
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
package egovframework.com.cmm;

import java.io.Serializable;

public class LoginVO implements Serializable{

	private static final long serialVersionUID = -8274004534207618049L;

	/** 고유아이디 */
	private String uniqId = "";
	
	/** 아이디 */
	private String userId = "";
	
	/** 비밀번호 */
	private String password = "";
	
	/** 이름 */
	private String userNm = "";
	
	/** 이메일주소 */
	private String emailAdres = "";
	
	/** 휴대폰번호 */
	private String mbtlNum = "";
	
	/** 우편번호 */
	private String zip = "";
	
	/** 주소 */
	private String adres = "";
	
	/** 상세주소 */
	private String detailAdres = "";
	
	/** 그룹아이디 */
	private String groupId = "";
	
	/** 사용자상태코드 */
	private String userSttusCode = "";
	
	/** 사용자구분 */
	private String userSe = "";
	
	/** 조직(부서)아이디 */
	private String orgnztId = "";
	
	/** 조직(부서)명 */
	private String orgnztNm = "";
	
	/** 로그인 후 이동할 페이지 */
	private String url = "";
	
	/** 사용자 IP정보 */
	private String ip = "";

	/**
	 * @return the uniqId
	 */
	public String getUniqId() {
		return uniqId;
	}

	/**
	 * @param uniqId the uniqId to set
	 */
	public void setUniqId(String uniqId) {
		this.uniqId = uniqId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userNm
	 */
	public String getUserNm() {
		return userNm;
	}

	/**
	 * @param userNm the userNm to set
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	/**
	 * @return the emailAdres
	 */
	public String getEmailAdres() {
		return emailAdres;
	}

	/**
	 * @param emailAdres the emailAdres to set
	 */
	public void setEmailAdres(String emailAdres) {
		this.emailAdres = emailAdres;
	}

	/**
	 * @return the mbtlNum
	 */
	public String getMbtlNum() {
		return mbtlNum;
	}

	/**
	 * @param mbtlNum the mbtlNum to set
	 */
	public void setMbtlNum(String mbtlNum) {
		this.mbtlNum = mbtlNum;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the adres
	 */
	public String getAdres() {
		return adres;
	}

	/**
	 * @param adres the adres to set
	 */
	public void setAdres(String adres) {
		this.adres = adres;
	}

	/**
	 * @return the detailAdres
	 */
	public String getDetailAdres() {
		return detailAdres;
	}

	/**
	 * @param detailAdres the detailAdres to set
	 */
	public void setDetailAdres(String detailAdres) {
		this.detailAdres = detailAdres;
	}

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the userSttusCode
	 */
	public String getUserSttusCode() {
		return userSttusCode;
	}

	/**
	 * @param userSttusCode the userSttusCode to set
	 */
	public void setUserSttusCode(String userSttusCode) {
		this.userSttusCode = userSttusCode;
	}

	/**
	 * @return the userSe
	 */
	public String getUserSe() {
		return userSe;
	}

	/**
	 * @param userSe the userSe to set
	 */
	public void setUserSe(String userSe) {
		this.userSe = userSe;
	}

	/**
	 * @return the orgnztId
	 */
	public String getOrgnztId() {
		return orgnztId;
	}

	/**
	 * @param orgnztId the orgnztId to set
	 */
	public void setOrgnztId(String orgnztId) {
		this.orgnztId = orgnztId;
	}

	/**
	 * @return the orgnztNm
	 */
	public String getOrgnztNm() {
		return orgnztNm;
	}

	/**
	 * @param orgnztNm the orgnztNm to set
	 */
	public void setOrgnztNm(String orgnztNm) {
		this.orgnztNm = orgnztNm;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
}
