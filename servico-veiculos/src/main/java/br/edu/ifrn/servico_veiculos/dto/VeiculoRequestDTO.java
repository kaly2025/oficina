package br.edu.ifrn.servico_veiculos.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoRequestDTO {
    @NotBlank(message = "A placa nao pode ser nula")
    private String placa;
    @NotBlank(message = "O modelo nao ser nulo")
    private String modelo;
    @NotNull
    private Integer anoFabricacao;
    @NotBlank(message = "O tipo do veiculo nao pode ser nulo")
    private String tipo;
    @NotBlank(message = "O nome nao pode ser nulo")
    private String nomeProprietario;

}
