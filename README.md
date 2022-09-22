# Aplicação proposta
Automatizar o trabalho de um funcionário da retaguarda do Sicredi

* Requisito: Usar o "serviço da receita" (fake) para processamento automático do arquivo.

### Funcionalidade:

* [X] Criar uma aplicação SprintBoot standalone. Exemplo: java -jar SincronizacaoReceita <input-file>
* [X] Processa um arquivo CSV de entrada com o formato abaixo. 
* [X] Envia a atualização para a Receita através do serviço (SIMULADO pela classe ReceitaService). 
* [X] Retorna um arquivo com o resultado do envio da atualização da Receita. Mesmo formato adicionando o resultado em uma nova coluna.


### Github
* [Github](https://github.com/marcusvinicius13)

### Linkdin

* [Linkedin](https://www.linkedin.com/in/kako-marcus-vinicius/)


#   Testando a aplicação 

-     Temos algumas formas de testar essa aplicação uma das formas é 
      Startando de forma simples com a própria IDE, acessando com um insominia ou postman, etc...
      as uris abaixo descritas, com os parâmetros informados.

-     Uma outra forma é com os testes unitários, criados para essa aplicação.

-     Outra forma é com o Sweger criado para essa aplicação. 

* URI para testes :
-     Atualizar conta  
      PUT - (http://localhost:8080/api/kako/updatedConta?nameFile=inputRetaguardaNew.csv)
      {
          "agencia": "0102",
          "conta": "12228-9",
          "status": "A",
          "saldo": 200.00
      }

-     Carregar Arquivo
      GET - (http://localhost:8080/api/kako/carregarFiles?nameFile=inputRetaguarda.csv)

#     Estrutura do projeto

-     Pasta src, é o root da aplicação.
-     Pasta main, onde fica o código da aplicação
         java - onde fica o código fonte da aplicação.
         resource - onde fica as configurações da aplicação.

-     Pasta sharedfiles, onde fica o arquivo que é lido pelo programa.
-     Pasta sharedFilesSents, onde fica o arquivo após o retorno da receita.


#     Acessando com o Swagger

-     Estarta a aplicação e acessa o link
*    [Swagger](http://localhost:8080/swagger-ui/index.html#/receita-controller/atualizarConta)

     Para fazer uma requisição coloque preencha os parabetros 
-    Query param : inputRetaguardaNew.csv
-    Body param  :
-     {
          "agencia": "0102",
          "conta": "12228-9",
          "status": "A",
          "saldo": 200.00
      }
