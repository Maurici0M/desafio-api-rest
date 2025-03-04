<h1 align='center'>Desafio API REST:</h1>

--------------------------------------------------

<h3>Objetivos:</h3>

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

* Criar um método que adiciona novos pedidos (lembrando que cada pedido pode ter um ou vários ítens inclusos) <b>(POST)</b>; ✅
* Listar TODOS os pedidos realizados pelo cliente <b>(GET)</b>; ✅
* Listar pedidos específicos através do ID da compra <b>(GET por ID)</b>; ✅
* Permitir que os ítens dos pedidos possam ser atualizados mesmo após eles terem sido concluídos <b>(PUT)</b>; 🕒
* Excluir todos os pedidos realizados <b>(DELETE)</b>; 🕒
* Excluir pedidos específicos através do ID da compra <b>(DELETE por ID)</b>; 🕒
 </details>

--------------------------------------------------
<details>
  <summary> <b>5 - Subir o projeto no GitHub! ✅</b> </summary>
  <br>

* Deixar o projeto com visibilidade pública e ir comitando as alterações! ✅
</details>

--------------------------------------------------

 <h1 align='center'>Anotações:</h1>

<details>
  <summary> <b>Legenda dos ícones:</b> </summary>
 
* ✅ -> Finalizado
* 👨‍💻 -> Em progresso
* 🕒 -> Não iniciado
 </details>

<br>

<details>
  <summary> <b>Informações do projeto:</b> </summary>

<br>

  <details> 
    <summary> <b>Acesso as tabelas: 🛢️</b> </summary>

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

--------------------------------------------------

  <details> 
    <summary> <b>Cadastrando clientes: 👥</b> </summary>

Para cadastramos um cliente em nossa aplicação, temos o seguinte modelo de JSON para ser lançado:

  <br>

    POST -> http://localhost:8080/comprador

    {
    	"nome" : "Ada",
    	"sobrenome" : "Wong",
    	"idade" : "28"
    }

Esse modelo acima, adiciona os clientes de forma unitária (um por vez), mas, caso queira cadastrar vários compradores, pode ser utilizado esse modelo de JSON:

    [
        {
            "nome" : "Heather",
            "sobrenome" : "Mason",
            "idade" : "20"
        },
        {
            "nome" : "Leon",
            "sobrenome" : "Scott Kennedy",
            "idade" : "30"
        },
        {
            "nome" : "Ada",
            "sobrenome" : "Wong",
            "idade" : "28"
        }
    ]

  </details>

--------------------------------------------------

   <details> 
    <summary> <b>Listando TODOS os clientes cadastrados: 📋</b> </summary>
    <br>

Para verificarmos todos os clientes cadastrados na nossa aplicação, utilize o comando abaixo:
<br>

    GET -> http://localhost:8080/comprador/listar/compradores

Essa listagem dos compradores adicionados, pode também ser realizadas por consultas diretas na nossa tabela, com o seguinte comando:

    SELECT * FROM comprador

Mapa de verbos para as requisições de cadastrar comprador:

![img.png](src/images/mapa-verbos-cadastro-comprador.png)

  </details>

  </details>

<details>
<summary><b>Criando um pedido:</b></summary>

Para criar um pedido, é importante que já tenhamos no mínimo um comprador cadastrado, para conseguir atrelá-lo a compra. <b>No início de nosso JSON, temos "comprador" {id}, nesse id, deve ser adicionado o número de id do cliente que queremos atrelar ao pedido, nesse exemplo, será o cliente de id = 2</b>.

    {
        "comprador": {
        "id": 2
        },
        "listaDeItens": [
            {
                "descricao": "Figuras Studios Ghibli Hauru, Totoro, Catbus e Outros",
                "valor": 189.90
            },
            {
                "descricao": "DVD Anime Violet Evergarden 1ª Temporada",
                "valor": 29.90
            },
            {
                "descricao": "Blu-ray Túmulo dos Vaga-lumes - Filme Ghibli 1988 em alta definição.",
                "valor": 29.90
            }
        ]
    }


</details>

<details>
<summary>Atualizando um ítem do pedido: </summary>

Para atualizar um ítem do pedido, usamos o PUT, e ele editará a descrição e/ou valor de um dos nossos ítens declarados.

Em exemplo, no tópico "Criando um pedido" temos um JSON com 3 ítens adquiridos pelo comprador de id 1.

Vamos supor que eu queira editar o terceiro ítem que tem os seguintes dados:

    {
        "descricao": "Blu-ray Túmulo dos Vaga-lumes - Filme Ghibli 1988 em alta definição.",
        "valor": 29.90
    }

Por este aqui:

    {
        "descricao": "DVD Blu-ray Crianças Lobo (Wolf Children) - Preço promocional!",
        "valor": 20.90
    }
    
Para isso, precisaríamos de 2 informações:

* <b>'ID' do PEDIDO</b>
* <b>'ID' do ÍTEM</b>

Vamos pressupor que o 'ID' do PEDIDO seja = 1 e o 'ID' do ÍTEM que desejamos alterar, seja = 3. Nessas condições, a nossa requisição ficaria assim:

    PUT -> http://localhost:8080/pedidos/1/itens/3

E o nosso JSON seria o mesmo que vimos acima, contendo os novos dados:
    
    {
        "descricao": "DVD Blu-ray Crianças Lobo (Wolf Children) - Preço promocional!",
        "valor": 20.90
    }

Dessa forma, os outros ítens do nosso pedido ficariam intactos, e somente um em específico seria alterado.

</details>

 </details>

<!-- ![Loading](https://media.giphy.com/media/xTkcEQACH24SMPxIQg/giphy.gif) -->
