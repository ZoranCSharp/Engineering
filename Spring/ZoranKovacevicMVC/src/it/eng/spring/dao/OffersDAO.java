package it.eng.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}

	public List<Offer> getOffers() {

		return jdbc.query("SELECT * FROM offers", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(rs.getInt("ID"));
				offer.setName(rs.getString("NAME"));
				offer.setEmail(rs.getString("EMAIL"));
				offer.setText(rs.getString("TEXT"));

				return offer;
			}
		});
	}

	// get 1 offer by id
	public Offer getOfferById(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("SELECT * FROM offers WHERE id=:id", params, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(rs.getInt("ID"));
				offer.setName(rs.getString("NAME"));
				offer.setEmail(rs.getString("EMAIL"));
				offer.setText(rs.getString("TEXT"));

				return offer;
			}

		});
	}
	
	//delete by id, returns true if delete was successful
	public boolean deleteOfferById(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		return jdbc.update("DELETE FROM offers WHERE id=:id", params) == 1;
	}
	
	//insert
	public boolean createOffer (Offer offer) {
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("id", offer.getId());
//		params.addValue("name", offer.getName());
//		params.addValue("email", offer.getEmail());
//		params.addValue("text", offer.getText());
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("INSERT INTO offers (id, name, email, text) VALUES"
				+ "(:id, :name, :email, :text)", params) == 1;
	}
	
	//update one offer in db
	public boolean update (Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("UPDATE offers SET name = :name, email = :email, text = :text WHERE id=:id", params) == 1;
	}
	
	//batch update
	@Transactional
	public int[] createOffers(List<Offer> offers) {
		SqlParameterSource[] params = 
				SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("INSERT INTO offers (id, name, email, text) "
				+ "VALUES (:id, :name, :email, :text)", params);
	}
	
	public int add (int a, int b) {
		
		return a+b;
	}

}
