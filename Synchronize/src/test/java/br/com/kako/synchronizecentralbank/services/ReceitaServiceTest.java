package br.com.kako.synchronizecentralbank.services;

import br.com.kako.synchronizecentralbank.controllers.ReceitaController;
import br.com.kako.synchronizecentralbank.domains.Conta;
import br.com.kako.synchronizecentralbank.interfaces.IReceitaService;
import br.com.kako.synchronizecentralbank.util.ContaCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ReceitaServiceTest {


    @InjectMocks
    private ReceitaService receitaService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void atualizarConta() throws InterruptedException {
        Conta conta = ContaCreator.createConta();
        String agencia = conta.getAgencia();
        String numeroConta = conta.getConta();
        String status = conta.getStatus();
        Double saldo = conta.getSaldo();

        boolean retorno = receitaService.atualizarConta(ContaCreator.createConta());

        Assertions
                .assertThat(retorno).isTrue();
        Assertions
                .assertThat(agencia).isNotNull();
        Assertions
                .assertThat(agencia.length() == 4).isTrue();

        Assertions
                .assertThat(numeroConta).isNotNull();
        Assertions
                .assertThat(numeroConta.replace("-", "").length() == 6).isTrue();

        Assertions
                .assertThat(status).isNotNull();
        Assertions
                .assertThat(status).isEqualTo("A");

        Assertions
                .assertThat(saldo).isNotNull();
    }
}