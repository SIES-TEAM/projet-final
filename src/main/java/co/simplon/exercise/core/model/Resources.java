package co.simplon.exercise.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


public class Resources {
			
		
		private Long resource_id; 
		
		@Column(name = "name")
		private String name; // Nom de la ressource

		public Resources() {
			super();
		}

		public Resources(Long resource_id, String name) {
			super();
			this.resource_id = resource_id;
			this.name = name;
		}

		public Long getResource_id() {
			return resource_id;
		}

		public void setResource_id(Long resource_id) {
			this.resource_id = resource_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
}
