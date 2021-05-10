package br.com.rodrigoliira.desafiomv.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({"codigo","colaborador","lanche"})
public class CafeVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("codigo")
	private Integer id;
	private ColaboradorVO colaborador;
	private LancheVO lanche;

}
