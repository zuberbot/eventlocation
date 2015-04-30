/**
 * DAO
 */
package springmvc.model.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Chuck
 *
 */
@Repository
@Transactional
public class DAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 */
	public DAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 
	 * @return
	 */
	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 
	 * @return
	 */
	public Criteria createBaseCriteria(Class<?> c) {
		SimpleExpression seActive = Restrictions.eq("active", "Y");
		Criteria criteria = session().createCriteria(c);
		criteria.add(seActive);
		return criteria;
	}

}
