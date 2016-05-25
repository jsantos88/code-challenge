# VivaReal Code Challenge :)

<!-- If you prefer, you can read our [english version](README-en.md). -->

## Pré-requisito

Conheça a [lenda de Spotippos](history.md)

## Propósito dos nossos desafios

De acordo com seus skills, queremos entender a forma como você pensa para resolver problemas, como você organiza seu código e quais tecnologias você se sente mais confortável para utilizar no dia-a-dia.

## Escolha seu desafio

Mantemos desafios com foco específico em cada área de conhecimento, escolha abaixo o que estiver mais aderente com as suas características e anseios profissionais:

[Desafio back-end](backend.md)

[Desafio front-end](frontend.md)

## Como você será avaliado

Nós sempre avaliaremos o seu código, e para isso nós envolvemos sempre no mínimo 3 engenheiros aqui do Viva e antecipadamente lhe informamos quais os principais critérios que vão balizar nossa avaliação:

## Desafio

Em Spotippos temos as seguintes regras:

1. A área total de Spotippos é definida da seguinte forma `0 <= x <= 1400` e `0 <= y <= 1000`.
2. Um imóvel em Spotippos tem as seguintes características:
  - No máximo 5 quartos (beds), e no mínimo 1
  - No máximo 4 banheiros (baths), e no mínimo 1
  - No máximo 240 metros quadrados, e no mínimo 20

Usando as informações anteriores, crie uma API REST que execute as funções abaixo. Você pode fazer tudo em memória, ou seja, não precisa utilizar nenhum banco de dados ou ferramenta. Se você preferir, se sentir mais confortável ou achar mais fácil, fique a vontade! ;)

### 1. Crie imóveis em Spotippos :)

A partir da estrutura abaixo em `Request` e `Body` permita a criação de um imóvel. Todos os campos são obrigatórios e devem respeitar as regras enunciadas neste desafio e nos limites geográficos de Spottipos.

Request:
```
POST /properties
```

Body:
```json
{
  "x": 222,
  "y": 444,
  "beds": 4,
  "baths": 3,
  "squareMeters": 210
}
```

Response:

Você define, faz parte da avaliação.

### 2. Mostre um imóvel específico em Spotippos =]

Busque um imóvel específico a partir de seu `id`.

Request:
```
  GET /properties/{id}
```

Response:

```json
{
  "id": 665,
  "x": 667,
  "y": 556,
  "beds": 1,
  "baths": 1,
  "provinces" : ["Ruja"],
  "squareMeters": 42
}
```

### 3. Busque imóveis em Spotippos :D

A partir de um retangulo representado pelos pontos A e B, onde A é o ponto superior esquerdo e B é o ponto inferior direito.

Cada ponto é representado pelas cordenadas `x` e `y`. O ponto A é representado por `ax` e `ay` e B por `bx` e `by`, sendo assim a estrutura da url deve ser a seguinte:

Request:
```
  GET /properties?ax={integer}&ay={integer}&bx={integer}&by={integer}
```

Response:

```json
{
  "foundProperties": 3,
  "properties": [
    {
      "id": 34,
      "x": 999,
      "y": 333,
      "beds": 4,
      "baths": 3,
      "squareMeters": 237
    },
    {"..."},
    {"..."}
  ]
}
```

### 4. Wow! Agora temos que fazer deploy! :D

Crie uma documentação de como rodar o seu projeto! Quanto mais simples, melhor! =D

## Modo de avaliação

Nós sempre avaliamos o seu código, e para isso nós envolvemos sempre no mínimo 3 engenheiros aqui do Viva e amigavelmente informamos que iremos nos basear pelos seguintes critérios:

* **Manutenibilidade:** O código é legível e de fácil manutenção?
* **Desenho:** Como foram separadas as responsabilidades? Quais técnicas foram utilizadas?
* **Qualidade:** Tem testes? Quão difícil é recriar os testes caso seja necessário alterar o comportamento da aplicação?
* **Desempenho:** Escreveu um código com performance adequada? Não precisa ser perfeito, mas entende como seria a melhor solução?

Fique a vontade para incrementar seu desafio de modo a demonstrar como o resultado do seu esforço pode deixá-lo ainda melhor!

Bom código! ;)
