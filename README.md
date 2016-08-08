# Spotippos API

## Dependências
* java 8
* maven

## Executar aplicação
No diretório raiz da aplicação, executar os seguintes comandos:
```
mvn clean package
java -jar target/spotippo-service-1.0.0-RELEASE.jar
```

## Executar suíte de teste
```
mvn test
```

## Observação
Para carregar os imóveis que foram fornecidos no json do desafio, executar a aplicação com a seguinte linha de comando:
```
java -Dspotippos.carregarImoveis=true -jar target/spotippo-service-1.0.0-RELEASE.jar
```