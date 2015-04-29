/**
 * UserController
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

import springmvc.model.dao.UserDAO;
import springmvc.model.entity.User;
import springmvc.utility.IRequestMappings;
import springmvc.utility.Utility;

/**
 * @author Chuck
 * 
 */
@Controller
public class UserController extends SpringController implements IController {

	@Autowired
	private UserDAO userDao;

	/**
	 * Display the list of users.
	 * 
	 * @return
	 */
	@RequestMapping(IRequestMappings.USER_LIST_URL)
	public ModelAndView listEntities() {
		List<User> listUsers = userDao.listEntities();
		ModelAndView model = new ModelAndView(IRequestMappings.USER_LIST_URL);
		model.addObject("userList", listUsers);
		return model;
	}
	
	/**
	 * Add a new user.
	 * 
	 * @return
	 */
	@RequestMapping(value = IRequestMappings.USER_NEW_URL, method = RequestMethod.GET)
	public ModelAndView addNewEntity() {
		ModelAndView model = new ModelAndView(IRequestMappings.USER_FORM_URL);
		User user = new User();
		
		// Need to preset the date to avoid form does not valid error
		// Failed to convert property value of type 'java.lang.String' to required type 
		// 'java.sql.Timestamp' for property 'createdDate'; nested exception is 
		// java.lang.IllegalArgumentException: Could not parse date: Unparseable date: ""
		
		Timestamp dateCreated = Utility.getCurrentMySQLDate();
		user.setCreatedDate(dateCreated);
		user.setUpdatedDate(dateCreated);
		
		model.addObject("user", user);
		return model;		
	}
	
	/**
	 * Edit an existing user.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = IRequestMappings.USER_EDIT_URL, method = RequestMethod.GET)
	public ModelAndView editEntity(@RequestParam(value = "id", defaultValue = "0") int id) {
		User user = userDao.getEntity(id);		
		
		// Update the updated date
		Timestamp updatedDate = Utility.getCurrentMySQLDate();
		user.setUpdatedDate(updatedDate);
		userDao.saveOrUpdateEntity(user);
		
		// Build model and send to view
		ModelAndView model = new ModelAndView(IRequestMappings.USER_FORM_URL);
		model.addObject("user", user);
		return model;		
	}
	
	/**
	 * Remove a user.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = IRequestMappings.USER_DELETE_URL, method = RequestMethod.GET)
	public ModelAndView deleteEntity(@RequestParam(value = "id", defaultValue = "0") int id) {
		User user = userDao.getEntity(id);
		userDao.deleteEntity(user);
		return listEntities();
	}
	
	/**
	 * Save a user or update an existing user.
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = IRequestMappings.USER_SAVE_URL, method = RequestMethod.POST)
	public ModelAndView saveOrUpdateEntity(@ModelAttribute User user, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Form does not validate.");
			List<ObjectError> errors = result.getAllErrors();
			
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
		}
		else {
			userDao.saveOrUpdateEntity(user);
		}
		
		return listEntities();
	}
}
