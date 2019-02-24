package it.eng.spring.test.test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.eng.spring.dao.Offer;
import it.eng.spring.dao.OffersDAO;

@ActiveProfiles("dev")
@ContextConfiguration(locations= {
		"classpath:it/eng/spring/config/dao-context.xml",
		"classpath:it/eng/spring/config/services-context.xml",
		"classpath:it/eng/spring/test/config/datasource.xml"})

@RunWith(SpringJUnit4ClassRunner.class)
public class OffersDaoTests {
	
	@Autowired
	private OffersDAO offersDao;
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void beforeMethod() {
		
		System.out.println("Before");
	}
	
	@After
	public void afterMethod() {
		
		System.out.println("After");
	}
	
	@BeforeClass
	public static void beforeClass() {
		
		System.out.println("Before Class");
	}
	
	@AfterClass
	public static void afterClass() {
		
		System.out.println("After Class");
	}
	
	@Before
	public void init() {
		
		System.out.println("Clean up before each test");
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		
		//clean up everythig
		jdbc.execute("delete from offers");
	}
	
	@Test
	public void testAdd() {
		
		int a = 10;
		int b = 20;
		int expectedResult = 30;
		int actualResult = offersDao.add(a, b);
		assertEquals(expectedResult,actualResult);
	}
	
	@Test
	public void testCreateNewOffer() {
		
		Offer offer = new Offer(1, "Pera Peric", "pera@gmail.com","QA");
		
		
		assertTrue(offersDao.createOffer(offer));
		
		List<Offer> offers = offersDao.getOffers();
		assertEquals("Its should be only 1 record in DB",1, offers.size());
		
		//check if offer is corectly stored to the DB
		assertEquals("Retrieveoffer should match created offer", offer,offers.get(0));
	}
	
	@Test
	public void testUpdateOffer() {
		
		Offer offer = new Offer(1, "Pera Peric", "pera@gmail.com","QA");				
		assertTrue(offersDao.createOffer(offer));
		
		Offer retrievedOffer =  offersDao.getOfferById(1);
		retrievedOffer.setText("Spring");
		
		assertTrue("Update should return true if successful",offersDao.update(retrievedOffer));
		Offer updatedOffer = offersDao.getOfferById(1);
		
		assertEquals("Updated offer should match with retrieved offer.",retrievedOffer,updatedOffer);
	}
	
	@Test
	public void testBatchUpdate() {
		List<Offer> list = new ArrayList<Offer>();
		list.add(new Offer(1, "Pera Peric", "Pera@Peric.com", "Java Programmer"));
		list.add(new Offer(2, "Mika Mikic", "Mika@Mikic.com", "Ruby Programmer"));
		list.add(new Offer(3, "Zika Zikic", "Zika@Zikic.com", "C++ Programmer"));

		offersDao.createOffers(list);

		List<Offer> offers = offersDao.getOffers();
		assertEquals("There should be exactly 3 records in the database", 3, offers.size());
	}
	
	@Test
	public void testDelete() {
		
		List<Offer> list = new ArrayList<Offer>();
		list.add(new Offer(1, "Pera Peric", "Pera@Peric.com", "Java Programmer"));
		list.add(new Offer(2, "Mika Mikic", "Mika@Mikic.com", "Ruby Programmer"));
		list.add(new Offer(3, "Zika Zikic", "Zika@Zikic.com", "C++ Programmer"));

		offersDao.createOffers(list);
		
		assertTrue(offersDao.deleteOfferById(3));
		
		List<Offer> offers = offersDao.getOffers();
		
		assertEquals("After deleting 1 row, 2 should be left in DB",2,offers.size()); //offers.size() - velicina liste ( br elemenata)
	}
	
	@Test(expected = DataAccessException.class)
	public void testException() {
		Offer offer = new Offer(1, "Pera Peric", "pera@gmail.com", "Java Programer");
		offersDao.createOffer(offer);
		offersDao.createOffer(offer);
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void testException2() {
		
		offersDao.getOfferById(5);
		
	}
}


	
	

