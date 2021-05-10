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

import br.com.rodrigoliira.desafiomv.service.LancheService;
import br.com.rodrigoliira.desafiomv.vo.LancheVO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lanche")
public class LancheController {
	
	private final LancheService service;
	
	@GetMapping
	public ResponseEntity<List<LancheVO>> findAll(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<LancheVO> findById(@PathVariable Integer id) {
		
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody LancheVO lancheVO){
		service.create(lancheVO);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody LancheVO lancheVO){
		service.update(lancheVO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		service.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
