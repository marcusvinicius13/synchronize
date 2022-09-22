package br.com.kako.synchronizecentralbank.domains;


import lombok.*;

import java.util.UUID;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

    UUID contaId;
    String agencia;
    String conta;
    Double saldo;
    String status;
}
