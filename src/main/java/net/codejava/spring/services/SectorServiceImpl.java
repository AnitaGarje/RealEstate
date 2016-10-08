package net.codejava.spring.services;

import java.util.List;





import net.codejava.spring.dao.SectorDAO;
import net.codejava.spring.model.Sector;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


@Service("sectorService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SectorServiceImpl implements SectorService{
	
	 @Autowired
	 private SectorDAO sectorDao;
	 
	 @Override
	 public List<Sector> list() {
		  return sectorDao.list();
		 }
	 
	 
	// @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	 @Override
	 public void addSector(Sector sector) {
		 sectorDao.addSector(sector);
	 }


	@Override
	@Transactional
	public void updateSector(Sector sector) {
		sectorDao.updateSector(sector);
		
	}
	
	@Override
	@Transactional
	public Sector getSectorById(int id) {	
		return this.sectorDao.getSectorById(id);
	}


	@Override
	@Transactional
	public void removeSector(int id) {
		this.sectorDao.removeSector(id);
	}
}
