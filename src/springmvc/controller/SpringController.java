/**
 * SpringController
 */
package springmvc.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import springmvc.utility.SqlTimestampPropertyEditor;

/**
 * @author Chuck
 *
 */
@Controller
public class SpringController {

	/**
	 * For handling non-primitive type data from HTML form submissions.
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SqlTimestampPropertyEditor stpe = new SqlTimestampPropertyEditor("yyyy-MM-dd HH:mm:ss");
	    binder.registerCustomEditor(Timestamp.class, stpe);
	}
}
