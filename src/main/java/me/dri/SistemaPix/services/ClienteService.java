package me.dri.SistemaPix.services;

import me.dri.SistemaPix.exception.ResourceNotFound;
import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.models.dto.ClienteDTO;
import me.dri.SistemaPix.repositories.ClienteRepository;
import me.dri.SistemaPix.utils.ConverterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository repository;

    public ClienteDTO login(String email, String senha) {

        Cliente cliente = repository.findByEmail(email).orElseThrow(() -> new ResourceNotFound("Cliente não localizado"));
        if (cliente.getSenha().equals(senha)) {
            return ConverterEntity.convertyEntityToDTO(cliente);
        } else {
            throw new ResourceNotFound("Cliente não localizado!");
        }

    }

}
