package com.example.jpah2demo;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="endereco_id")
    private Long id;
    private String logradouro;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
}