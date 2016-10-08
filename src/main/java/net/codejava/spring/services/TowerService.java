package net.codejava.spring.services;

import java.util.List;

import net.codejava.spring.model.Tower;

public interface TowerService {
	public List<Tower> list();
	 public void addTower(Tower tower);
	 public void updateTower(Tower tower);
	 public Tower getTowerById(int id);
	 public void removeTower(int id);
}
