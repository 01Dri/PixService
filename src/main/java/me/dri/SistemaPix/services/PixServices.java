package me.dri.SistemaPix.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dri.SistemaPix.enums.TiposConta;
import me.dri.SistemaPix.exception.KeyPixInvalid;
import me.dri.SistemaPix.exception.NotLimitException;
import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.repositories.PixRepository;

@Service
public class PixServices {


    @Autowired
    private PixRepository pixRepository;

    public Cliente pix(Long id, String chave_pix, Double valor) {

        var cliente1 = pixRepository.findById(id).orElse(null);
        var cliente2 = pixRepository.findByChavePix(chave_pix).orElse(null);
        if (cliente2 == null) {
            throw new KeyPixInvalid("Chave pix inválida!");
        }

        double valorInicial = cliente1.getSaldo();
        double valorCliente1 = cliente1.getSaldo() - valor;
        double valorCliente2 = cliente2.getSaldo() + valor;

        if (cliente1.getChavePix().equals(chave_pix)) {
            throw new KeyPixInvalid("Chave pix invalida!");
        }
        cliente1.setSaldo(valorCliente1);
        if (cliente1.getBanco().getTipo() == TiposConta.CORRENTE && cliente1.getSaldo() < -100) {
            cliente1.setSaldo(valorInicial);
            System.out.println(cliente1.getSaldo());
            throw new NotLimitException("Limite excedido!");
        }
        cliente2.setSaldo(valorCliente2);
        if (cliente1.getBanco().getTipo() == TiposConta.POUPANÇA && cliente1.getSaldo() < 0) {
            cliente1.setSaldo(valorInicial);
            System.out.println(cliente1.getSaldo());
            throw new NotLimitException("Saldo insuficiente!");
        }
        pixRepository.saveAll(Arrays.asList(cliente1, cliente2));
        return cliente1;
    
    }
}