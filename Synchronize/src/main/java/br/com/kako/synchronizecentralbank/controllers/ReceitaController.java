package br.com.kako.synchronizecentralbank.controllers;

import br.com.kako.synchronizecentralbank.domains.Conta;
import br.com.kako.synchronizecentralbank.interfaces.IReceitaService;
import br.com.kako.synchronizecentralbank.interfaces.ISicrediService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;

@Slf4j
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(value = "/api/kako/", produces = {"application/json"})
public class ReceitaController {

    private final IReceitaService iReceitaService;
    private final ISicrediService iSicrediService;

    @PutMapping("updatedConta")
    public ResponseEntity<FileWriter> atualizarConta(
            @RequestBody Conta conta,
            @RequestParam("nameFile") String nameFile) throws InterruptedException {

        boolean valid = iReceitaService.atualizarConta(conta);
        FileWriter file = null;
        if(valid){
            file = iSicrediService.addContaFile(conta, nameFile);
        }

        return new ResponseEntity<>(file, HttpStatus.OK);
    }
}
