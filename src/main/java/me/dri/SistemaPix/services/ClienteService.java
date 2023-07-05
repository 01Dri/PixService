package me.dri.SistemaPix.services;

import me.dri.SistemaPix.exception.ResourceNotFound;
import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.models.dto.ClienteDTO;
import me.dri.SistemaPix.repositories.ClienteRepository;
import me.dri.SistemaPix.utils.ConverterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository repository;

    public ClienteDTO login(ClienteDTO clienteDTO2) {
        var cliente = repository.findByEmail(clienteDTO2.email()).orElseThrow();
        if (cliente.getSenha().equals(clienteDTO2.senha())) {
            return ConverterEntity.convertyEntityToDTO2(cliente);
        }
        throw new ResourceNotFound("Cliente não localizado!");
    }

    public ClienteDTO findById(Long id) {
        var result = repository.findById(id).orElseThrow();
        return ConverterEntity.convertyEntityToDTO2(result);

    }

    public List<ClienteDTO> findAll() {
        var clientes = repository.findAll();
        return ConverterEntity.convertityListToDTO2(clientes);
    }

}
