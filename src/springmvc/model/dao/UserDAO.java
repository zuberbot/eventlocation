/**
 * UserDAO
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

import springmvc.model.entity.User;
import springmvc.utility.Utility;

@Repository
@Transactional
public class UserDAO extends DAO {
	
	/**
	 * 
	 * @param sessionFactory
	 */
	public UserDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	/**
	 * 
	 * @return
	 */
	public List<User> listEntities() {
		Criteria criteria = createBaseCriteria(User.class);
		@SuppressWarnings("unchecked")
		List<User> listUsers = (List<User>) criteria.list();
		return listUsers;
	}

	/**
	 * 
	 * @param user
	 */
	public void saveOrUpdateEntity(User user) {
		int userId = user.getId();
		
		// Brand new user
		if (userId == 0) {
			Timestamp dateCreated = Utility.getCurrentMySQLDate();
			user.setCreatedDate(dateCreated);
			user.setUpdatedDate(dateCreated);
			user.setActive("Y");
		}
		
		session().saveOrUpdate(user);
	}

	/**
	 * 
	 * @param id
	 */
	public void deleteEntity(User user) {
		// Soft delete only
		user.setActive("N");
		session().saveOrUpdate(user);
		// Hard delete
		//session().delete(user);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public User getEntity(int id) {
		Criteria criteria = createBaseCriteria(User.class);
		SimpleExpression seUserId = Restrictions.eq("id", id);
		criteria.add(seUserId);
		User user = (User) criteria.uniqueResult();
		return user;
	}
}
