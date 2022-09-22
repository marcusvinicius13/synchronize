package br.com.kako.synchronizecentralbank.services;

import br.com.kako.synchronizecentralbank.domains.Conta;
import br.com.kako.synchronizecentralbank.interfaces.IReceitaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceitaService implements IReceitaService {

    @Override
    public boolean atualizarConta(Conta conta)
            throws RuntimeException, InterruptedException {

        // Formato agencia: 0000
        if (conta.getAgencia() == null || conta.getAgencia().length() != 4) {
            return false;
        }

        // Formato conta: 000000
        if (conta.getConta() == null ||
                conta.getConta().replace("-","").length() != 6) {
            return false;
        }

        // Tipos de status validos:
        List tipos = new ArrayList();
        tipos.add("A");
        tipos.add("I");
        tipos.add("B");
        tipos.add("P");

        if (conta.getStatus() == null || !tipos.contains(conta.getStatus())) {
            return false;
        }

        // Simula tempo de resposta do serviço (entre 1 e 5 segundos)
        long wait = Math.round(Math.random() * 4000) + 1000;
        Thread.sleep(wait);

        // Simula cenario de erro no serviço (0,1% de erro)
        long randomError = Math.round(Math.random() * 1000);
        if (randomError == 500) {
            throw new RuntimeException("Error");
        }

        return true;
    }
}
