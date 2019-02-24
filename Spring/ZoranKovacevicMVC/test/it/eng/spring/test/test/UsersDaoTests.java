package it.eng.spring.test.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.annotations.AccessType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.eng.spring.dao.User;
import it.eng.spring.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:it/eng/spring/config/dao-context.xml",
		"classpath:it/eng/spring/config/services-context.xml", "classpath:it/eng/spring/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UsersDaoTests {

	@Autowired
	private UsersDao usersDao;
	@Autowired
	private DataSource dataSource;
	
	@BeforeClass
	public static void beforeClass() {
		
		System.out.println("Tests are starting...\n");
	}
	
	@AfterClass
	public static void afterClass() {
		
			System.out.println("\nEnd Test!");		
		
	}

	@Before
	public void init() {
	
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		jdbc.execute("DELETE FROM users");
		jdbc.execute("DELETE FROM authorities");
	}
		
	@Test
	public void testCreate() {
		// prefix {noop} to password in order for the
		// DelegatingPasswordEncoder use the NoOpPasswordEncoder to validate
		// these passwords.
		User user = new User("Jana Jankovic", "{noop}sifra", 1, "admin", "jana@gmail.com"); 
		assertTrue(usersDao.createUser(user)); // created one user

		List<User> users = usersDao.getUsers();
		assertEquals("There should be 1 record in the database.", 1, users.size());
		System.out.println("Created user!");
		
	}

	@Test
	public void testUpdate() {
		// prefix {noop} to password in order for the
		// DelegatingPasswordEncoder use the NoOpPasswordEncoder to validate
		// these passwords.
		User user = new User("Jana Jankovic", "{noop}sifra", 1, "admin", "jana@gmail.com");
		assertTrue(usersDao.createUser(user));

		User retrievedUser = usersDao.getUserById("Jana Jankovic");
		retrievedUser.setPassword("{noop}sifra"); 
		assertTrue("True if successful", usersDao.updateUser(retrievedUser));
		System.out.println("Updating user information!");
	}

	@Test
	public void testDelete() {
		List<User> list = new ArrayList<User>();
		list.add(new User("Jana Jankovic", "{noop}sifra", 1, "admin", "jana@gmail.com"));
		list.add(new User("Dana Dankovic", "{noop}sifra", 1, "admin", "dana@gmail.com"));
		list.add(new User("Sanja Sanjic", "{noop}sifra", 1, "admin", "sanja@gmail.com"));
		list.add(new User("Dara Mara", "{noop}sifra", 1, "user", "daram@gmail.com"));

		for (User user : list) {
			usersDao.createUser(user);
		}

		assertTrue(usersDao.deleteUserById("Sanja Sanjic"));
		List<User> users = usersDao.getUsers();
		assertEquals("There should be 3 records in database", 3, users.size());
		System.out.println("Deleting 1 user!");
	}

	@Test
	public void testExists() {

		// prefix {noop} to password in order for the
		// DelegatingPasswordEncoder use the NoOpPasswordEncoder to validate
		// these passwords.
		User user = new User("Jana Jankovic", "{noop}sifra", 1, "admin", "jana@gmail.com");
		assertTrue(usersDao.createUser(user));

		User retrievedUser = usersDao.getUserById("Jana Jankovic");
		retrievedUser.setPassword("{noop}sifra");

		assertTrue("True if successful", usersDao.exists(retrievedUser));
		System.out.println("User exists!");
	}

}
