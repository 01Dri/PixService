package me.dri.SistemaPix.mocks;

import me.dri.SistemaPix.enums.TiposConta;
import me.dri.SistemaPix.models.Banco;
import me.dri.SistemaPix.models.Cliente;

public class MockCliente {

    Banco banco = new Banco(1L, "0003", "Santander", TiposConta.POUPANÇA);
    Banco banco2 = new Banco(2L, "0003", "Santander", TiposConta.CORRENTE);
    public Cliente mockClienteBancoPoupanca(Integer number) {
        Cliente cliente = new Cliente();
        cliente.setId(number.longValue());
        cliente.setNome("Diego");
        cliente.setSobrenome("Henrique");
        cliente.setEmail("diego@gmail.com");
        cliente.setBanco(banco);
        cliente.setCpf("123");
        cliente.setSenha("123");
        cliente.setChavePix("123");
        cliente.setSaldo(300.0);
        return cliente;
    }

    public Cliente mockCliente2BancoPoupanca(Integer number) {
        Cliente cliente = new Cliente();
        cliente.setId(number.longValue());
        cliente.setNome("Melanie");
        cliente.setSobrenome("Henrique");
        cliente.setEmail("diego@gmail.com");
        cliente.setBanco(banco);
        cliente.setCpf("123");
        cliente.setSenha("123");
        cliente.setChavePix("1234");
        cliente.setSaldo(300.0);
        return cliente;
    }

    public Cliente mockClienteBancoCorrent(Integer number) {
        Cliente cliente = new Cliente();
        cliente.setId(number.longValue());
        cliente.setNome("Diego");
        cliente.setSobrenome("Henrique");
        cliente.setEmail("diego@gmail.com");
        cliente.setBanco(banco2);
        cliente.setCpf("123");
        cliente.setSenha("123");
        cliente.setChavePix("123");
        cliente.setSaldo(300.0);
        return cliente;
    }

    public Cliente mockCliente2BancoCorrent(Integer number) {
        Cliente cliente = new Cliente();
        cliente.setId(number.longValue());
        cliente.setNome("Diego");
        cliente.setSobrenome("Henrique");
        cliente.setEmail("diego@gmail.com");
        cliente.setBanco(banco2);
        cliente.setCpf("123");
        cliente.setSenha("123");
        cliente.setChavePix("123");
        cliente.setSaldo(300.0);
        return cliente;
    }

}
