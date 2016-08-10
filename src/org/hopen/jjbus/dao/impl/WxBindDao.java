package org.hopen.jjbus.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hopen.jjbus.dao.IWxBindDao;
import org.hopen.utils.DateUtils;
import org.hopen.utils.DefRowMapper;
import org.hopen.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author jerry
 *
 */
@Repository("wxBindDao")
public class WxBindDao implements IWxBindDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Map<String, Object> queryUserInfo(String openId) {
		Object [] params = {openId};
		String sql = "Select * FROM module_acct_bind where openid = ?";
		List<Map<String, Object>> rList = jdbcTemplate.query(sql, params,new DefRowMapper());
		if (rList.size() >= 1) {
			return rList.get(0);
		} else {
			return new HashMap<String,Object>();
		}
	}

	@Override
	public boolean addForBind(Map<String, Object> userInfo) {
		//TODO: this is error;
		String openIdObj = StringUtils.getValue(userInfo, "openid");
		String userNameObj = StringUtils.getExistsValue(userInfo, "username");
		String pwd = StringUtils.getExistsValue(userInfo, "pwd");
		String lastloginTime = DateUtils.getNowDate("yyyyMMddHHmmss");
		Object [] params = {openIdObj,userNameObj,lastloginTime,pwd};
		String sql = "insert into module_acct_bind (openid,user_name,is_quit,last_login_time,loginpwd) values (?,?,0,?,?);";
		int i = this.jdbcTemplate.update(sql,params);
		if(i==1) {
			return true;
		} else {
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.hopen.jjbus.dao.IWxBindDao#existsCheck(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean existsCheck(String openId, String userName) {
		StringBuffer sqlBuff = new StringBuffer("Select openid FROM module_acct_bind where 1=1 and openid = ? and user_name =?");
		Object [] params = {openId,userName};
		List<Map<String, Object>>  rList=  jdbcTemplate.query(sqlBuff.toString(), params, new DefRowMapper());
		return rList.size() > 0;
	}

	/* (non-Javadoc)
	 * @see org.hopen.jjbus.dao.IWxBindDao#existsCheckForOpenId(java.lang.String)
	 */
	@Override
	public boolean existsCheckForOpenId(String openId) {
		Object [] params = {openId};
		StringBuffer sqlBuff = new StringBuffer("");
		sqlBuff.append("Select openid FROM module_acct_bind where 1=1 and openid = ?");
		List<Map<String, Object>>  rList=  jdbcTemplate.query(sqlBuff.toString(), params, new DefRowMapper());
		return rList.size() > 0;
	}

	/* (non-Javadoc)
	 * @see org.hopen.jjbus.dao.IWxBindDao#existsCheckForUserName(java.lang.String)
	 */
	@Override
	public boolean existsCheckForUserName(String userName) {
		Object [] params = {userName};
		StringBuffer sqlBuff = new StringBuffer("");
		sqlBuff.append("Select openid FROM module_acct_bind where 1=1 and user_name = ?");
		List<Map<String, Object>>  rList=  jdbcTemplate.query(sqlBuff.toString(), params, new DefRowMapper());
		return rList.size() > 0;
	}

	/* (non-Javadoc)
	 * @see org.hopen.jjbus.dao.IWxBindDao#updateForLogin(java.lang.String)
	 */
	@Override
	public boolean updateForLogin(String openid) {
		String lastLoginTime = DateUtils.getNowDate("yyyyMMddHHmmss");
		Object [] params = {lastLoginTime,openid};
		StringBuffer sqlBuff = new StringBuffer("");
		sqlBuff.append("update module_acct_bind set last_login_time = ?,is_quit=0 where openid =?");
		int ret = jdbcTemplate.update(sqlBuff.toString(), params);
		if (ret ==1) return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see org.hopen.jjbus.dao.IWxBindDao#updateForQuit(java.lang.String)
	 */
	@Override
	public boolean updateForQuit(String userName) {
		String lastLoginTime = DateUtils.getNowDate("yyyyMMddHHmmss");
		Object [] params = {lastLoginTime,userName};
		StringBuffer sqlBuff = new StringBuffer("");
		sqlBuff.append("update module_acct_bind set last_login_time = ?,is_quit=1 where user_Name =?");
		int ret = jdbcTemplate.update(sqlBuff.toString(), params);
		if (ret ==1) return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see org.hopen.jjbus.dao.IWxBindDao#updateForLoginByUserName(java.lang.String)
	 */
	@Override
	public boolean updateForLoginByUserName(Map<String, Object> map) {
		String lastLoginTime = DateUtils.getNowDate("yyyyMMddHHmmss");
		String userName = map.get("username").toString();
		Object pwdObj = map.get("pwd");
		if(pwdObj == null||("").equals(pwdObj.toString())){
			Object [] params = {lastLoginTime,userName};
			StringBuffer sqlBuff = new StringBuffer("");
			sqlBuff.append("update module_acct_bind set last_login_time = ?,is_quit=0 where user_name =?");
			int ret = jdbcTemplate.update(sqlBuff.toString(), params);
			if (ret ==1) return true;
			return false;
		} else {
			Object [] params = {lastLoginTime,pwdObj.toString(),userName};
			StringBuffer sqlBuff = new StringBuffer("");
			sqlBuff.append("update module_acct_bind set last_login_time = ?,is_quit=0,loginpwd=? where user_name =?");
			int ret = jdbcTemplate.update(sqlBuff.toString(), params);
			if (ret ==1) return true;
			return false;
		}
	}
}
