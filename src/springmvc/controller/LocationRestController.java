/**
 * LocationRestController
 */
package springmvc.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springmvc.model.dao.LocationDAO;
import springmvc.model.entity.Location;
import springmvc.utility.IRequestMappings;

/**
 * @author Chuck
 * 
 */
@RestController
@RequestMapping(IRequestMappings.LOCATIONS_URL)
public class LocationRestController {

	private static final String MAX_LONG_AS_STRING = "9223372036854775807";
	
	private static final String CLASS_NAME = LocationRestController.class.getName();
	
	private final static Logger LOGGER = Logger.getLogger(CLASS_NAME);
	
	@Autowired
	private LocationDAO locationDao;

	/**
	 * 
	 * @param max
	 * @param count
	 * @param request
	 * @param eventId
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Location> locations(
			@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "20") int count,
			@RequestParam(value = "eventId", defaultValue = "-1") String eventId,
			HttpServletRequest request, HttpServletResponse response) {
		
		LOGGER.info("=> Event Id: " + eventId);
		
		// AngularJS sends a request for a particular event id
		// Pull the corresponding records from the DB
		// Respond back with the data
		List<Location> locations = locationDao.listEntities(eventId);
		
		// Allow AngularJS calls
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		return locations;
	}

	/**
	 * 
	 * @param location
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public Location saveLocation(@RequestBody Location location) {
		return location;
	}
}
