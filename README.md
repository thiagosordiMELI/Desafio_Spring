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

# Funcionalidades

## Produtos
`POST /api/v1/articles`<br>
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

`GET /api/v1/articles?category=categoryName`<br>
Lista de produtos filtrados por categoria.

`GET /api/v1/articles?category=categoryName&freeShipping=true`<br>
Lista com filtro de produtos por categoria com frete grátis.

`GET /api/v1/articles?freeShipping=true&prestige=prestige`<br>
Lista com filtro de produtos com frete grátis e filtro por avaliação.

`GET /api/v1/articles/?order=orderBy`<br>
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
