/**
 * EventDAO
 */
package springmvc.model.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.entity.Event;
import springmvc.utility.Utility;

/**
 * @author Chuck
 *
 */
@Repository
@Transactional
public class EventDAO extends DAO {

	/**
	 * 
	 * @param sessionFactory
	 */
	public EventDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	/**
	 * 
	 * @return
	 */
	public List<Event> listEntities(int userId) {
		Criteria criteria = createBaseCriteria(Event.class);
		SimpleExpression seUserId = Restrictions.eq("userId", userId);
		criteria.add(seUserId);
		@SuppressWarnings("unchecked")
		List<Event> listEvents = (List<Event>) criteria.list();
		return listEvents;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Event getEntity(int id) {
		Criteria criteria = createBaseCriteria(Event.class);
		SimpleExpression seUserId = Restrictions.eq("id", id);
		criteria.add(seUserId);
		Event event = (Event) criteria.uniqueResult();
		return event;
	}
	
	// Insert a new event
	
	/**
	 * 
	 * @param event
	 */
	public void saveOrUpdateEntity(Event event) {
		int eventId = event.getId();

		// New event
		if (eventId == 0) {
			String eventIdTimestamp = "" + System.currentTimeMillis();
			event.setEventIdTimestamp(eventIdTimestamp);

			Timestamp dateCreated = Utility.getCurrentMySQLDate();
			event.setCreatedDate(dateCreated);
			event.setUpdatedDate(dateCreated);
			event.setActive("Y");
		}
		
		session().saveOrUpdate(event);
	}

	// Delete an event	

	/**
	 * 
	 * @param event
	 */
	public void deleteEntity(Event event) {
		event.setActive("N");
		session().saveOrUpdate(event);
	}
}
