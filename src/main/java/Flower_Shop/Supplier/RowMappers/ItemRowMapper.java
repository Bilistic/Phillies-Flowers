package Flower_Shop.Supplier.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Flower_Shop.entities.Item;

public class ItemRowMapper implements RowMapper<Item> {
	

	@Override
	public Item mapRow(ResultSet rs, int index) throws SQLException {
		Item item = new Item();
		item.setId(rs.getInt("item_id"));
		item.setName(rs.getString("name"));
		item.setImage(rs.getString("image"));
		item.setCost(rs.getInt("cost"));
		return item;
	}

}
