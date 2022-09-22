package br.com.kako.synchronizecentralbank.util;

import br.com.kako.synchronizecentralbank.domains.Conta;

import java.util.UUID;

public class ContaCreator {

    public static  Conta createConta() {
        return Conta.builder()
                .contaId(UUID.randomUUID())
                .agencia("0101")
                .conta("12225-6")
                .status("A")
                .saldo(100.00)
                .build();
    }
}
