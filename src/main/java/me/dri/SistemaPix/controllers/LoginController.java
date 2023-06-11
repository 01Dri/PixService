package me.dri.SistemaPix.controllers;

import ch.qos.logback.core.net.server.Client;
import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.models.dto.ClienteDTO;
import me.dri.SistemaPix.services.ClienteService;
import me.dri.SistemaPix.utils.ConverterEntity;
import org.apache.coyote.Response;
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
    public ResponseEntity<ClienteDTO> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String senha = loginData.get("senha");
        Cliente cliente = service.login(email, senha);
        ClienteDTO clienteDTO = ConverterEntity.convertyEntityToDTO(cliente);
        return ResponseEntity.ok().body(clienteDTO);

    }
}
