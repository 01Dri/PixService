package me.dri.SistemaPix.models;

import jakarta.persistence.*;
import me.dri.SistemaPix.enums.TiposConta;



@Entity
public class Banco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String agencia;
    private TiposConta tipo;

    public Banco() {

    }

    public Banco(Long id, String nome, String agencia, TiposConta tipo) {
        this.id = id;
        this.nome = nome;
        this.agencia = agencia;
        this.tipo = tipo;
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


    public TiposConta getTipo() {
        return tipo;
    }

    public void setTipo(TiposConta tipo) {
        this.tipo = tipo;
    }


    

}
