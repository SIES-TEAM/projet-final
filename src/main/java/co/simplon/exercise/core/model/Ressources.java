package co.simplon.exercise.core.model;

public class Ressources {

		private Long resource_id; 
		
		
		private String name; // Nom de la ressource

		public Ressources() {
			super();
		}

		public Ressources(Long resource_id, String name) {
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
