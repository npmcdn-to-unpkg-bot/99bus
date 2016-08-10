package org.hopen.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;

public class DefRowMapper implements RowMapper<Map<String, Object>> {

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int arg1) throws SQLException {
		
		
		ResultSetMetaData rsm = rs.getMetaData();
		int cnts = rsm.getColumnCount();
		Map<String, Object> hm=new HashMap<String, Object>();
		for (int i = 1; i < cnts+1; i++) {
			String columnName = rsm.getColumnName(i);
			Object obj = rs.getString(columnName);
			hm.put(columnName.toLowerCase(),obj);
//			Map<String, Object> maps = SimpleMap.getValueLabels(columnName.toLowerCase());
//			if (maps != null &&obj!= null&&!("").equals(obj)) {
//				String label = (String)maps.get(obj.toString());
//				hm.put(columnName.toLowerCase() + "_label", label);
//			}
			/**
			if (columnName.equals("FIELD_VALUE")&&obj.toString().contains("</>")) {
				String val = obj.toString();
				String[] keyValStrs = val.split("</>");
				for (int j = 0; j < keyValStrs.length; j++) {
					String keyValStr = keyValStrs[j].replace("<", "").replace(">", ":");
					String[] keyValue= keyValStr.split(":");
					if (keyValue.length>=2) {
						hm.put(keyValue[0].trim().toLowerCase(),keyValue[1].trim());
					}
				}
			}
			**/
		}
		return hm;
	}

}
