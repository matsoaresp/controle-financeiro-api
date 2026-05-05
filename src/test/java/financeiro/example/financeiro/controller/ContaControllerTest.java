package financeiro.example.financeiro.controller;

import financeiro.example.financeiro.dto.RequestContaDto;
import financeiro.example.financeiro.dto.RequestUserDto;
import financeiro.example.financeiro.entity.Conta;
import financeiro.example.financeiro.entity.ContaCorrente;
import financeiro.example.financeiro.repository.ContaRepository;
import financeiro.example.financeiro.service.ContaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ContaControllerTest {

    @Mock
    private ContaRepository repository;

    @InjectMocks
    private ContaService service;



    @Test
    void findOne() {
    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
    }
}