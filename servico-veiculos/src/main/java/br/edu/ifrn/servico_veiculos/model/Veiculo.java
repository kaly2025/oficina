package br.edu.ifrn.servico_veiculos.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "veiculos")
@Data @NoArgsConstructor @AllArgsConstructor
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String modelo;
    private Integer anoFabricacao;
    private String tipo;
    private String nomeProprietario;




}

