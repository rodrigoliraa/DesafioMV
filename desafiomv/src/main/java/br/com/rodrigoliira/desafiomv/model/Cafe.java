package br.com.rodrigoliira.desafiomv.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cafe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cafe implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lanche_id")
	private Lanche lanche;
	

}
