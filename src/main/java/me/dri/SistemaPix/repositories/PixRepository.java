package me.dri.SistemaPix.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dri.SistemaPix.models.Cliente;


@Repository
public interface PixRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByChavePix(String chavePix);
    
}
