package com.example.jpah2demo;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cliente_id")
    private Long id;
    private String nome;
    private int idade;
    private String email;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_id")
    private Set<Telefone> telefones = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Set<Endereco> enderecos = new HashSet<>();
}