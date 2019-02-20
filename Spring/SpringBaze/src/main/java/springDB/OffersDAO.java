package springDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
	
}
