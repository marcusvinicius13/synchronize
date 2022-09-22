package br.com.kako.synchronizecentralbank.controllers;

import br.com.kako.synchronizecentralbank.interfaces.ISicrediService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(value = "/api/kako/", produces = {"application/json"})
public class SicrediController {

    private final ISicrediService iSicrediService;

    @GetMapping("carregarFiles")
    public ResponseEntity<String>  carregarFiles(@RequestParam("nameFile") String nameFile) {
        iSicrediService.carregarContas(nameFile);
        return new ResponseEntity<>("{ \"message\": \" Arquivo carregado com sucesso!!!\" }", HttpStatus.OK);
    }

}
