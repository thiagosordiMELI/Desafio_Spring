# Desafio_Spring
API REST desenvolvida para o Desafio Spring durante o Bootcamp IT Backend Java. 

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

## Observações

# Funcionalidades

## Produtos
`POST /api/v1/insert-articles-request`<br>
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

`PUT /api/v1/update-article-request/4f8da5ec-7dd0-456f-b0a7-1b5e3129ce36`<br>
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

`GET /api/v1/articles`<br>
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

Permite também a utilização e combinação dos seguintes parâmetros no GET:<br>
`GET /api/v1/articles?category=Ferramentas`<br>
Produtos filtrados por categoria.

`GET /api/v1/articles?freeShipping=true`<br>
Produtos com frete grátis.

`GET /api/v1/articles?prestige=*****`<br>
Produtos filtrados por avaliação (* a *****).<br>

`GET /api/v1/articles/?order=2`<br>
Devolve uma lista de produtos ordenados.<br>
0: Alfabético crescente.<br>
1: Alfabético descrescente.<br>
2: Preço (maior ao menor).<br>
3: Preço (menor ao maior).<br>

## Compras
`POST /api/v1/purchase-request`<br>
Adiciona uma nova solicitação de compra com uma lista de produtos. Devolve a solicitação com o valor total da compra.<br>
<pre><code><b>Payload example:</b>
[
    {
        "id": "3e510112-db30-41dc-969e-95112b1110f0",
        "quantity":5
    },
    {
        "id":"ebc1f417-5e27-4e88-b484-8bc7c1685b8e",
        "quantity":7
    }
]

<b>Response:</b>
{
    "id": "b51803ce-f6e7-4b49-84a6-eecfb86afe18",
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

`GET /api/v1/cart`<br>
Devolve uma lista com os produtos adicionados no carrinho de compras. 
<br>
<pre><code>Response:</b>
</code></pre>

### Clientes
`POST api/v1/customers`<br>
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

`GET /api/v1/articles`<br>
Lista de todos os clientes cadastrados.
<br>
<pre><code>Response:</b>
{
    "id": "b93726e6-2e52-4932-a5e6-096e097a0a96",
    "name": "Pedro",
    "email": "pedro@example.com",
    "city": "Santo Ângelo",
    "state": "RS"
}</code></pre>

`GET /api/v1/customers?state=RS`<br>
Clientes filtrados por Estado.
