package br.edu.ifrn.servico_veiculos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoResponseDTO {

    private Long id;
    private String placa;
    private String modelo;
    private Integer anoFabricacao;
    private String tipo;
    private String nomeProprietario;
}
