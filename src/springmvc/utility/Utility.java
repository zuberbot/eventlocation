/**
 * Utility
 */
package springmvc.utility;

import java.sql.Timestamp;

/**
 * @author Chuck
 *
 */
public class Utility {

	/**
	 * 
	 * @return
	 */
	public static Timestamp getCurrentMySQLDate() {
		long time = System.currentTimeMillis();
		//Date date = new Date(time);
		Timestamp ts = new Timestamp(time); // new Timestamp(date.getTime());
		return ts;
	}
}
