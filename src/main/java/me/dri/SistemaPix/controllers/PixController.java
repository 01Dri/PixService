package me.dri.SistemaPix.controllers;

import me.dri.SistemaPix.models.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import me.dri.SistemaPix.services.PixServices;

@RestController
@RequestMapping(value = "/pix")
public class PixController {


    @Autowired
    private PixServices pixServices;

    @PostMapping("/{idRemetente}/{chavePix}/{valor}")
    public ResponseEntity<ClienteDTO> pix(@PathVariable Long idRemetente, @PathVariable String chavePix, @PathVariable Double valor) {
        var remetenteCliente = pixServices.pix(idRemetente, chavePix, valor);
        return ResponseEntity.ok().body(remetenteCliente);
    }
}
