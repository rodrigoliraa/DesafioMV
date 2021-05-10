package br.com.rodrigoliira.desafiomv.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.rodrigoliira.desafiomv.model.Colaborador;
import br.com.rodrigoliira.desafiomv.repository.ColaboradorRepostory;
import br.com.rodrigoliira.desafiomv.util.MapperConverter;
import br.com.rodrigoliira.desafiomv.vo.ColaboradorVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColaboradorService {
	
	private final ColaboradorRepostory repository;
	
	public ColaboradorVO findById(Integer id) {
		var colaborador = repository.findById(id);
		
		return convertToVO(colaborador);
	}
	
	public void create(ColaboradorVO colaboradorVO) throws Exception {
		var colaboradoresAtuais = repository.findAll();
		
		if(colaboradoresAtuais.stream().anyMatch(c -> c.getCpf().equalsIgnoreCase(colaboradorVO.getCpf())))
			throw new Exception("Cpf já cadastrado");
		
		repository.inserir(convertToModel(colaboradorVO));
	}
	
	public void update(ColaboradorVO colaboradorVO) {
		repository.update(convertToModel(colaboradorVO));
	}
	
	public List<ColaboradorVO> findAll(){
		var colaboradores = repository.findAll().stream().map(item -> convertToVO(item)).collect(Collectors.toList());
		
		return colaboradores;
	}
	
	public void delete(Integer id) {
		repository.delete(id);
	}
	
	
	
	private ColaboradorVO convertToVO(Colaborador colaborador) {
		return MapperConverter.convertObject(colaborador, ColaboradorVO.class);
	}
	
	private Colaborador convertToModel(ColaboradorVO colaboradorVO) {
		return MapperConverter.convertObject(colaboradorVO, Colaborador.class);
	}

}
