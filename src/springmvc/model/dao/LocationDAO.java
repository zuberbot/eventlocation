/**
 * LocationDAO
 */
package springmvc.model.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.entity.Event;
import springmvc.model.entity.Location;
import springmvc.utility.Utility;

/**
 * @author Chuck
 *
 */
@Repository
@Transactional
public class LocationDAO extends DAO {

	/**
	 * 
	 * @param sessionFactory
	 */
	public LocationDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	// List locations for an event
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Location getEntity(int id) {
		Criteria criteria = createBaseCriteria(Location.class);
		SimpleExpression seEventId = Restrictions.eq("id", id);
		criteria.add(seEventId);
		Location location = (Location) criteria.uniqueResult();
		return location;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Location getEntity(int eventId, boolean basedOnEvent) {
		Criteria criteria = createBaseCriteria(Location.class);
		SimpleExpression seEventId = Restrictions.eq("eventId", eventId);
		criteria.add(seEventId);
		Location location = (Location) criteria.uniqueResult();
		return location;
	}
	
	/**
	 * 
	 * @param eventIdTimestamp
	 * @return
	 */
	public List<Location> listEntities(String eventIdTimestamp) {
		String lookUp = "%" + eventIdTimestamp + "%";
		Criteria criteria = createBaseCriteria(Event.class);
		SimpleExpression seEventId = Restrictions.like("eventIdTimestamp", lookUp);
		criteria.add(seEventId);

		@SuppressWarnings("unchecked")
		List<Event> events = (List<Event>) criteria.list();
		List<Location> locations = new ArrayList<>();
		
		for (Event e : events) {
			int eventId = e.getId();
			criteria = createBaseCriteria(Location.class);
			seEventId = Restrictions.eq("eventId", eventId);
			criteria.add(seEventId);
			Location location = (Location) criteria.uniqueResult();
			locations.add(location);
		}
		
		return locations;
	}
	
	// Insert a new location
	
	/**
	 * 
	 * @param location
	 */
	public void saveOrUpdateEntity(Location location) {
		int locationId = location.getId();
		
		if (locationId == 0) {
			Timestamp dateCreated = Utility.getCurrentMySQLDate();
			location.setCreatedDate(dateCreated);
			location.setUpdatedDate(dateCreated);
			location.setActive("Y");
		}
		
		session().saveOrUpdate(location);
	}

	// Delete an location

	/**
	 * 
	 * @param location
	 */
	public void deleteEntity(Location location) {
		location.setActive("N");
		session().saveOrUpdate(location);
	}	
}
