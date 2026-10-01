package br.edu.ifrn.servico_veiculos.service;

import br.edu.ifrn.servico_veiculos.dto.VeiculoRequestDTO;
import br.edu.ifrn.servico_veiculos.dto.VeiculoResponseDTO;
import br.edu.ifrn.servico_veiculos.exception.VeiculoNaoEncontradoException;
import br.edu.ifrn.servico_veiculos.model.Veiculo;
import br.edu.ifrn.servico_veiculos.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VeiculoService {
    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository){
        this.repository = repository;
    }

   public VeiculoResponseDTO criar(VeiculoRequestDTO dto){
       Veiculo salvo = repository.save(toEntity(dto));
       return toResponseDTO(salvo);
   }

   public List<Veiculo> listar(){
       return repository.findAll();
   }

   public VeiculoResponseDTO buscarPorId(Long id){
       Veiculo veiculo = repository.findById(id).orElseThrow(() -> new VeiculoNaoEncontradoException(id));
       return toResponseDTO(veiculo);

   }

   public VeiculoResponseDTO editar(Long id, VeiculoRequestDTO dto){
       Veiculo veiculo = repository.findById(id).orElseThrow( () -> new VeiculoNaoEncontradoException(id));

       veiculo.setPlaca(dto.getPlaca());
       veiculo.setModelo(dto.getModelo());
       veiculo.setAnoFabricacao(dto.getAnoFabricacao());
       veiculo.setTipo(dto.getTipo());
       veiculo.setNomeProprietario(dto.getNomeProprietario());
       Veiculo editado = repository.save(veiculo);

       return toResponseDTO(editado);

   }
   public void deletar (Long id)
   {
       Veiculo veiculo = repository.findById(id).orElseThrow(() -> new VeiculoNaoEncontradoException(id)) ;

       repository.deleteById(id);
   }

   private Veiculo toEntity(VeiculoRequestDTO dto) {
      return new Veiculo (
        null,
        dto.getPlaca(),
        dto.getModelo(),
        dto.getAnoFabricacao(),
        dto.getTipo(),
        dto.getNomeProprietario());
   }

   private VeiculoResponseDTO toResponseDTO(Veiculo veiculo){
       return new VeiculoResponseDTO(
               veiculo.getId(),
               veiculo.getPlaca(),
               veiculo.getModelo(),
               veiculo.getAnoFabricacao(),
               veiculo.getTipo(),
               veiculo.getNomeProprietario());
            

       }

}
