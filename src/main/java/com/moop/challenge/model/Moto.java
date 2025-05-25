package com.moop.challenge.model;


import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_moto")
public class Moto  extends RepresentationModel<Moto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_moto")
    private Long id;

    @Column(length = 7)
    private String placa;

    @Column(length = 17)
    private String chassi;

    @Column(nullable = false, length = 10)
    private String status;

    @Column(nullable = false, length = 30)
    private String modelo;

    public Moto() {
    }

    public Moto(Long id, String placa, String chassi, String status, String modelo, Integer idCamera) {
        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.status = status;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }



}