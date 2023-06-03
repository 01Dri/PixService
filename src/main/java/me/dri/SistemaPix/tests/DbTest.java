package me.dri.SistemaPix.tests;


import me.dri.SistemaPix.enums.TiposConta;
import me.dri.SistemaPix.models.Banco;
import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.repositories.BancoRepository;
import me.dri.SistemaPix.repositories.ClienteRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

@Configuration
public class DbTest implements CommandLineRunner {



    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BancoRepository bancoRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        clienteRepository.deleteAll();
        bancoRepository.deleteAll();
        
        Cliente cliente = new Cliente(null, "Diego", "123", "123", "123", "123", "123", 200.0);
        Cliente cliente2 = new Cliente(null, "Melanie", "123", "123", "1234", "123", "1234", 50.0);
        Banco banco = new Banco(null, "santander", "003", TiposConta.CORRENTE);
        Banco banco2 = new Banco(null, "santander", "004", TiposConta.POUPANÇA);
        bancoRepository.saveAll(Arrays.asList(banco, banco2));
        cliente.setBanco(banco);
        cliente2.setBanco(banco2);
        clienteRepository.saveAll(Arrays.asList(cliente, cliente2));

    }
}
