package me.dri.SistemaPix.services;

import java.util.ArrayList;
import java.util.List;

import me.dri.SistemaPix.exception.ResourceNotFound;
import me.dri.SistemaPix.models.dto.ClienteDTO;
import me.dri.SistemaPix.repositories.ClienteRepository;
import me.dri.SistemaPix.utils.ConverterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dri.SistemaPix.enums.TiposConta;
import me.dri.SistemaPix.exception.NotLimitException;
import me.dri.SistemaPix.models.Cliente;

@Service
public class PixServices {


    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO pix(Long id, String chave_pix, Double valor) {

        var cliente1 = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Usuario não existe!"));
        var cliente2 = clienteRepository.findByChavePix(chave_pix).orElseThrow(() -> new ResourceNotFound("Usuario não existe!"));
        clienteRepository.saveAll(transacao(cliente1, cliente2, valor));
        return ConverterEntity.convertyEntityToDTO(cliente1);

    }

    public List<Cliente> transacao(Cliente clienteDTO, Cliente clienteDTO2, Double saldo) {
        List<Cliente> clientes = new ArrayList<>();
        var saldoInicialCliente1 = clienteDTO.getSaldo();
        var saldoInicialCliente2 = clienteDTO2.getSaldo();
        clienteDTO.setSaldo(clienteDTO.getSaldo() - saldo);
        clienteDTO2.setSaldo(clienteDTO2.getSaldo() + saldo);

        if (clienteDTO.getBanco().getTipo() == TiposConta.POUPANÇA && clienteDTO.getSaldo() < 0) {
            clienteDTO.setSaldo(saldoInicialCliente1);
            clienteDTO2.setSaldo(saldoInicialCliente2);
            throw new NotLimitException("Você não tem saldo suficiente!");
        }

        if (clienteDTO.getBanco().getTipo() == TiposConta.CORRENTE && clienteDTO.getSaldo() < -500) {
            clienteDTO.setSaldo(saldoInicialCliente1);
            clienteDTO2.setSaldo(saldoInicialCliente2);
            throw new NotLimitException("Limite excedido!");
        }

        clientes.add(clienteDTO);
        clientes.add(clienteDTO2);
        return clientes;
    }
}