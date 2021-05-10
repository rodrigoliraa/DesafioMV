package br.com.rodrigoliira.desafiomv.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.rodrigoliira.desafiomv.model.Cafe;
import br.com.rodrigoliira.desafiomv.repository.CafeRepository;
import br.com.rodrigoliira.desafiomv.util.MapperConverter;
import br.com.rodrigoliira.desafiomv.vo.CafeVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CafeService {
	
	private final CafeRepository repository;
	
	public void create(CafeVO cafeVO) throws Exception {
		var cafeAtuais = repository.findAll();
		
		if(cafeAtuais.stream().anyMatch(c -> c.getLanche().getId().intValue() == cafeVO.getLanche().getId().intValue()))
			throw new Exception("Lanche ja cadastrado");
		
		
		repository.inserir(convertToModel(cafeVO));
	}
	
	public List<CafeVO> findAll(){
		var cafe = repository.findAll().stream().map(item -> convertToVO(item)).collect(Collectors.toList());
		
		return cafe;
	}
	
	public void delete(Integer id) {
		repository.delete(id);
	} 

	
	
	
	private CafeVO convertToVO(Cafe cafe) {
		return MapperConverter.convertObject(cafe, CafeVO.class);
	}
	
	private Cafe convertToModel(CafeVO cafeVO) {
		return MapperConverter.convertObject(cafeVO, Cafe.class);
	}

}
