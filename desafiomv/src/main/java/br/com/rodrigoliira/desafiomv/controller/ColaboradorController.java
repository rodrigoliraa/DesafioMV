package br.com.rodrigoliira.desafiomv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigoliira.desafiomv.service.ColaboradorService;
import br.com.rodrigoliira.desafiomv.vo.ColaboradorVO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/colaborador")
public class ColaboradorController {
	
	private final ColaboradorService service;
	
	@GetMapping
	public ResponseEntity<List<ColaboradorVO>> findAll(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ColaboradorVO> findById(@PathVariable Integer id) {
		
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ColaboradorVO colaboradorVO){
		try {
			service.create(colaboradorVO);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody ColaboradorVO colaboradorVO){
		service.update(colaboradorVO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		service.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
