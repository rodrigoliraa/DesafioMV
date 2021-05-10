package br.com.rodrigoliira.desafiomv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigoliira.desafiomv.service.CafeService;
import br.com.rodrigoliira.desafiomv.vo.CafeVO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe")
public class CafeController {
	
	private final CafeService service;
	
	@GetMapping
	public ResponseEntity<List<CafeVO>> findAll(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CafeVO cafeVO){
		try {
			service.create(cafeVO);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		service.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
