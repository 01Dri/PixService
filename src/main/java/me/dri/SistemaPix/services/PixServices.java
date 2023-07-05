package me.dri.SistemaPix.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.transaction.Transactional;
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

    public ClienteDTO pix(Long idRemetente, String chavePix, Double valor) {

        var remetente = clienteRepository.findById(idRemetente).orElseThrow(() -> new ResourceNotFound("Usuario não existe!"));
        var destinatario = clienteRepository.findByChavePix(chavePix).orElseThrow(() -> new ResourceNotFound("Usuario não existe!"));
        return ConverterEntity.convertyEntityToDTO2(transacao(remetente, destinatario, valor));

    }


    @Transactional
    public Cliente transacao(Cliente remetente, Cliente destinario, Double valorPixTransacao) {

        var clienteRemetente = clienteRepository.findById(remetente.getId()).orElseThrow(() -> new ResourceNotFound("Usuario não existe"));
        var clienteDestinario = clienteRepository.findByChavePix(destinario.getChavePix()).orElseThrow(() -> new ResourceNotFound("Usuario não existe"));

        clienteRemetente.transacao(valorPixTransacao);
        clienteDestinario.recebimento(valorPixTransacao);
        clienteRepository.saveAll(Arrays.asList(clienteRemetente, clienteDestinario));
        return clienteRemetente;

    }
}