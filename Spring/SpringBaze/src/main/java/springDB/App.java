package springDB;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jca.cci.CannotGetCciConnectionException;

public class App {

	public static void main(String args[]) {

		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");

		/* offersDao.deleteById(3); */

//		Offer o = new Offer();
//		o.setId(3);
//		o.setName("Jovan Jovanovic");
//		o.setEmail("jovan.j@gmail.com");
//		o.setText("Spring and DB programmer");

		/*
		 * Offer o = new Offer(); o.setId(1); o.setName("Milan Milanovic");
		 * o.setEmail("milan.m@gmail.com"); o.setText("E");
		 */

		List<Offer> list = offersDao.getOffers();
		for (Offer offer : list) {
			System.out.println(offer);
		}

//		offersDao.insert(o);

		/* offersDao.updateById(o); */
//		

		/*
		 * Offer offer = offersDao.getOfferById(2); System.out.println(offer);
		 */

		/*
		 * try { List<Offer> offers = offersDao.getOffers();
		 * 
		 * for(Offer offer:offers) { System.out.println(offer); }
		 * }catch(CannotGetCciConnectionException e){
		 * 
		 * System.out.println("Not possible to connect to the Oracle...");
		 * 
		 * }catch(DataAccessException e) {
		 * 
		 * System.out.println(e.getMessage()); System.out.println(e.getClass()); }
		 */
		((FileSystemXmlApplicationContext) context).close();
	}

}
