package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Sector;

public interface SectorDAO {
	public List<Sector> list();
	 public void addSector(Sector sector);
	 public void updateSector(Sector sector);
	 public Sector getSectorById(int id);
	 public void removeSector(int id);
}
