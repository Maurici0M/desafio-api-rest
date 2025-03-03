<h1 align='center'>Desafio API REST:</h1>

--------------------------------------------------

<details>
  <summary> <b>1 - Clonar o repositório: ✅ </b> </summary>
  <br>
  Através desse repositório, faça as próximas etapas do desafio: 
  
  * https://github.com/guimendes92/cardinalidade
  
</details>

--------------------------------------------------

<details>
  <summary> <b>2 - Povoar o projeto com dados de clientes para conseguir fazer as requisições; ✅</b> </summary>
  <br>
 
  * Já existe o método para criar clientes, basta criar uma requisição com os parâmetros necessários para preencher os campor da tabela; 
</details>

--------------------------------------------------

<details>
  <summary> <b>3 - Utilizar o código para promover a adição de um método que fará a busca única de clientes através do parâmetro ID; ✅</b> </summary>
  <br>
 
  * Atualmente é possível verificar as pessoas cadastradas, porém, isso gera um json com a lista de TODOS os compradores, o objetivo é buscar um comprador específico através de sua identificação única ID;
</details>

--------------------------------------------------

<details>
  <summary> <b>4 - Criar métodos que utilizem dos verbos GET, POST, PUT e DELETE para ler, criar, editar e excluir pedidos realizados pelos clientes; 👨‍💻</b> </summary>
  <br>

 Esse método precisa:

* criar novos pedidos; ✅
* listar TODOS os pedidos realizados pelo cliente; ✅
* listar pedidos específicos através do ID da compra; ✅
* atualizar pedidos; 🕒
* deletar todos os pedidos; 🕒
* deletar pedidos específicos através do ID da compra; 🕒
 </details>

--------------------------------------------------

5 - Subir o projeto no GitHub! ✅

--------------------------------------------------

<details>
  <summary> <b>Legenda dos ícones:</b> </summary>
  <br>
  
  * ✅ -> Finalizado
  * 👨‍💻 -> Em progresso
  * 🕒 -> Não iniciado
 </details>
 
 --------------------------------------------------

 <h1 align='center'>Anotações:</h1>

<details>
  <summary> <b>Informações do projeto:</b> </summary>
  
--------------------------------------------------
  
  <details> 
    <summary> <b>Acesso as tabelas:</b> </summary>
    
  <br>
  Para acessar as tabelas do projeto, após iniciá-lo, acesse o link abaixo e clique em connect:
  
  <br>
    
    http://localhost:8080/h2-console/login.jsp?jsessionid=ed19cebe9f228d63816f9185f0931375

  Isso é necessário porque o projeto foi desenvolvido de forma simples, com o objetivo de ser iniciado facilmente, sem a necessidade de uma estrutura MySQL local na máquina do usuário.
    </details>

  --------------------------------------------------

  <details> 
    <summary> <b>Povoando as tabelas para realizar os testes: 📊</b> </summary>
    <br>
    Para testar os métodos disponíveis na aplicação, primeiro, é preciso adicionar dados a ela. Esses dados são referentes ao cadastro de clientes e criação de um pedido, e para fazermos as requisições de        criação de pedidos e cadastramento de compradores, por exemplo, aconselho que seja utilizado o Insomnia ou Postman, mas, tranquilarmente é possível utilizar outras ferramentas disponíveis! :) 
  
  <br>
  <br>

--------------------------------------------------
  
  <details> 
    <summary> <b>Cadastrando clientes: 👥</b> </summary>
    
  <br>
    
   Para cadastramos um cliente em nossa aplicação, temos o seguinte modelo de JSON para ser lançado:
    
  <br>

    POST -> http://localhost:8080/comprador

    {
    	"nome" : "Ada",
    	"sobrenome" : "Wong",
    	"idade" : "28"
    }
    
  </details>

--------------------------------------------------
   
   <details> 
    <summary> <b>Listando TODOS os clientes cadastrados: 📋</b> </summary>
    <br>
    
   Para verificarmos todos os clientes cadastrados em nossa aplicação, utilize o comando abaixo:
    <br>

    GET -> http://localhost:8080/comprador/listar/compradores

  Essa listagem dos compradores adicionados, podem também ser realizadas através de consultas diretas em nossa tabela, com o seguinte comando:

    SELECT * FROM comprador
    
  </details>

  </details>
 
 </details>








<!-- ![Loading](https://media.giphy.com/media/xTkcEQACH24SMPxIQg/giphy.gif) -->
