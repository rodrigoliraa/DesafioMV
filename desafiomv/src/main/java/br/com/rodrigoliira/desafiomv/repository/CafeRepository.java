package br.com.rodrigoliira.desafiomv.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.rodrigoliira.desafiomv.model.Cafe;

@Repository
public class CafeRepository {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	public void inserir(Cafe cafe) {
		
		
	    entityManager.createNativeQuery(" INSERT INTO cafe (colaborador_id, lanche_id) VALUES (?,?) ")
	      .setParameter(1, cafe.getColaborador().getId())
	      .setParameter(2, cafe.getLanche().getId())
	      .executeUpdate();
	}
	
	public List<Cafe> findAll() {
		Query query = entityManager.createNativeQuery(" SELECT * FROM cafe ", Cafe.class);
		var cafe = query.getResultList();
		
		return cafe;
	}
	
	
	@Transactional
	public void delete(Integer id) {
		entityManager.createNativeQuery(" DELETE FROM cafe WHERE id = ? ")
	      .setParameter(1, id)
	      .executeUpdate();
	}

}
