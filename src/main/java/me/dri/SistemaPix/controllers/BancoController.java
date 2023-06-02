package me.dri.SistemaPix.controllers;

import me.dri.SistemaPix.models.Banco;
import me.dri.SistemaPix.services.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bancos")
public class BancoController {
    @Autowired
    private BancoService service;


    @GetMapping
    public ResponseEntity<List<Banco>> findAll() {
        List<Banco> clientes = service.findALl();
        return ResponseEntity.ok().body(clientes);
    }



}
