/**
 * WebAppInitializer
 */
package springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import springmvc.utility.IStrings;

/**
 * @author Chuck
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Returns @Configuration classes used to configure the application
		// context created by ContextLoaderListener
		return null;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Returns @Configuration classes defining beans for the 
		// DispatcherServlet application context
		return new Class<?>[] { WebConfig.class };
	}	

	/**
	 * 
	 * @return
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { 
				IStrings.SPRING_MVC_URL,
				IStrings.LOCATIONS_URL,
				IStrings.USER_LIST_URL,
				IStrings.USER_NEW_URL,
				IStrings.USER_EDIT_URL,
				IStrings.USER_DELETE_URL,
				IStrings.USER_SAVE_URL,
				IStrings.EVENT_LIST_URL,
				IStrings.EVENT_NEW_URL, 
				IStrings.EVENT_EDIT_URL, 
				IStrings.EVENT_DELETE_URL, 
				IStrings.EVENT_SAVE_URL, 
				IStrings.LOCATION_NEW_URL, 
				IStrings.LOCATION_EDIT_URL, 
				IStrings.LOCATION_SAVE_URL
				};
	}
	
}
