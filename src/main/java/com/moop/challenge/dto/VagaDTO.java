package com.moop.challenge.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Schema(description = "DTO que representa uma vaga de moto")
public class VagaDTO {

    @Schema(description = "Identificador da vaga")
    private Long id;

    @Schema(description = "Status da vaga")
    @NotNull
    private String status;

    @Schema(description = "Data de entrada da moto na vaga")
    @NotNull
    private LocalDate dataEntrada;

    @Schema(description = "Data de saída da moto da vaga")
    @NotNull
    private LocalDate dataSaida;

    @Schema(description = "Identificador da moto associada")
    @NotNull
    private Long idMoto;

    public VagaDTO() {
    }

    public VagaDTO(Long id, String status, LocalDate dataEntrada, LocalDate dataSaida, Long idMoto) {
        this.id = id;
        this.status = status;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.idMoto = idMoto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Long getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(Long idMoto) {
        this.idMoto = idMoto;
    }
}
