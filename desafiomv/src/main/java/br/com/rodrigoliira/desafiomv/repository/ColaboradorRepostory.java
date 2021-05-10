package br.com.rodrigoliira.desafiomv.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.rodrigoliira.desafiomv.model.Colaborador;

@Repository
public class ColaboradorRepostory {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	public void inserir(Colaborador colaborador) {
	    entityManager.createNativeQuery("INSERT INTO colaborador (nome, cpf, ativo) VALUES (?,?, true)")
	      .setParameter(1, colaborador.getNome())
	      .setParameter(2, colaborador.getCpf())
	      .executeUpdate();
	}
	
	@Transactional
	public void update(Colaborador colaborador) {
	    entityManager.createNativeQuery("UPDATE colaborador SET nome = ?, cpf = ? WHERE id = ? ")
	      .setParameter(1, colaborador.getNome())
	      .setParameter(2, colaborador.getCpf())
	      .setParameter(3, colaborador.getId())
	      .executeUpdate();
	}
	
	public Colaborador findById(Integer id) {
		Query query = entityManager.createNativeQuery(" SELECT * FROM colaborador WHERE ativo = true and id = ? ", Colaborador.class);
		query.setParameter(1, id);
		
		var colaborador = (Colaborador) query.getSingleResult();
		
		return colaborador;
	}
	
	public List<Colaborador> findAll() {
		Query query = entityManager.createNativeQuery(" SELECT * FROM colaborador WHERE ativo = true ", Colaborador.class);
		var colaboradores = query.getResultList();
		
		return colaboradores;
	}
	
	@Transactional
	public void delete(Integer id) {
		entityManager.createNativeQuery("UPDATE colaborador SET ativo = false WHERE id = ? ")
	      .setParameter(1, id)
	      .executeUpdate();
	}
	

}
