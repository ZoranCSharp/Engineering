package it.eng.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.eng.spring.dao.Offer;
import it.eng.spring.services.OffersService;

@Controller
public class OffersController {
	
	private OffersService offersService;
	
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}



	@RequestMapping("/offers")
	public String showOffers(Model model) {
		
		List<Offer> offers = offersService.getcurrentOffers();
		model.addAttribute("offers",offers);
		
		return "offers";
	}
	
	//treba da dovucemo listu offers iz baze i prikazemo 
	
	@RequestMapping("/createoffer")
	public String createOffer() {
		
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer,BindingResult result) {
		
		if(result.hasErrors()) {
			
			System.out.println("Form is not valid");
			
			List<ObjectError> error = result.getAllErrors();
			
			for(ObjectError e:error) {
				
				System.out.println(e.getDefaultMessage());
			}
		}else {
			
			System.out.println("Form validated successfully");
		}
		offersService.createOffer(offer);
		return "offercreated";
	}
	/*
	  //error handling on controller level
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseError(DataAccessException e) {
		
		return "error";
	}*/
	
	
	
	
	
	
}
