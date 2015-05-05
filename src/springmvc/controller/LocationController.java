/**
 * LocationController
 */
package springmvc.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.dao.EventDAO;
import springmvc.model.dao.LocationDAO;
import springmvc.model.entity.Event;
import springmvc.model.entity.Location;
import springmvc.utility.IRequestMappings;
import springmvc.utility.Utility;

/**
 * @author Chuck
 *
 */
@Controller
public class LocationController extends SpringController implements IController {

	@Autowired
	private LocationDAO locationDao;
	
	@Autowired
	private EventDAO eventDao;
	
	/**
	 * Display the list of events for a user.
	 * 
	 * @return
	 */
	@RequestMapping(IRequestMappings.LOCATION_LIST_URL)
	public ModelAndView listEntities() {
		return null;
	}

	/**
	 * Add a new event for a location.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/DUMMY3", method = RequestMethod.GET)
	public ModelAndView addNewEntity() {
		return null;
	}
	
	/**
	 * Add a new event for a location.
	 * 
	 * @return
	 */
	@RequestMapping(value = IRequestMappings.LOCATION_NEW_URL, method = RequestMethod.GET)
	public ModelAndView addNewEntity(@RequestParam(value = "eventid", defaultValue = "0") int eventid) {
		ModelAndView model = new ModelAndView(IRequestMappings.LOCATION_FORM_URL);
		Location location = new Location();
		location.setEventId(eventid);
		
		// Need to preset the date to avoid form does not valid error
		// Failed to convert property value of type 'java.lang.String' to required type 
		// 'java.sql.Timestamp' for property 'createdDate'; nested exception is 
		// java.lang.IllegalArgumentException: Could not parse date: Unparseable date: ""
		
		Timestamp dateCreated = Utility.getCurrentMySQLDate();
		location.setCreatedDate(dateCreated);
		location.setUpdatedDate(dateCreated);
		
		model.addObject("location", location);
		return model;		
	}
	
	/**
	 * Edit an existing event.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = IRequestMappings.LOCATION_EDIT_URL, method = RequestMethod.GET)
	public ModelAndView editEntity(@RequestParam(value = "id", defaultValue = "0") int id) {
		Location location = locationDao.getEntity(id);
		
		// Update the updated date
		Timestamp updatedDate = Utility.getCurrentMySQLDate();
		location.setUpdatedDate(updatedDate);
		locationDao.saveOrUpdateEntity(location);

		ModelAndView model = new ModelAndView(IRequestMappings.LOCATION_FORM_URL);
		model.addObject("location", location);
		return model;		
	}
	
	/**
	 * Remove an event.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = IRequestMappings.LOCATION_DELETE_URL, method = RequestMethod.GET)
	public ModelAndView deleteEntity(@RequestParam(value = "id", defaultValue = "0") int id) {
		// Handled via event delete
		return null;
	}

	/**
	 * Save an location or update an existing location.
	 * 
	 * @param location
	 * @return
	 */
	@RequestMapping(value = IRequestMappings.LOCATION_SAVE_URL, method = RequestMethod.POST)
	public String saveOrUpdateEntity(@ModelAttribute Location location, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println("Form does not validate.");
			List<ObjectError> errors = result.getAllErrors();
			
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
		}
		else {
			locationDao.saveOrUpdateEntity(location);
		}
		
		Event event = eventDao.getEntity(location.getEventId());
		
		return "redirect:/events/eventlist?id=" + event.getUserId();
	}
}
