package br.edu.ifrn.servico_veiculos.controller;

import br.edu.ifrn.servico_veiculos.dto.VeiculoRequestDTO;
import br.edu.ifrn.servico_veiculos.dto.VeiculoResponseDTO;
import br.edu.ifrn.servico_veiculos.model.Veiculo;
import br.edu.ifrn.servico_veiculos.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    private final VeiculoService service;

    public VeiculoController(VeiculoService service){
        this.service = service;
    }

    @GetMapping
    public List<Veiculo> listar(){
        return service.listar();
    }
    @GetMapping("/{id}")
    public VeiculoResponseDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }
    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> criar(@Valid @RequestBody VeiculoRequestDTO dto){
        VeiculoResponseDTO veiculo = service.criar(dto);
        URI uri = URI.create("/veiculos/" + veiculo.getId());

        return ResponseEntity.created(uri).body(veiculo);
    }
     @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> editar(
            @PathVariable Long id,
            @Valid @RequestBody VeiculoRequestDTO dto) {

        VeiculoResponseDTO editado = service.editar(id, dto);
                

        return ResponseEntity.ok(editado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
        @PathVariable Long id){
            service.deletar(id);
            return  ResponseEntity.noContent().build();
        }
    

}

