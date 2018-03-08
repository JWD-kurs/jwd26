package jwd.wafepa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Sajam;
import jwd.wafepa.model.Stand;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.service.SajamService;
import jwd.wafepa.service.StandService;

@Component
public class TestData {

	/*@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;*/
	
	@Autowired
	private SajamService sajamService;
	
	@Autowired
	private StandService standService;
	
	@Autowired
	private ActivityService activityService;

	@PostConstruct
	public void init(){/*
	       for (int i = 1; i <= 100; i++) {
	            User user = new User();
	            user.setFirstName("First name " + i);
	            user.setLastName("Last name " + i);
	            user.setEmail("email" + i + "@example.com");
	            user.setPassword("123");
	            userService.save(user);

	            for (int j = 1; j <= 3; j++) {
	                Address address = new Address();
	                address.setNumber(j + "c/7");
	                address.setStreat("Narodnog fronta");

	                address.setUser(user);
	                user.addAddress(address);
	                addressService.save(address);
	            }
	       }*/
		for (int j = 0; j <= 3; j++) {
            Activity activity = new Activity();            
            activity.setName("activity" + j);
            activityService.save(activity);
        }
		
		Sajam s1 = new Sajam();
		s1.setCena(123);
		s1.setMesto("Subotica");
		s1.setNaziv("Sajam obrazovanja");
		s1.setOtvaranje("21.12.2017.");
		s1.setZatvaranje("23.12.2017");
		sajamService.save(s1);
		
		Sajam s2 = new Sajam();
		s2.setCena(321);
		s2.setMesto("Novi Sad");
		s2.setNaziv("Sajam nauke");
		s2.setOtvaranje("22.12.2017.");
		s2.setZatvaranje("24.12.2017");
		sajamService.save(s2);
		
		Stand st1 = new Stand();
		st1.setPovrsina(123);
		st1.setZakupac("Mitar");
		st1.setSajam(s1);
		standService.save(st1);
		
		Stand st2 = new Stand();
		st2.setPovrsina(122);
		st2.setZakupac("Miric");
		st2.setSajam(s1);
		standService.save(st2);
		
		Stand st3 = new Stand();
		st3.setPovrsina(11);
		st3.setZakupac("Pera");
		st3.setSajam(s1);
		standService.save(st3);
		
		Stand st4 = new Stand();
		st4.setPovrsina(11);
		st4.setZakupac("Pera");
		st4.setSajam(s1);
		standService.save(st4);
		
	}
}
