# EstufaRESTful
Aprimoramento do projeto de API para estufa automatizada, com ênfase no modelo RESTful para teste requisições HTTP, Listas, Arrays e armazenamento em Banco de Dados. 

## Pré-requisitos:
  - Java 17 deve estar instalado no dispositivo de teste. 
  - Antes de iniciar o programa, certifique-se de ter previamente criado a database com o nome "estufa_db".
  - Para utilizar o sistema, precisará de alguma ferramenta dedicada à teste de requisições para APIs RESTful. Para este projeto, é indicado o Postman.
  - Inicializar o .jar da API (localizado dentro do diretório "/Target" do projeto) com o seguinte comando:
    ```bash
    java -jar estufarestful.jar

## Instruções:
  - As requisições devem ser realizadas através de uma ferramente de testes de API, seguindo os seguintes formatos:
  - POST: http://localhost:8080/api/estufa/registrar?temperatura=39&hora=7
  - GET (Registros): http://localhost:8080/api/estufa/registros
  - GET (Relatório): http://localhost:8080/api/estufa/relatorio
