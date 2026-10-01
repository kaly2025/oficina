package br.edu.ifrn.servico_veiculos.repository;

import br.edu.ifrn.servico_veiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
    List<Veiculo> findByPlaca(String placa);
    List<Veiculo> findByModelo(String modelo);
    List<Veiculo> findByAnoFabricacao(Integer anoFabricacao);
    List<Veiculo> findByTipo(String tipo);
    List<Veiculo> findByPlaca(String nomeProprietario);

}
