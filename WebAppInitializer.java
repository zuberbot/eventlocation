/**
 * WebAppInitializer
 */
package springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import springmvc.utility.IRequestMappings;

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
				IRequestMappings.SPRING_MVC_URL,
				IRequestMappings.LOCATIONS_URL,
				IRequestMappings.USER_LIST_URL,
				IRequestMappings.USER_NEW_URL,
				IRequestMappings.USER_EDIT_URL,
				IRequestMappings.USER_DELETE_URL,
				IRequestMappings.USER_SAVE_URL,
				IRequestMappings.EVENT_LIST_URL,
				IRequestMappings.EVENT_NEW_URL, 
				IRequestMappings.EVENT_EDIT_URL, 
				IRequestMappings.EVENT_DELETE_URL, 
				IRequestMappings.EVENT_SAVE_URL, 
				IRequestMappings.LOCATION_NEW_URL, 
				IRequestMappings.LOCATION_EDIT_URL, 
				IRequestMappings.LOCATION_SAVE_URL
				};
	}
	
}
