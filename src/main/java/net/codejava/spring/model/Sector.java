package net.codejava.spring.model;

import java.util.HashSet;
import java.util.Set;

public class Sector implements java.io.Serializable{
	private int id;
	private String code;
	private String description;
	//private Set<Tower> towers = new HashSet<Tower>(0);
	private Project project;
	public Sector() //why?
	{
		
	}
	
	public Sector(int id, String code, String description /*,Set<Tower> towers*/,Project prj) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.project=prj;
		//this.towers = towers;
	}

/*	public Sector(int id, String code, String description, Project project,
			Set<Tower> towers) {
		//super(); why?
		this.id = id;
		this.code = code;
		this.description = description;
		//this.towers = towers;
	}*/
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	/*public Set<Tower> getTowers() {
		return towers;
	}
	public void setTowers(Set<Tower> towers) {
		this.towers = towers;
	}*/

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	


}
