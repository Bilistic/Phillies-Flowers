package Flower_Shop.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Flower_Shop.Supplier.RowMappers.ItemRowMapper;
import Flower_Shop.Supplier.RowMappers.StockRowMapper;
import Flower_Shop.entities.Stock;

@Repository
public class StockSupplierRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	String sql;
	
	@Autowired
	public StockSupplierRepo(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int getItemStock(int item_id){
		sql = "SELECT FROM STOCK WHERE ITEM_ID = ?";
		Stock stock =jdbcTemplate.queryForObject(sql, new Object[] {item_id}, new StockRowMapper());
		return stock.getQuantity();
	}
	
	public void updateItemQuantity(int item_id, int amount) {
		sql = "SELECT QUANTITY FROM STOCK WHERE item_id = ?";
		Stock stock =jdbcTemplate.queryForObject(sql, new Object[] {item_id}, new StockRowMapper());
		int updatedAmount = stock.getQuantity() + (amount);
		
		sql = "UPDATE STOCK SET QUANTITY = ? WHERE ITEM_ID = ?";
		jdbcTemplate.queryForObject(sql, new Object[] {updatedAmount,item_id}, new ItemRowMapper());
	}
}
