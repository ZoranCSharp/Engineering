package it.eng.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UsersDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}

	// get all users
	public List<User> getUsers() {

		return jdbc.query(
				"SELECT u.username,u.password,u.enabled,a.authority,u.email  FROM users u INNER JOIN authorities a ON u.username = a.username",
				new RowMapper<User>() {

					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();

						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setEnabled(rs.getInt("enabled"));
						user.setAuthority(rs.getString("authority"));
						user.setEmail(rs.getString("email"));

						return user;
					}
				});

	}

	// get user by ID
	public User getUserById(String username) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);

		return jdbc.queryForObject(
				"SELECT u.username,u.password,u.enabled,a.authority,u.email FROM users u INNER JOIN authorities a ON u.username = a.username WHERE u.username=:username",
				params, new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();

						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setEmail(rs.getString("email"));
						user.setAuthority(rs.getString("authority"));
						user.setEnabled(rs.getInt("enabled"));

						return user;
					}
				});
	}

	// delete user by ID
	@Transactional
	public boolean deleteUserById(String username) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);

		return jdbc.update("DELETE FROM users WHERE username = :username", params) == 1
				&& jdbc.update("DELETE FROM authorities WHERE username = :username", params) == 1;
	}

	// create user
	@Transactional
	public boolean createUser(User user) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);

		return jdbc.update(
				"INSERT INTO users (username, password, enabled, email) VALUES (:username, :password, :enabled, :email)",
				params) == 1
				&& jdbc.update("INSERT INTO authorities (username, authority) VALUES (:username, :authority)",
						params) == 1;

	}

	// update one user
	@Transactional
	public boolean updateUser(User user) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return jdbc.update(
				"UPDATE authorities SET username = :username, authority = :authority WHERE username = :username",
				params) == 1
				&& jdbc.update(
						"UPDATE users SET username = :username, password = :password, enabled = :enabled, email = :email",
						params) == 1;

	}

	// check user existence
	public boolean exists(User user) {

		List<User> userList = getUsers();

		for (User u : userList) {

			if (user.getUsername().equals(u.getUsername()))

				return true;
		}
		return false;
	}

}
