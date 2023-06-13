package me.dri.SistemaPix.mockito.tests;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import me.dri.SistemaPix.mocks.MockCliente;
import me.dri.SistemaPix.models.Cliente;
import me.dri.SistemaPix.repositories.ClienteRepository;
import me.dri.SistemaPix.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class ClientesServiceTest {

    @InjectMocks
    ClienteService service;

    @Mock
    ClienteRepository repository;

    MockCliente mockCliente = new MockCliente();


    @BeforeEach
    public void setup() {
    }


}
