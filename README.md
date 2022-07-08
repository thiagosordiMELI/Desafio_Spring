# Desafio_Spring
API REST desenvolvida pelo grupo Beta Campers para o Desafio Spring durante o IT Bootcamp Backend Java (wave 6). 

## Autores
<a href="https://github.com/vfreitasmeli">
  <img src="https://avatars.githubusercontent.com/u/107959338?s=50&v=4" style="width: 50px">
</a>
<a href="https://github.com/brunavottri">
  <img src="https://avatars.githubusercontent.com/u/108009877?s=120&v=4" style="width: 50px">
</a>
<a href="https://github.com/pealmeida-meli">
  <img src="https://avatars.githubusercontent.com/u/108008922?s=120&v=4" style="width: 50px">
</a>
<a href="https://github.com/thiagosordiMELI">
  <img src="https://avatars.githubusercontent.com/u/108008559?s=120&v=4" style="width: 50px">
</a>
<a href="https://github.com/bdonadel">
  <img src="https://avatars.githubusercontent.com/u/108012641?s=120&v=4" style="width: 50px">
</a>
<a href="https://github.com/felipeticiani-meli">
  <img src="https://avatars.githubusercontent.com/u/108010964?s=120&v=4" style="width: 50px">
</a>

# Sumário

- [Observações](#observações)
- [Funcionalidades](#funcionalidades)
- [Produtos](#produtos)
  - [Post - Adiciona nova lista de produtos](#postProduct)
  - [Put - Atualiza um produto já cadastrado](#putProduct)
  - [Get - Lista todos os produtos disponíveis](#getAllProduct)
  - [Get - Filtra por parâmetro](#getFilters)
- [Clientes](#clientes)
  - [Post - Adiciona um novo cliente](#postCustomer)
  - [Get - Lista todos os clientes](#getCustomers)
  - [Get - Filtra clientes por estado](#getCustomersByState)
- [Compras](#compras)
  - [Post - Adiciona uma solicitação de compra a lista de produtos](#postPurchase)
  - [Get - Lista produtos adicionados ao carrinho](#getCart)
 
# Observações
**ID**<br>
Considerando que não é aconselhável que o cliente defina qual será o ID de um determinado objeto, optamos por gerar o ID dos objetos nos métodos POST. Para isso utilizamos a classe UUID [(java.util.UUID)](https://docs.oracle.com/javase/7/docs/api/java/util/UUID.html), que gera um identificador único universal.<br>
<br>
**Validações**<br>
Utilizamos o [Spring Validation](https://docs.spring.io/spring-framework/docs/4.1.x/spring-framework-reference/html/validation.html#validation-beanvalidation) para os atributos obrigatórios dos objetos, dessa forma a aplicação não aceitará a criação de objetos com informações faltantes.<br>
<br>
**Edição de produtos**<br>
Acrescentamos a rota [update-article-request](#putProduct) que recebe um PUT para atualizar as informações de um determinado produto.<br>
<br>
**Filtros e ordenações**<br>
Criamos a rota [articles](#getFilters) de forma que possa receber diversas combinações de filtros e ordenações definadas nos parâmetros da URL.<br>
<br>
**Solicitações de compras**<br>
Adaptamos para que a [solicitação de compra](#postPurchase) seja enviada apenas com o ID do produto e sua quantidade. As demais informações do produto serão obtidas pelo próprio servidor.

# Funcionalidades

## Produtos

`POST /api/v1/insert-articles-request`<br name="postProduct">
Adiciona uma nova lista de produtos. Devolve uma lista com o resumo dos produtos cadastrados.<br>
<pre><code><b>Payload example:</b>
[
      {
         "name":"Serra de Bancada",
         "category":"Ferramentas",
         "brand":"FORTGPRO",
         "price":1800.00,
         "quantity":5,
         "freeShipping":true,
         "prestige":"****"
      },     
      {
         "name":"Furadeira",
         "category":"Ferramentas",
         "brand":"Black & Decker",
         "price":500.00,
         "quantity":7,
         "freeShipping":true,
         "prestige":"****"
      }
]

<b>Response:</b>
[
    {
        "productId": "3e510112-db30-41dc-969e-95112b1110f0",
        "name": "Serra de Bancada",
        "quantity": 5
    },
    {
        "productId": "ebc1f417-5e27-4e88-b484-8bc7c1685b8e",
        "name": "Furadeira",
        "quantity": 7
    }
]</code></pre>

`PUT /api/v1/update-article-request/4f8da5ec-7dd0-456f-b0a7-1b5e3129ce36`<br name="putProduct">
Atualiza as informações de um produto já cadastrado, enviando como parâmetro o ID do produto e no payload as novas informações do produto. Devolve um objeto com as novas informações básicas do produto.<br>
<pre><code><b>Payload example:</b>
{
    "name":"Serra de Bancada",
    "category":"Ferramentas",
    "brand":"FORTGPRO",
    "price":1900.00,
    "quantity":8,
    "freeShipping":true,
    "prestige":"****"
}

<b>Response:</b>
{
    "productId": "4f8da5ec-7dd0-456f-b0a7-1b5e3129ce36",
    "name": "Serra de Bancada",
    "quantity": 5
}</code></pre>

`GET /api/v1/articles`<br name="getAllProduct">
Lista de todos os produtos disponíveis.
<br>
<pre><code><b>Response:</b>
[
    {
        "productId": "3e510112-db30-41dc-969e-95112b1110f0",
        "name": "Serra de Bancada",
        "quantity": 5
    },
    {
        "productId": "ebc1f417-5e27-4e88-b484-8bc7c1685b8e",
        "name": "Furadeira",
        "quantity": 7
    }
]</code></pre>

Permite também a utilização e diferentes combinações com os seguintes parâmetros no GET:<br name="getFilters">

`GET /api/v1/articles?category=Ferramentas`<br>
Produtos filtrados por categoria.

`GET /api/v1/articles?freeShipping=true`<br>
Produtos com frete grátis.

`GET /api/v1/articles?prestige=*****`<br>
Produtos filtrados por avaliação (* a *****).<br>

`GET /api/v1/articles?order=2`<br>
Devolve uma lista de produtos ordenados.<br>
0: Alfabético crescente.<br>
1: Alfabético descrescente.<br>
2: Preço (maior ao menor).<br>
3: Preço (menor ao maior).<br>

## Clientes

`POST api/v1/customers`<br name="postCustomer">
Adiciona um novo cliente. Devolve um objeto com os dados básicos do cliente.<br>
<pre><code><b>Payload example:</b>
{
  "name": "Pedro",
  "email": "pedro@example.com",
  "city": "Santo Ângelo",
  "state": "RS"
}

<b>Response:</b>
{
    "id": "b93726e6-2e52-4932-a5e6-096e097a0a96",
    "name": "Pedro",
    "email": "pedro@example.com",
    "city": "Santo Ângelo",
    "state": "RS"
}</code></pre>


`GET /api/v1/customers`<br name="getCustomers">
Lista de todos os clientes cadastrados.
<br>
<pre><code><b>Response:</b>
{
    "id": "b93726e6-2e52-4932-a5e6-096e097a0a96",
    "name": "Pedro",
    "email": "pedro@example.com",
    "city": "Santo Ângelo",
    "state": "RS"
}</code></pre>

`GET /api/v1/customers?state=RS`<br name="getCustomersByState">
Clientes filtrados por Estado.

## Compras

`POST /api/v1/purchase-request`<br name="postPurchase">
Adiciona uma nova solicitação de compra para um cliente com uma lista de produtos. Devolve a solicitação com o valor total da compra e o cliente.<br>
<pre><code><b>Payload example:</b>
{
  "customerId": "b93726e6-2e52-4932-a5e6-096e097a0a96",
  "products": [
      {
          "id": "3e510112-db30-41dc-969e-95112b1110f0",
          "quantity":5
      },
      {
          "id":"ebc1f417-5e27-4e88-b484-8bc7c1685b8e",
          "quantity":7
      }
  ]
}

<b>Response:</b>
{
    "id": "b51803ce-f6e7-4b49-84a6-eecfb86afe18",
    "customer": {
        "id": "b93726e6-2e52-4932-a5e6-096e097a0a96",
        "name": "pedro",
        "email": "pedro@example.com",
        "city": "Santo Ângelo",
        "state": "RS"
    },
    "products": [
        {
            "productId": "3e510112-db30-41dc-969e-95112b1110f0",
            "name": "Serra de Bancada",
            "category": "Ferramentas",
            "brand": "FORTGPRO",
            "price": 1800.0,
            "quantity": 5,
            "freeShipping": true,
            "prestige": "****"
        },
        {
            "productId": "ebc1f417-5e27-4e88-b484-8bc7c1685b8e",
            "name": "Furadeira",
            "category": "Ferramentas",
            "brand": "Black & Decker",
            "price": 500.0,
            "quantity": 7,
            "freeShipping": true,
            "prestige": "****"
        }
    ],
    "total": 12500.0
}</code></pre>

`GET api/v1/purchase-request/cart/b93726e6-2e52-4932-a5e6-096e097a0a96`<br name="getCart">
Devolve o valor total dos produtos adicionados no carrinho de compras de um cliente. 
<br>
<pre><code><b>Response:</b>
{
    "total": 9000.0
}
</code></pre>
