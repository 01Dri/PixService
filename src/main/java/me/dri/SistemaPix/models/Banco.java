package me.dri.SistemaPix.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Banco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String agencia;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banco")
    private List<Cliente> clientes = new ArrayList<>();

    public Banco() {

    }

    public Banco(Long id, String nome, String agencia) {
        this.id = id;
        this.nome = nome;
        this.agencia = agencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

}
