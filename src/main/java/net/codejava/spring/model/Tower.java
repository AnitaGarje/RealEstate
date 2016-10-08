package net.codejava.spring.model;

import java.util.HashSet;
import java.util.Set;

public class Tower implements java.io.Serializable{
		private int id;
		private String code;
		private String description; 
		//private Set<Floor> floors=new HashSet<Floor>(0);
		private Sector sector;
		public Tower()
		{
			
		}
		public Tower(int id, String code, String description/*, Set<Floor> floors*/) {
			super();
			this.id = id;
			this.code = code;
			this.description = description;
		}
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
		public Sector getSector() {
			return sector;
		}
		public void setSector(Sector sector) {
			this.sector = sector;
		}
		
		/*public Set<Floor> getFloors() {
			return floors;
		}

		public void setFloors(Set<Floor> floors) {
			this.floors = floors;
		}*/

		


	
}
