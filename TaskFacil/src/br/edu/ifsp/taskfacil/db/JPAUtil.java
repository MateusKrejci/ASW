package br.edu.ifsp.taskfacil.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("taskfacil");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
