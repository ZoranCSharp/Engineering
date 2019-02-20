package springDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

@Component("offersDao")
public class OffersDAO {
	
	//private JdbcTemplate jdbc;
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void  setDataSource(DataSource ds) {
		
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}
	
	
	//get all offers from db
	public List<Offer> getOffers(){
		
	return jdbc.query("SELECT * FROM offers", new RowMapper<Offer>() {

		public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Offer offer = new Offer();
			offer.setId(rs.getInt("id"));
			offer.setName(rs.getString("name"));
			offer.setEmail(rs.getString("email"));
			offer.setText(rs.getString("text"));
			
			return offer;
		}
		
		
	});
	}
	
	
	//get one offer by id
	public Offer getOfferById(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id); //name  parameter
		
		return jdbc.queryForObject("SELECT * FROM offers WHERE id=:id", params, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				
				return offer;
			}
			
			
		});
		
	}
	
	//delete by id, returns true if delete was successfull
	public boolean deleteById(int id) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id); //name  parameter
		
		return jdbc.update("DELETE FROM offers WHERE id=:id", params) == 1;
		
	}
	
	
	//insert CREATE
	public  boolean insert(Offer offer) {
		
		/*
		 * MapSqlParameterSource params = new MapSqlParameterSource();
		 * params.addValue("id", offer.getId()); //name parameter
		 * params.addValue("name", offer.getName()); params.addValue("email",
		 * offer.getEmail()); params.addValue("text", offer.getText());
		 */
		
		//only for INSERT
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("INSERT INTO offers(id, name,email, text) VALUES (:id, :name, :email, :text)", params) == 1;
	}
	
	
	//update one offer in db
	public boolean updateById(Offer offer) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("UPDATE offers SET name=:name, email=:email, text=:text WHERE id=:id", params) == 1;
	}
	
	
	//batch update
	public int[] create(List<Offer> offers) {
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("INSERT INTO offers(id, name,email, text) VALUES (:id, :name, :email, :text)", params);
	}
	
	
}
