package br.com.kako.synchronizecentralbank.interfaces;

import br.com.kako.synchronizecentralbank.domains.Conta;

import java.io.FileWriter;
import java.util.List;


public interface ISicrediService {

    public List<Conta> carregarContas(String nameFile);

    public FileWriter addContaFile(Conta conta, String nameFile);
}
