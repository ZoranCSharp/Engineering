package it.eng.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eng.spring.dao.Offer;
import it.eng.spring.dao.OffersDAO;

@Service("offersService")
public class OffersService {
	
	private OffersDAO offersDao;

	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDao = offersDao;
	}
	
	public List<Offer> getcurrentOffers(){
	return offersDao.getOffers();
	
	}
	
	public boolean createOffer(Offer offer) {
		
		return offersDao.createOffer(offer);
	}

}
