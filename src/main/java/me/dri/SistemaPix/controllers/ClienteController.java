package me.dri.SistemaPix.controllers;


import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.services.ClienteService;
import me.dri.SistemaPix.services.PixServices;

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
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = service.findALl();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable Long id) {
        var cliente = service.findById(id);
        return ResponseEntity.ok().body(cliente);
    }
    @GetMapping(value = "/pix/{id}/{chave_pix}")
    public ResponseEntity<Cliente> pix(@PathVariable Long id, @PathVariable String chave_pix,  @RequestParam("pix") Double valor) {
        var cliente2 = pixServices.pix(id, chave_pix, valor);
        return ResponseEntity.ok().body(cliente2);
    }


}
