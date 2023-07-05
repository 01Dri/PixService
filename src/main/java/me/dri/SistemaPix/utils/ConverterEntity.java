package me.dri.SistemaPix.utils;

import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.models.dto.ClienteDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ConverterEntity {



    public static ClienteDTO convertyEntityToDTO2(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getSobrenome(),
                cliente.getEmail(),
                cliente.getCpf(),
                cliente.getSenha(),
                cliente.getChavePix(),
                cliente.getSaldo());
        return clienteDTO;
    }

    public static List<ClienteDTO> convertityListToDTO2(List<Cliente> clienteList) {
        return clienteList.stream().map(cliente -> new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getSobrenome(),
                cliente.getEmail(),
                cliente.getCpf(),
                cliente.getSenha(),
                cliente.getChavePix(),
                cliente.getSaldo())
        ).collect(Collectors.toList());
    }

}
