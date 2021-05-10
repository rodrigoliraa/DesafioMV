package br.com.rodrigoliira.desafiomv.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({"codigo", "nome", "cpf"})
public class ColaboradorVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("codigo")
	private Integer id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("cpf")
	private String cpf;
	
	@JsonIgnore
	private boolean ativo;

}
