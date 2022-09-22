package br.com.kako.synchronizecentralbank.controllers;

import br.com.kako.synchronizecentralbank.interfaces.IReceitaService;
import br.com.kako.synchronizecentralbank.interfaces.ISicrediService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class SicrediControllerTest {

    @InjectMocks
    private SicrediController sicrediController;

    @Mock
    private ISicrediService iSicrediServiceMock;


    @BeforeEach
    void setUp() throws InterruptedException, IOException {
        FileWriter fileConta =
                new FileWriter("/home/marcus/pessoal/workspace/Synchronize/src/sharedFilesSents/inputRetaguardaNew.csv");

        BDDMockito.when(iSicrediServiceMock.addContaFile(ArgumentMatchers.any(), ArgumentMatchers.anyString()))
                .thenReturn(fileConta);
    }

    @Test
    void carregarFiles() {

       HttpStatus status =  sicrediController.carregarFiles(null).getStatusCode();

        Assertions.assertThat(status)
                .isNotNull()
                .isEqualTo(HttpStatus.OK);

    }
}