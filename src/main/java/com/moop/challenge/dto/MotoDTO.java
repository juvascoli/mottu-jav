package com.moop.challenge.dto;

import org.springframework.hateoas.RepresentationModel;


import com.moop.challenge.model.Moto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class MotoDTO extends RepresentationModel<MotoDTO> {
	
	@NotBlank(message = "O id é obrigatório")
    private Long id; 

    @NotBlank(message = "O chassi é obrigatório")
    @Pattern(regexp = "^[A-HJ-NPR-Z0-9]{17}$", message = "Formato de chassi inválido!")
    private String chassi;

    @NotBlank(message = "O modelo é obrigatório")
    @Size(min = 3, max = 30, message = "O modelo deve ter entre 3 e 30 caracteres")
    private String modelo;

    @NotBlank(message = "A placa é obrigatória")
    @Pattern(regexp = "^[A-Z]{3}-[0-9]{4}$", message = "Formato da placa inválido.")
    private String placa;
    private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChassimoto() {
		return chassi;
	}

	public void setChassimoto(String chassimoto) {
		this.chassi = chassimoto;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public MotoDTO(Long id,
			@NotBlank(message = "O chassi é obrigatório") @Pattern(regexp = "^[A-HJ-NPR-Z0-9]{17}$", message = "Inválido!") String chassimoto,
			@NotBlank(message = "O modelo é obrigatório") @Size(min = 3, max = 30, message = "Inválido! é necessário ter de 3 30 caracteres") String modelo,
			@NotBlank(message = "A placa é obrigatória") @Pattern(regexp = "^[A-Z]{3}-[0-9]{4}$", message = "Formato da placa inválido!") String placa) {
		super();
		this.id = id;
		this.chassi = chassimoto;
		this.modelo = modelo;
		this.placa = placa;
	}

	public MotoDTO() {
		super();
	}

	

	@Override
	public String toString() {
		return "MotoDTO [id=" + id + ", chassimoto=" + chassi + ", modelo=" + modelo + ", placa=" + placa + "]";
	}

	public MotoDTO(Moto moto) {
	    this.id = moto.getId();
	    this.chassi = moto.getChassi();
	    this.modelo = moto.getModelo();
	    this.placa = moto.getPlaca();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
   
}
