package com.moop.challenge.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

@Schema(description = "DTO que representa os dados do galpão")
public class GalpaoDTO {

    @Schema(description = "Identificador do galpão")
    private Long id;

    @Schema(description = "Nome de identificação do galpão")
    @NotEmpty(message = "Não é permitido a inserção nula")
    private String nome;

    @Schema(description = "Rua onde o galpão está localizado")
    private String rua;

    @Schema(description = "Número do galpão")
    private int numero;

    @Schema(description = "CEP do galpão")
    private String cep;

    public GalpaoDTO() {
    }

    public GalpaoDTO(Long id, String nome_galpao, String rua, int numero, String cep) {
        this.id = id;
        this.nome = nome_galpao;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_galpao() {
        return nome;
    }

    public void setNome_galpao(String nome_galpao) {
        this.nome = nome_galpao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
