package br.com.rodrigoliira.desafiomv.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.rodrigoliira.desafiomv.model.Lanche;

@Repository
public class LancheRepository {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	public void inserir(Lanche lanche) {
	    entityManager.createNativeQuery("INSERT INTO lanche (nome, ativo) VALUES (?,true)")
	      .setParameter(1, lanche.getNome())
	      .executeUpdate();
	}
	
	@Transactional
	public void update(Lanche lanche) {
	    entityManager.createNativeQuery("UPDATE lanche SET nome = ? WHERE id = ? ")
	      .setParameter(1, lanche.getNome())
	      .setParameter(2, lanche.getId())
	      .executeUpdate();
	}
	
	public Lanche findById(Integer id) {
		Query query = entityManager.createNativeQuery(" SELECT * FROM lanche WHERE ativo = true and id = ? ", Lanche.class);
		query.setParameter(1, id);
		
		var lanche = (Lanche) query.getSingleResult();
		
		return lanche;
	}
	
	public List<Lanche> findAll() {
		Query query = entityManager.createNativeQuery(" SELECT * FROM lanche WHERE ativo = true ", Lanche.class);
		var lanches = query.getResultList();
		
		return lanches;
	}
	
	@Transactional
	public void delete(Integer id) {
		entityManager.createNativeQuery("UPDATE lanche SET ativo = false WHERE id = ? ")
	      .setParameter(1, id)
	      .executeUpdate();
	}

}
