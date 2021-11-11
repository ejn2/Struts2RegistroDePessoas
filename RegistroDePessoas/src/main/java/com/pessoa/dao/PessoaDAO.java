package com.pessoa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pessoa.models.Pessoa;

public class PessoaDAO {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private static EntityManager manager;
	
	//SELECT
	public static List<Pessoa> findAll() {
		manager = factory.createEntityManager();
		List<Pessoa> pessoa = null;
		
		try {
			pessoa = manager.createQuery("from Pessoa").getResultList();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}finally {
			manager.close();
		}
		
		return pessoa;
		
	}
	
	
	//UPDATE e CREATE
	public static Pessoa save(Pessoa pessoa) {
		manager = factory.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			manager.persist(pessoa);
			manager.getTransaction().commit();
			
		}catch(Exception ex) {
			manager.getTransaction().rollback();
			ex.printStackTrace();
			
		}finally {
			manager.close();
		}
		
		return pessoa;
	}
	
	
	//DELETE
	public static void deleteByPk(Long id) {
		manager = factory.createEntityManager();
		String query = "delete from Pessoa where id = :id";
		
		try {
			manager.getTransaction().begin();
			manager.createQuery(query).setParameter("id", id)
				.executeUpdate();
			manager.getTransaction().commit();
			
		}catch(Exception ex) {
			manager.getTransaction().rollback();
			ex.printStackTrace();
			
		}finally {
			manager.close();
		}
		
	}
	
}
