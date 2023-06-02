package me.dri.SistemaPix.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.repositories.PixRepository;

@Service
public class PixServices {


    @Autowired
    private PixRepository pixRepository;

    public Cliente pix(Long id, String chave_pix, Double valor) {

        var cliente1 = pixRepository.findById(id).orElse(null);
        var cliente2 = pixRepository.findByChavePix(chave_pix).orElse(null);
        System.out.println(cliente2.getNome());


        if (cliente1.getSaldo() < valor) {

            // criar uma exceção!
            System.out.println("ERRO");
        }
      
        double valorCliente1 = cliente1.getSaldo() - valor;
        double valorCliente2 = cliente2.getSaldo() + valor;

        cliente1.setSaldo(valorCliente1);
        cliente2.setSaldo(valorCliente2);

        pixRepository.saveAll(Arrays.asList(cliente1, cliente2));

        return cliente1;
    
    }
}