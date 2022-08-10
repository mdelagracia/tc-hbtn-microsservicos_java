package com.example.jpah2demo;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Telefone {

    @Id
    @GeneratedValue
    @Column(name="telefone_id")
    private Long id;
    private String ddd;
    private String numero;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
}