package me.dri.SistemaPix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.services.PixServices;

@RestController
@RequestMapping(value = "/pix")
public class PixController {


    @Autowired
    private PixServices pixServices;

    @GetMapping(value = "/{id}/{chave_pix}")
    public ResponseEntity<Cliente> pix(@PathVariable Long id, @PathVariable String chave_pix,  @RequestParam("pix") Double valor) {
        var cliente2 = pixServices.pix(id, chave_pix,valor);
        return ResponseEntity.ok().body(cliente2);
    }
}
