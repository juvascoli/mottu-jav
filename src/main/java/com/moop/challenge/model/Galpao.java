package com.moop.challenge.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "Esta classe irá representar a entidade galpao")
@Data
@Entity
@Table(name = "tbl_galpao")
public class Galpao{

	@Schema(description = "Este atributo representa a chave primária ID", example = "1")
	@Id
	private Long id;
	@NotEmpty(message = "Não é permitido a inserção de galpao sem nome de identificação")
	private String nome;
	private String rua;
	private int numero;
	private String cep;
	
	public Galpao() {
		
	}

	public Galpao(Long id,
			@NotEmpty(message = "Não é permitido a inserção de galpao sem nome de identificação") String nome,
			String rua, int numero, String cep) {
		super();
		this.id = id;
		this.nome = nome;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}
	
	
	
}
