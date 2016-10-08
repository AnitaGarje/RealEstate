package net.codejava.spring.services;

import java.util.List;





import net.codejava.spring.dao.TowerDAO;
import net.codejava.spring.model.Tower;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


@Service("towerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TowerServiceImpl implements TowerService{
	
	 @Autowired
	 private TowerDAO towerDao;
	 
	 @Override
	 public List<Tower> list() {
		  return towerDao.list();
		 }
	 
	 
	// @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	 @Override
	 public void addTower(Tower tower) {
		 towerDao.addTower(tower);
	 }


	@Override
	@Transactional
	public void updateTower(Tower tower) {
		towerDao.updateTower(tower);
		
	}
	
	@Override
	@Transactional
	public Tower getTowerById(int id) {	
		return this.towerDao.getTowerById(id);
	}


	@Override
	@Transactional
	public void removeTower(int id) {
		this.towerDao.removeTower(id);
	}
}
