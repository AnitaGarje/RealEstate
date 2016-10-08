package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Tower;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public class TowerDAOImpl implements TowerDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(TowerDAOImpl.class);
	private SessionFactory sessionFactory;

	public TowerDAOImpl(SessionFactory sessionFactory) {  /*note this is constructor*/
		this.sessionFactory = sessionFactory;
	}

	/*@Override
	@Transactional
	public List<Tower> list() {
		@SuppressWarnings("unchecked")
		List<Tower> listTower = (List<Tower>) sessionFactory.getCurrentSession()
				.createCriteria(Tower.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listTower;
	}*/
	@Override
	@Transactional
	public List<Tower> list() {
		 return (List<Tower>) sessionFactory.getCurrentSession().createCriteria(Tower.class).list();
	}
	

	@Override
	@Transactional
	public void addTower(Tower tower) {
		   sessionFactory.getCurrentSession().persist(tower);
		 }

	@Override
	public void updateTower(Tower tower) {
		sessionFactory.getCurrentSession().update(tower);
		
	}

	@Override
	public Tower getTowerById(int id) {	
		Tower p = (Tower)sessionFactory.getCurrentSession().load(Tower.class, new Integer(id));
		//System.out.println("ID is:"+id);
		logger.info("Tower loaded successfully, Tower details="+p);
		return p;
	}

	@Override
	public void removeTower(int id) {
		Tower p = (Tower) sessionFactory.getCurrentSession().load(Tower.class, new Integer(id));
		if(null != p){
			sessionFactory.getCurrentSession().delete(p);
		}
		logger.info("Tower deleted successfully, Tower details="+p);
		
	}


	
	

	
}
