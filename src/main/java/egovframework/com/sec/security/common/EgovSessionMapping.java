package egovframework.com.sec.security.common;

import java.sql.ResultSet;
import java.sql.SQLException;

import egovframework.com.cmm.LoginVO;

import egovframework.rte.fdl.security.userdetails.EgovUserDetails;
import egovframework.rte.fdl.security.userdetails.jdbc.EgovUsersByUsernameMapping;

import javax.sql.DataSource;

/**
 * mapRow 결과를 사용자 EgovUserDetails Object 에 정의한다.
 * 
 * @author ByungHun Woo
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    -------------    ----------------------
 *   2009.03.10  ByungHun Woo    최초 생성
 *   2009.03.20  이문준          UPDATE
 *
 * </pre>
 */

public class EgovSessionMapping extends EgovUsersByUsernameMapping {
	
	/**
	 * 사용자정보를 테이블에서 조회하여 EgovUsersByUsernameMapping 에 매핑한다.
	 * @param ds DataSource
	 * @param usersByUsernameQuery String
	 */
	public EgovSessionMapping(DataSource ds, String usersByUsernameQuery) {
        super(ds, usersByUsernameQuery);
    }

	/**
	 * mapRow Override
	 * @param rs ResultSet 결과
	 * @param rownum row num
	 * @return Object EgovUserDetails
	 * @exception SQLException
	 */
	@Override
    protected EgovUserDetails mapRow(ResultSet rs, int rownum) throws SQLException {
    	logger.debug("## EgovUsersByUsernameMapping mapRow ##");

        String strUserId        = rs.getString("USER_ID");
        String strPassWord      = rs.getString("PASSWORD");
        boolean strEnabled      = rs.getBoolean("ENABLED");
        String strUserNm        = rs.getString("USER_NM");
        String strEmailAdres    = rs.getString("EMAIL_ADRES");
        String strMbtlNum       = rs.getString("MBTL_NUM");
        String strZip           = rs.getString("ZIP");
        String strAdres         = rs.getString("ADRES");
        String strDetailAdres   = rs.getString("DETAIL_ADRES");
        String strGroupId       = rs.getString("GROUP_ID");
        String strUserSttusCode = rs.getString("USER_STTUS_CODE");
        String strUserSe        = rs.getString("USER_SE");
        String strOrgnztId      = rs.getString("ORGNZT_ID");
        String strOrgnztNm      = rs.getString("ORGNZT_NM");

        // 세션 항목 설정
        LoginVO loginVO = new LoginVO();
        loginVO.setUserId(strUserId);
        loginVO.setPassword(strPassWord);
        loginVO.setUserNm(strUserNm);
        loginVO.setEmailAdres(strEmailAdres);
        loginVO.setMbtlNum(strMbtlNum);
        loginVO.setZip(strZip);
        loginVO.setAdres(strAdres);
        loginVO.setDetailAdres(strDetailAdres);
        loginVO.setGroupId(strGroupId);
        loginVO.setUserSttusCode(strUserSttusCode);
        loginVO.setUserSe(strUserSe);
        loginVO.setOrgnztId(strOrgnztId);
        loginVO.setOrgnztNm(strOrgnztNm);
        
        return new EgovUserDetails(strUserId, strPassWord, strEnabled, loginVO);
    }
}
