package me.dri.SistemaPix.tests;


import me.dri.SistemaPix.models.Banco;
import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.repositories.BancoRepository;
import me.dri.SistemaPix.repositories.ClienteRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbTest implements CommandLineRunner {



    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BancoRepository bancoRepository;
    @Override
    public void run(String... args) throws Exception {

        clienteRepository.deleteAll();
        Cliente cliente = new Cliente(null, "Diego", "123", "123", "123", "123", "123", 200.0);
        Cliente cliente2 = new Cliente(null, "Melanie", "123", "123", "1234", "123", "1234", 50.0);
        Banco banco = new Banco(1L, "santander", "003");
        bancoRepository.save(banco);
        cliente.setBanco(banco);
        cliente2.setBanco(banco);
        clienteRepository.saveAll(Arrays.asList(cliente, cliente2));

    }
}
