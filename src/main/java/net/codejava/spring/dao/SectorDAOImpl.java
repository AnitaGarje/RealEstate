package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Sector;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public class SectorDAOImpl implements SectorDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(SectorDAOImpl.class);
	private SessionFactory sessionFactory;

	public SectorDAOImpl(SessionFactory sessionFactory) {  /*note this is constructor*/
		this.sessionFactory = sessionFactory;
	}

	/*@Override
	@Transactional
	public List<Sector> list() {
		@SuppressWarnings("unchecked")
		List<Sector> listSector = (List<Sector>) sessionFactory.getCurrentSession()
				.createCriteria(Sector.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listSector;
	}*/
	@Override
	@Transactional
	public List<Sector> list() {
		 return (List<Sector>) sessionFactory.getCurrentSession().createCriteria(Sector.class).list();
	}
	

	@Override
	@Transactional
	public void addSector(Sector sector) {
		   sessionFactory.getCurrentSession().persist(sector);
		 }

	@Override
	public void updateSector(Sector sector) {
		sessionFactory.getCurrentSession().update(sector);
		
	}

	@Override
	public Sector getSectorById(int id) {	
		Sector p = (Sector)sessionFactory.getCurrentSession().load(Sector.class, new Integer(id));
		//System.out.println("ID is:"+id);
		logger.info("Sector loaded successfully, Sector details="+p);
		return p;
	}

	@Override
	public void removeSector(int id) {
		Sector p = (Sector) sessionFactory.getCurrentSession().load(Sector.class, new Integer(id));
		if(null != p){
			sessionFactory.getCurrentSession().delete(p);
		}
		logger.info("Sector deleted successfully, Sector details="+p);
		
	}


	
	

	
}
