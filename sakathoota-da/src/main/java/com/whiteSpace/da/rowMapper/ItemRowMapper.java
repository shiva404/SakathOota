/**
 * 
 */
package com.whiteSpace.da.rowMapper;

import java.security.acl.Owner;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.whiteSpace.domain.common.types.FoodType;
import com.whiteSpace.domain.common.types.Item;

/**
 * @author Shivakumar N
 *
 * @since Feb 7, 2013 10:19:37 AM
 */
public class ItemRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item item = new Item();
		item.setFoodType(FoodType.forCode(rs.getInt("type")));
		item.setId(rs.getInt("item_id"));
		item.setName(rs.getString("name"));
		return item;
	}
}
