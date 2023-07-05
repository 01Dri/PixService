package me.dri.SistemaPix.models.dto;

public record ClienteDTO(Long id, String nome, String sobrenome, String email, String cpf,
                         String senha, String chavePix, Double saldo) {
}
