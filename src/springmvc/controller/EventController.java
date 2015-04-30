/**
 * EventController
 */
package springmvc.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
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

import springmvc.model.beans.EventLocationInfo;
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
public class EventController extends SpringController implements IController {

	@Autowired
	private EventDAO eventDao;

	@Autowired
	private LocationDAO locationDao;
	
	/**
	 * Display the list of events for a user.
	 * 
	 * @return
	 */
	@RequestMapping("/DUMMY")
	public ModelAndView listEntities() {
		List<Event> listEvents = eventDao.listEntities(-1);
		ModelAndView model = new ModelAndView("eventlist");
		model.addObject("eventList", listEvents);
		return model;
	}
	
	/**
	 * Display the list of events for a user.
	 * 
	 * @return
	 */
	@RequestMapping(IRequestMappings.EVENT_LIST_URL)
	public ModelAndView listEntities(@RequestParam(value = "id", defaultValue = "0") int userId) {
		List<Event> listEvents = eventDao.listEntities(userId);
		List<EventLocationInfo> userEvents = new ArrayList<>();
		
		// Also build and include the location list for this user
		for (Event e : listEvents) {
			int eventId = e.getId();
			
			Location location = locationDao.getEntity(eventId, true);
			
			EventLocationInfo eventLocationInfo = new EventLocationInfo();
			eventLocationInfo.setUserId(e.getUserId());
			eventLocationInfo.setEventId(eventId);
			eventLocationInfo.setLocationId(location.getId());
			eventLocationInfo.setEventIdTimestamp(e.getEventIdTimestamp());
			eventLocationInfo.setEvent(e.getEvent());
			eventLocationInfo.setLatitude(location.getLatitude());
			eventLocationInfo.setLongitude(location.getLongitude());
			eventLocationInfo.setAltitude(location.getAltitude());
			eventLocationInfo.setCreatedDate(e.getCreatedDate());
			eventLocationInfo.setUpdatedDate(e.getUpdatedDate());
			
			userEvents.add(eventLocationInfo);
		}
		
		ModelAndView model = new ModelAndView(IRequestMappings.EVENT_LIST_URL);
		model.addObject("userEvents", userEvents);
		
		// Let the event list know which user it is for
		model.addObject("userId", userId);
		
		return model;
	}
	
	/**
	 * Add a new event for a event.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/DUMMY2", method = RequestMethod.GET)
	public ModelAndView addNewEntity() {
		return null;
	}
	
	/**
	 * Add a new event for a event.
	 * 
	 * @return
	 */
	@RequestMapping(value = IRequestMappings.EVENT_NEW_URL, method = RequestMethod.GET)
	public ModelAndView addNewEntity(@RequestParam(value = "id", defaultValue = "0") int id) {
		ModelAndView model = new ModelAndView(IRequestMappings.EVENT_FORM_URL);
		Event event = new Event();
		event.setUserId(id);
		
		// Need to preset the date to avoid form does not valid error
		// Failed to convert property value of type 'java.lang.String' to required type 
		// 'java.sql.Timestamp' for property 'createdDate'; nested exception is 
		// java.lang.IllegalArgumentException: Could not parse date: Unparseable date: ""
		
		Timestamp dateCreated = Utility.getCurrentMySQLDate();
		event.setCreatedDate(dateCreated);
		event.setUpdatedDate(dateCreated);
		
		model.addObject("event", event);
		return model;		
	}
	
	/**
	 * Edit an existing event.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = IRequestMappings.EVENT_EDIT_URL, method = RequestMethod.GET)
	public ModelAndView editEntity(@RequestParam(value = "id", defaultValue = "0") int id) {
		Event event = eventDao.getEntity(id);
		
		// Update the updated date
		Timestamp updatedDate = Utility.getCurrentMySQLDate();
		event.setUpdatedDate(updatedDate);
		eventDao.saveOrUpdateEntity(event);

		ModelAndView model = new ModelAndView(IRequestMappings.EVENT_FORM_URL);
		model.addObject("event", event);
		return model;		
	}
	
	/**
	 * Remove an event.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = IRequestMappings.EVENT_DELETE_URL, method = RequestMethod.GET)
	public ModelAndView deleteEntity(@RequestParam(value = "id", defaultValue = "0") int id) {
		Event event = eventDao.getEntity(id);
		int userId = event.getUserId();
		eventDao.deleteEntity(event);		
		Location location = locationDao.getEntity(id, true);
		locationDao.deleteEntity(location);
		return listEntities(userId);
	}

	/**
	 * Save an event or update an existing event.
	 * 
	 * @param event
	 * @return
	 */
	@RequestMapping(value = IRequestMappings.EVENT_SAVE_URL, method = RequestMethod.POST)
	public String saveOrUpdateEntity(@ModelAttribute Event event, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println("Form does not validate.");
			List<ObjectError> errors = result.getAllErrors();
			
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
		}
		else {
			eventDao.saveOrUpdateEntity(event);
		}
		
		int eventId = event.getId();
		
		// See if the location already exists
		Location location = locationDao.getEntity(eventId, true);
		
		if (location != null) {
			int locationId = location.getId();
			// Events and locations are 1-to-1
			return "redirect:/locations/locationedit?id=" + locationId;
		}
		
		return "redirect:/locations/locationnew?eventid=" + eventId;
	}
}
