package me.dri.SistemaPix.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.dri.SistemaPix.models.Cliente;


@Repository
public interface PixRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByChavePix(String chavePix);
    @Query("SELECT c.chavePix FROM Cliente c")
    List<String> findAllChavePix();
    
}
