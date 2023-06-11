package me.dri.SistemaPix.models.dto;

import me.dri.SistemaPix.models.Banco;

import java.io.Serializable;

public class ClienteDTO  implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private Double saldo;

    private Banco banco;

    public ClienteDTO() {

    }

    public ClienteDTO(Long id, String nome, String email, Double saldo, Banco banco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.saldo = saldo;
        this.banco = banco;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
