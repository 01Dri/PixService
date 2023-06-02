package me.dri.SistemaPix.services;

import me.dri.SistemaPix.models.Banco;
import me.dri.SistemaPix.repositories.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoService {


    @Autowired
    private BancoRepository repository;


    public Optional<Banco> findById(Long id) {
        return repository.findById(id);
    }

    public List<Banco> findALl() {
        return repository.findAll();
    }

    
}
