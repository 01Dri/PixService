package me.dri.SistemaPix.services;

import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository repository;


    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    public List<Cliente> findALl() {
        return repository.findAll();
    }

}
