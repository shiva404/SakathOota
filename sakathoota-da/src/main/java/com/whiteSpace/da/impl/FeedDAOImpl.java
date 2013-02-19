/**
 * 
 */
package com.whiteSpace.da.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.whiteSpace.da.iface.FeedDAO;
import com.whiteSpace.domain.common.types.FeedItem;

/**
 * @author Shivakumar N
 *
 * @since Feb 19, 2013 12:01:52 AM
 */
public class FeedDAOImpl extends BaseDAOImpl implements FeedDAO {

	/* (non-Javadoc)
	 * @see com.whiteSpace.da.iface.FeedDAO#createNewFeed(com.whiteSpace.domain.common.types.FeedItem)
	 */
	@Override
	public FeedItem createNewFeed(final FeedItem feedItem) {
		final String query = "insert into feed (user_id, menu_id, emotion_id, location_id) values (?, ?, ?, ?)";
		
		PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(query, new String[]{"id"});
				int i = 1;
				preparedStatement.setLong(i++, feedItem.getUserId());
				preparedStatement.setLong(i++, feedItem.getMenuId());
				preparedStatement.setLong(i++, feedItem.getRating());
				preparedStatement.setLong(i++, feedItem.getLocationId());
				return preparedStatement;
			}
		};
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(preparedStatementCreator, keyHolder);
		feedItem.setId(keyHolder.getKey().intValue());
		return feedItem;
	}
}
