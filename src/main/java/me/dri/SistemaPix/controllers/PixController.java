package me.dri.SistemaPix.controllers;

import me.dri.SistemaPix.models.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.services.PixServices;

@RestController
@RequestMapping(value = "/pix")
public class PixController {


    @Autowired
    private PixServices pixServices;

    @PostMapping(value = "/{id}/{chave_pix}")
    public ResponseEntity<ClienteDTO> pix(@PathVariable Long id, @PathVariable String chave_pix, @RequestParam("pix") Double valor) {
        var cliente2 = pixServices.pix(id, chave_pix,valor);
        return ResponseEntity.ok().body(cliente2);
    }
}
