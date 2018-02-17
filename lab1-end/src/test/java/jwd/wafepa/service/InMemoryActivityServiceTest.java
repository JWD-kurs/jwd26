package jwd.wafepa.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jwd.wafepa.model.Activity;
import jwd.wafepa.service.impl.InMemoryActivityService;

public class InMemoryActivityServiceTest {

	private ActivityService activityService = null;
	
	@Before
	public void setUp(){
		activityService = new InMemoryActivityService();
		
		activityService.save(new Activity("Running"));
		activityService.save(new Activity("Swimming"));
	}
	
	@Test
	public void testFindOne(){
		Activity activity = activityService.findOne(2L);
		
		Assert.assertNotNull(activity);
		Assert.assertEquals("Swimming", activity.getName());
	}
	
	@Test
	public void testFindAll(){
		List<Activity> activities = 
				activityService.findAll();
		
		Assert.assertEquals(2, activities.size());
	}
	
}
