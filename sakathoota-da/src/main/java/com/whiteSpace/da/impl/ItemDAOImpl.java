/**
 * 
 */
package com.whiteSpace.da.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.whiteSpace.da.iface.ItemDAO;
import com.whiteSpace.da.rowMapper.ItemRowMapper;
import com.whiteSpace.da.rowMapper.UserRowMapper;
import com.whiteSpace.domain.common.types.Item;
import com.whiteSpace.domain.common.types.User;

/**
 * @author Shivakumar N
 *
 * @since Feb 7, 2013 9:56:48 AM
 */
public class ItemDAOImpl extends BaseDAOImpl implements ItemDAO{

	
	@Override
	public Item createItem(final Item item) {
		final String query = "insert into items (name, type) values (?, ?)";
		
		PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(query, new String[]{"item_id"});
				int i = 1;
				preparedStatement.setString(i++, item.getName());
				preparedStatement.setInt(i++, item.getFoodType().getValue());
				
				return preparedStatement;
			}
		};
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(preparedStatementCreator, keyHolder);
		item.setId(keyHolder.getKey().intValue());
		return item;
	}

	@Override
	public Item getItem(Integer id) {
		String sql = "select item_id, name, type from items where item_id = ?";
		List<Item> items = jdbcTemplate.query(sql, new Object[]{id}, new ItemRowMapper());
		if(items.size() > 0){
			return items.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Item getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
