package br.com.rodrigoliira.desafiomv.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.rodrigoliira.desafiomv.model.Lanche;
import br.com.rodrigoliira.desafiomv.repository.LancheRepository;
import br.com.rodrigoliira.desafiomv.util.MapperConverter;
import br.com.rodrigoliira.desafiomv.vo.LancheVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LancheService {
	
	private final LancheRepository repository;
	
	public LancheVO findById(Integer id) {
	    var lanche = repository.findById(id);
	    
	    return convertToVO(lanche);
	}

	public void create(LancheVO lancheVO) {
	    repository.inserir(convertToModel(lancheVO));
	}

	public void update(LancheVO lancheVO) {
	    repository.update(convertToModel(lancheVO));
	}

	public List<LancheVO> findAll(){
	    var lanches = repository.findAll().stream().map(item -> convertToVO(item)).collect(Collectors.toList());
	    
	    return lanches;
	}
	
	public void delete(Integer id) {
		repository.delete(id);
	}
	
	
	private LancheVO convertToVO(Lanche lanche) {
		return MapperConverter.convertObject(lanche, LancheVO.class);
	}
	
	private Lanche convertToModel(LancheVO lancheVO) {
		return MapperConverter.convertObject(lancheVO, Lanche.class);
	}

}
