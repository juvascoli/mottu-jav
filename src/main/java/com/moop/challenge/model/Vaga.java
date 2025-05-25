package com.moop.challenge.model;
import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;



@Schema(description = "Esta classe representa a entidade Vaga no sistema")
@Entity
@Table(name = "tbl_vaga")
public class Vaga extends RepresentationModel<Vaga> {

    @Schema(description = "Chave primária da vaga")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vaga;

    @Schema(description = "Status da vaga")
    @NotNull(message = "O status da vaga é obrigatório")
    private String status;

    @Schema(description = "Data de entrada da moto na vaga")
    @PastOrPresent(message = "A data de entrada não pode estar no futuro")
    @NotNull
    private LocalDate data_entrada;

    @Schema(description = "Data de saída da moto da vaga")
    @NotNull
    private LocalDate data_saida;

    @Schema(description = "Moto relacionada a vaga")
    @ManyToOne
    @JoinColumn(name = "id_moto", nullable = false)
    private Moto moto;

}