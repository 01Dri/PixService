package me.dri.SistemaPix.models.dto;

import me.dri.SistemaPix.models.Banco;

import java.io.Serializable;

public class ClienteDTO  implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String chave_pix;
    private Double saldo;

    private Banco banco;

    public ClienteDTO() {

    }

    public ClienteDTO(Long id, String nome, String email, String chave_pix, Double saldo, Banco banco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.chave_pix = chave_pix;
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

    public String getChave_pix() {
        return chave_pix;
    }

    public void setChave_pix(String chave_pix) {
        this.chave_pix = chave_pix;
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
