package org.hopen.jjbus.dao.impl;

import java.util.List;
import java.util.Map;
import org.hopen.jjbus.dao.IWxConfigDao;
import org.hopen.utils.DefRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author jerry
 *
 */
@Repository("wxCfg")
public class WxConfigDao implements IWxConfigDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public  List<Map<String, Object>> queryAll(){
		String sql = "select * from module_cfg";
		Object [] s  = {};
		List<Map<String, Object>> rList = jdbcTemplate.query(sql, new DefRowMapper(), s );
		return rList;
	}
}
