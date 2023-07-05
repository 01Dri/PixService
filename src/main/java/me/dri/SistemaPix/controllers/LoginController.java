package me.dri.SistemaPix.controllers;

import me.dri.SistemaPix.models.dto.ClienteDTO;
import me.dri.SistemaPix.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/loginverification")
@CrossOrigin(origins = "http://localhost:8080")
public class LoginController {

    @Autowired
    ClienteService service;
    @PostMapping
    public ResponseEntity<ClienteDTO> login(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO cliente = service.login(clienteDTO);
        return ResponseEntity.ok().body(cliente);

    }
}
