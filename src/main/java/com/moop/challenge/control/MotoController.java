package com.moop.challenge.control;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestBody;

import com.moop.challenge.dto.MotoDTO;
import com.moop.challenge.model.Moto;
import com.moop.challenge.repository.MotoRepository;
import com.moop.challenge.service.MotoCachingService;
import com.moop.challenge.service.MotoService;

import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value= "/motos")
public class MotoController {
	
	@Autowired
	private MotoRepository repM;
	
	@Autowired
	private MotoCachingService cacheM;
	
	@Autowired
	private MotoService servM;
	
	
	@Operation(description="Essa operação busca e disponibiliza todas as motos")
	@GetMapping
	public List<Moto> retornaTodasMotos() {
		return repM.findAll();
	}
	
	@Operation(description = "Esta operação possibilita a busca paginada das motos")
	@GetMapping(value="/paginada")
	public ResponseEntity<Page<MotoDTO>> retornaMotosPaginadas(
  		@RequestParam(value= "page", defaultValue = "0") Integer page,
  		@RequestParam(value= "size", defaultValue = "7") Integer size){
  	
	  	PageRequest req = PageRequest.of(page, size);
	  	Page<MotoDTO> moto_paginado = servM.paginar(req);

	  	return ResponseEntity.ok(moto_paginado);
	}
	
	@Operation(description = "Esta operação retorna todas as motos existentes utilizando caching")
	@GetMapping("/cacheable")
	public List<Moto> retornaTodasMotosCacheables(){
		List<Moto> todas_motos = cacheM.findAll();
		
		for(Moto m : todas_motos) {
			m.add(linkTo(methodOn(MotoController.class)
					.retornaMotoPorID(m.getId()))
					.withRel("mais informações " + m.getChassi() + "?"));
			
			m.add(linkTo(methodOn(MotoController.class)
					.retornaMotosPaginadas(null, null))
					.withRel("motos paginas"));
			
			m.add(linkTo(methodOn(MotoController.class)
					.adicionarMoto(null))
					.withRel("inserção de moto"));
			
			m.add(linkTo(methodOn(MotoController.class)
					.atualizaMotoPorId(m.getId(), null))
					.withRel("atualizar moto" + m.getChassi() ));
		}
		
		return todas_motos;
	}
	
	@Operation(description = "Esta operação busca a moto por seu ID")
	@GetMapping(value="/{id}")
	public Moto retornaMotoPorID(@PathVariable Long id) {
		return repM.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "moto com identificação não valida: " + id ));
	}
	
	

	
	
	@PostMapping(value = "/inserir")
	public ResponseEntity<MotoDTO> adicionarMoto(@Valid @RequestBody MotoDTO motoDTO){
	    Moto moto = new Moto();
	    moto.setChassi(motoDTO.getChassimoto());
	    moto.setModelo(motoDTO.getModelo());
	    moto.setPlaca(motoDTO.getPlaca());
	    moto.setStatus(motoDTO.getStatus());
	    
	   
	    Moto motoSalva = repM.save(moto);

	    
	    MotoDTO motoSalvaDTO = new MotoDTO(motoSalva);
	  
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	            .path("/{id}")
	            .buildAndExpand(motoSalva.getId())
	            .toUri();
	    return ResponseEntity.created(uri).body(motoSalvaDTO);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<MotoDTO> atualizaMotoPorId(
	        @PathVariable Long id,
	        @Valid @RequestBody MotoDTO motoDTO) {

	    Optional<Moto> op = repM.findById(id);

	    if (op.isPresent()) {
	        Moto motoExistente = op.get();

	        
	        motoExistente.setModelo(motoDTO.getModelo());
	        motoExistente.setPlaca(motoDTO.getPlaca());
	        motoExistente.setChassi(motoDTO.getChassimoto());
	        motoExistente.setStatus(motoDTO.getStatus());

	        Moto motoAtualizada = repM.save(motoExistente);

	        MotoDTO dtoAtualizada = new MotoDTO(motoAtualizada);

	      
	        dtoAtualizada.add(linkTo(methodOn(MotoController.class).retornaMotoPorID(id)).withSelfRel());
	        dtoAtualizada.add(linkTo(methodOn(MotoController.class).atualizaMotoPorId(id, motoDTO)).withRel("atualizar"));

	        return ResponseEntity.ok(dtoAtualizada);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	
	@Operation(description = "deletar por id")
	@DeleteMapping(value="/excluir/{id}")
	public ResponseEntity<Void> deletaMoto(@PathVariable Long id) {
		
		Optional<Moto> op = repM.findById(id);
			
		if(op.isPresent()) {
			repM.delete(op.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}