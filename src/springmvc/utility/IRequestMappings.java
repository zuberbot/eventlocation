/**
 * IRequestMappings
 */
package springmvc.utility;

/**
 * @author Chuck
 *
 */
public interface IRequestMappings {

	String SPRING_MVC_URL = "/SpringMvc";
	String LOCATIONS_URL = "/SpringMvc/locations";
	
	String USER_LIST_URL = "/users/userlist";
	String USER_NEW_URL = "/users/usernew";
	String USER_EDIT_URL = "/users/useredit";
	String USER_DELETE_URL = "/users/userdelete";
	String USER_SAVE_URL = "/users/usersave";
	String USER_FORM_URL = "/users/userform";

	String EVENT_LIST_URL = "/events/eventlist";
	String EVENT_NEW_URL = "/events/eventnew";
	String EVENT_EDIT_URL = "/events/eventedit";
	String EVENT_DELETE_URL = "/events/eventdelete";
	String EVENT_SAVE_URL = "/events/eventsave";
	String EVENT_FORM_URL = "/events/eventform";

	String LOCATION_LIST_URL = "/locations/locationlist";
	String LOCATION_NEW_URL = "/locations/locationnew";
	String LOCATION_EDIT_URL = "/locations/locationedit";
	String LOCATION_DELETE_URL = "/locations/locationdelete";
	String LOCATION_SAVE_URL = "/locations/locationsave";
	String LOCATION_FORM_URL = "/locations/locationform";
}
