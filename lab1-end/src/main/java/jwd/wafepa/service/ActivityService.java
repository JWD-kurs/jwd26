package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Activity;

public interface ActivityService {
	
	/**
	 * Finds an activity with the specified ID.
	 * 
	 * @param id 
	 * @return
	 */
	Activity findOne(Long id);
	
	/**
	 * 
	 * @return
	 */
	List<Activity> findAll();
	Activity save(Activity activity);
	void remove(Long id);
}
