package br.com.kako.synchronizecentralbank.interfaces;

import br.com.kako.synchronizecentralbank.domains.Conta;

public interface IReceitaService {

    public boolean atualizarConta(Conta conta) throws RuntimeException, InterruptedException;
}
