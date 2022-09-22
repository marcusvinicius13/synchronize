package br.com.kako.synchronizecentralbank.controllers;

import br.com.kako.synchronizecentralbank.interfaces.IReceitaService;
import br.com.kako.synchronizecentralbank.interfaces.ISicrediService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.FileWriter;
import java.io.IOException;

@ExtendWith(SpringExtension.class)
class ReceitaControllerTest {

    @InjectMocks
    private ReceitaController receitaController;

    @Mock
    private IReceitaService iReceitaServiceMock;

    @Mock
    private ISicrediService iSicrediServiceMock;

    @BeforeEach
    void setUp() throws InterruptedException, IOException {
        BDDMockito.when(iReceitaServiceMock.atualizarConta(ArgumentMatchers.any()))
                .thenReturn(true);
    }

    @Test
    @DisplayName("Atualizar conta")
    void atualizarConta() throws InterruptedException, IOException {
        FileWriter fileConta =
                new FileWriter("/home/marcus/pessoal/workspace/Synchronize/src/sharedFilesSents/inputRetaguardaNew.csv");

        BDDMockito.when(iSicrediServiceMock.addContaFile(ArgumentMatchers.any(), ArgumentMatchers.anyString()))
                .thenReturn(fileConta);

        receitaController.atualizarConta(null, null).getBody();

        Assertions.assertThat(fileConta).isNotNull();
        Assertions.assertThat(fileConta).isInstanceOf(FileWriter.class);
    }
}