package me.dri.SistemaPix.controllers;


import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.models.dto.ClienteDTO;
import me.dri.SistemaPix.services.ClienteService;
import me.dri.SistemaPix.services.PixServices;

import me.dri.SistemaPix.utils.ConverterEntity;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private PixServices pixServices;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<ClienteDTO> clientes = service.findAll();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        var cliente = service.findById(id);
        return ResponseEntity.ok().body(cliente);
    }

}
