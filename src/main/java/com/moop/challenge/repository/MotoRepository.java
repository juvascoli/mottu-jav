package com.moop.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moop.challenge.model.Moto;

public interface MotoRepository extends JpaRepository<Moto, Long>{
	
	@Query("from Moto m where m.placa = :placa")
	public List<Moto> retornaMotosPorPlaca(String placa);

	@Query("from Moto m where m.placa = :modelo")
	public List<Moto> retornaMotosPorModelo(String modelo);

	@Query("from Moto m where m.status = :status")
	
	public List<Moto> retornaMotosPorStatus(String status);
	@Query("from Moto m where m.chassi = :chassi")
	public List<Moto> retornaMotosPorChassi(String chassi);
}