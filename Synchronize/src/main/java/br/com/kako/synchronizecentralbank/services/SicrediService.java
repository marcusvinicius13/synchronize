package br.com.kako.synchronizecentralbank.services;

import br.com.kako.synchronizecentralbank.domains.Conta;
import br.com.kako.synchronizecentralbank.interfaces.ISicrediService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SicrediService implements ISicrediService {

    private final Environment env;

    private List<Conta> contaList = new ArrayList<>();

    @Override
    public List<Conta> carregarContas(String nameFile) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(env.getProperty("app.path.files") + nameFile))){
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            while(line != null) {
                String[] vect = line.split(";");
                this.contaList.add(extrairConta(vect));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.contaList;
    }

    @Override
    public FileWriter addContaFile(Conta conta, String nameFile) {
        try {
            FileWriter fileConta = new FileWriter(env.getProperty("app.path.filesSents") + nameFile);
            PrintWriter createdFile = new PrintWriter(fileConta);

            List<Conta> contasList = carregarContas("inputRetaguarda.csv");
            conta.setContaId(UUID.randomUUID());
            contasList.add(conta);

            createdFile.append("id; agencia; conta; saldo; status" + "\n");
            contasList.stream().forEach(contaFile -> {
                createdFile.append(
                        contaFile.getContaId() + ";"
                        + contaFile.getAgencia() + ";"
                        + contaFile.getConta() + ";"
                        + contaFile.getSaldo() + ";"
                        + contaFile.getStatus()
                        + "\n");
            });

            createdFile.close();
//            FileWriter file = new FileWriter(env.getProperty("app.path.filesSents") + nameFile);

            return fileConta;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Conta extrairConta(String[] vect) {
        Conta conta = new Conta();
        conta.setContaId(UUID.randomUUID());
        conta.setAgencia(vect[0]);
        conta.setConta(vect[1]);
        conta.setSaldo(Double.parseDouble(vect[2]));
        conta.setStatus(vect[3]);

        return conta;
    }
}
