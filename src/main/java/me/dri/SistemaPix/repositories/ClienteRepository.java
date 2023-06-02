package me.dri.SistemaPix.repositories;

import me.dri.SistemaPix.models.Cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByChavePix(String chavePix);



}
