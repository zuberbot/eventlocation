/**
 * HomeController
 */
package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.utility.IRequestMappings;

/**
 * @author Chuck
 *
 */
@Controller
public class HomeController {

	/**
	 * 
	 * @return
	 */
	@RequestMapping(IRequestMappings.SPRING_MVC_URL)
	public String home() {
		return "home";
	}
	
}
