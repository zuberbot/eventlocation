/**
 * IController
 */
package springmvc.controller;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author Chuck
 *
 */
public interface IController {

	public ModelAndView listEntities();
	
	public ModelAndView addNewEntity();
	
	public ModelAndView editEntity(int id);
	
	public ModelAndView deleteEntity(int id);
	
}
