package br.edu.ifsp.taskfacil.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.edu.ifsp.taskfacil.db.JPAUtil;
import br.edu.ifsp.taskfacil.models.Usuario;

public class UsuarioDAO {

	private EntityManager manager;

	public UsuarioDAO() {
		this.manager = JPAUtil.getEntityManager();
	}

	@Override
	public void finalize() {
		this.manager.close();
	}

	public void inserir(Usuario usuario) {
		this.manager.getTransaction().begin();
		this.manager.persist(usuario);
		this.manager.getTransaction().commit();
	}

	public void deletar(Usuario usuario) {
		this.manager.getTransaction().begin();
		this.manager.find(Usuario.class, usuario.getId());
		this.manager.remove(usuario);
		this.manager.getTransaction().commit();
	}
	

	@Override
	public String toString() {
		return "UsuarioDAO [manager=" + manager + "]";
	}
	
	public List<Usuario> existeEmail(String email) {
		TypedQuery<Usuario> query = manager.createQuery(" from Usuario us where us.email=:email", Usuario.class);
		query.setParameter("email", email);
		List<Usuario> list = query.getResultList();
		return list;
	}

	public void selecionar(Usuario usuario) {
		Query query = manager.createQuery(" select s from Usuario s ");
	}
}
