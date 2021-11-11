package com.pessoa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pessoa.models.Endereco;

public class EnderecoDAO {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private static EntityManager manager;
	
	public static Endereco save(Endereco endereco) {
		manager = factory.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			manager.merge(endereco);
			manager.getTransaction().commit();
			
		}catch(Exception ex) {
			manager.getTransaction().rollback();
			ex.printStackTrace();
			
		}finally {
			manager.close();
		}
		
		return endereco;
	}
	
}
