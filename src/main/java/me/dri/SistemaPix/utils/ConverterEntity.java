package me.dri.SistemaPix.utils;

import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.models.dto.ClienteDTO;

import java.util.List;

public class ConverterEntity {


    public static ClienteDTO convertyEntityToDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setSaldo(cliente.getSaldo());
        clienteDTO.setBanco(cliente.getBanco());
        return clienteDTO;
    }

    public static List<ClienteDTO> convertyListToDTO(List<Cliente> clientes) {
        List<ClienteDTO> clienteDTOList = clientes.stream().map(ConverterEntity::convertyEntityToDTO).toList();
        return clienteDTOList;
    }
}
