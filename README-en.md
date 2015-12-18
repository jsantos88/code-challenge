# VivaReal Code Challenge :)

If you prefer, you can read our [english version]().

## Propósito deste desafio

Este desafio tem o intuito de entender a forma como você pensa para resolver os problemas, como você organiza seu código e quais tecnologias você se sente mais confortável.

## Desafio

Dependendo da sua experiência e/ou das ferramentas escolhidas, você pode precisar de mais ou menos tempo para realizar o desafio. Em geral 2 horas são suficientes.

O desafio consiste em criar uma pequena réplica do VivaReal com algumas pequenas funcionalidades. 

Para isso, vamos fornecer para você alguns dados. Neste [json](database.json) você encontra uma série de imóveis listados com a seguinte estrutura:

```
    {
        "id": "56060020",
        "listable": "PropertyListing",
        "idExterno": "20157",
        "nombreCuenta": "Ivan Negócios Imobiliários (Vendas)",
        "rolCuenta": "INMOBILIARIA",
        "cuenta": "69268",
        "uso": "RESIDENCIAL",
        "tipo": "HOME",
        "negocio": "VENTA",
        "tipoPublicacion": "STANDARD",
        "precioVenta": 1100000,
        "moneda": "BRL",
        "banos": 0.0,
        "habitaciones": 0.0,
        "garajes": 0,
        "precioVentaBase": 1100000.0,
        "adm1": "BR>Minas Gerais",
        "nombreAdm1Pt": "Minas Gerais",
        "urlAdm1Pt": "minas-gerais",
        "ppl": "BR>Minas Gerais>NULL>Uberlandia",
        "nombrePplPt": "Uberlândia",
        "urlPplPt": "uberlandia",
        "zna": "BR>Minas Gerais>NULL>Uberlandia>Barrios",
        "urlZnaPt": "bairros",
        "nbh": "BR>Minas Gerais>NULL>Uberlandia>Barrios>Novo Mundo",
        "nombreNbhPt": "Novo Mundo",
        "urlNbhPt": "novo-mundo",
        "coordenadas_0_coordinate": -18.806,
        "coordenadas_1_coordinate": -48.312,
        "tituloPt": "Vendo Terreno NOVO MUNDO",
        "descripcionPt": "ÓTIMO TERRENO CABEÇA DE QUADRA MEDINDO 1.050M².",
        "numFotos": 1,
        "foto": "http://www.ivannegocios.com.br/webcorretor/imoveis/20157.jpg",
        "fotos": "[http://www.ivannegocios.com.br/webcorretor/imoveis/20157.jpg]",
        "showPrice": true,
        "suites": 0,
        "ubicacion": "BR>Minas Gerais>NULL>Uberlandia>Barrios>Novo Mundo",
        "dneScore": 0.0
    }
```

Crie uma API que execute as seguintes funções:

1. Um Auto-complete baseado [neste arquivo](enderecos.json) de endereços
2. Um endpoint que receba um endereço do auto-complete e devolva os imóveis com este filtro.
*. Para maiores bonus, integre com [este .html]() 

# Modo de avaliação

Nós sempre avaliamos o seu código, e para isso nós envolvemos sempre no mínimo 3 engenheiros aqui do Viva e amigavelmente informamos que iremos nos basear pelos seguintes critérios:

* **Manutenibilidade:** É um código legível, de fácil manutenção.
* **Desenho:** Como você separou as reponsabilidades. Quais técnicas utilizou.
* **Qualidade:** Tem testes? Quão difícil é recriar os testes caso seja necessário alterar o comportamento da aplicação?
* **Desempenho:** Utilizou algoritmos ou ferramentas que entregam uma performance adequada? 
* **(Extra) Integração:** Quão pronto está o código? Integrou com o html? Disponibilizou uma versão deployada?



