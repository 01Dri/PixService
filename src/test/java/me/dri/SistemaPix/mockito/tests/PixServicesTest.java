package me.dri.SistemaPix.mockito.tests;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import me.dri.SistemaPix.exception.NotLimitException;
import me.dri.SistemaPix.mocks.MockCliente;
import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.repositories.ClienteRepository;
import me.dri.SistemaPix.services.ClienteService;
import me.dri.SistemaPix.services.PixServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PixServicesTest {

    MockCliente input;

    @InjectMocks
    private ClienteService service;

    @InjectMocks
    private PixServices pixServices;

    @Mock
    ClienteRepository repository;




    @BeforeEach
    void setupMocks() throws Exception {
        input = new MockCliente();
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testandoExcecaoNotLimitExceptionContaPoupanca() {
        Long id = 1L;
        String chave__pix = "1234";
        Cliente clienteRemetente = input.mockClienteRemetenteBancoPoupanca(1);
        Cliente clienteDestinatario = input.mockClienteDestinatarioBancoPoupanca(2);
        when(repository.findById(id)).thenReturn(Optional.of(clienteRemetente));
        when(repository.findByChavePix(chave__pix)).thenReturn(Optional.of(clienteDestinatario));

        try {
            var result = pixServices.pix(id, chave__pix, 400.0);
            fail("Esperava-se a exceção NotLimitException");
        } catch (NotLimitException e) {
            assertEquals("Você não tem saldo suficiente!", e.getMessage());
        }
    }

    @Test
    void testandoExcecaoNotLimitExceptionContaCorrent() {
        Long id = 1L;
        String chave__pix = "1234";
        Cliente clienteRemetente = input.mockClienteRemetenteBancoCorrent(1);
        Cliente clienteDestinatario = input.mockClienteDestinatarioBancoCorrent(2);
        when(repository.findById(id)).thenReturn(Optional.of(clienteRemetente));
        when(repository.findByChavePix(chave__pix)).thenReturn(Optional.of(clienteDestinatario));

        try {
            var result = pixServices.pix(id , chave__pix, 801.0);
            fail("Esperava-se a exceção NotLimitException");
        } catch (NotLimitException e) {
            assertEquals("Limite excedido!", e.getMessage());
        }
    }

    @Test
    void testandoTransacaoCompletaPixPoupanca() {
        Long id = 1L;
        String chave__pix = "1234";
        Cliente clienteRemetente = input.mockClienteRemetenteBancoPoupanca(1);
        Cliente clienteDestinatario = input.mockClienteDestinatarioBancoPoupanca(2);
        when(repository.findById(id)).thenReturn(Optional.of(clienteRemetente));
        when(repository.findByChavePix(chave__pix)).thenReturn(Optional.of(clienteDestinatario));

        var result = pixServices.pix(id, chave__pix, 300.0);
        assertEquals(Optional.of(clienteRemetente.getSaldo()), Optional.of(0.0));
        assertEquals(Optional.of(clienteDestinatario.getSaldo()), Optional.of(600.0));
    }

    @Test
    void testandoTransacaoCompletaPixCorrent() {
        Long id = 1L;
        String chave__pix = "1234";
        Cliente clienteRemetente = input.mockClienteRemetenteBancoCorrent(1);
        Cliente clienteDestinatario = input.mockClienteDestinatarioBancoCorrent(2);
        when(repository.findById(id)).thenReturn(Optional.of(clienteRemetente));
        when(repository.findByChavePix(chave__pix)).thenReturn(Optional.of(clienteDestinatario));

        var result = pixServices.pix(id, chave__pix, 800.0);
        assertEquals(Optional.of(clienteRemetente.getSaldo()), Optional.of(-500.0));
        assertEquals(Optional.of(clienteDestinatario.getSaldo()), Optional.of(1100.0));
    }
}
