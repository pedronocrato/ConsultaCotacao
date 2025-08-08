# Consultor de Cotações em Java

Bem-vindo ao meu repositório do **Consultor de Cotações em Java**! 🚀 Este projeto é uma aplicação de console desenvolvida para buscar e exibir as cotações atuais de moedas fiduciárias e das principais criptomoedas em tempo real.

## Sobre

O objetivo deste repositório é demonstrar o consumo de múltiplas APIs REST em uma única aplicação Java. O programa se conecta à **AwesomeAPI** para obter a cotação do Dólar, Euro e Libra em relação ao Real e à **CoinGecko API** para buscar o valor das 10 criptomoedas mais populares. Os dados JSON recebidos de ambas as fontes são processados e exibidos de forma organizada no console.

## Funcionalidades Implementadas

- **Consulta a Múltiplas APIs**: Realiza requisições HTTP a dois serviços distintos (AwesomeAPI e CoinGecko) para obter diferentes conjuntos de dados financeiros.
- **Cotação de Moedas Fiduciárias**: Busca os valores atuais do Dólar Americano, Euro e Libra Esterlina em Reais (BRL).
- **Cotação de Criptomoedas**: Busca os valores das 10 principais criptomoedas do mercado (incluindo Bitcoin, Ethereum e Solana) em Reais (BRL).
- **Manipulação de JSON com Gson**: Utiliza a biblioteca `Gson` para analisar (`JsonParser`) e extrair os dados de cotação das respostas JSON de ambas as APIs.
- **Saída Formatada no Console**: Apresenta os resultados de forma clara e legível, separando as moedas fiduciárias das criptomoedas com uma formatação limpa.

## Ferramentas e Tecnologias

- **Java 11 ou superior**: Linguagem de programação utilizada, com foco no `HttpClient` nativo para as requisições web.
- **Gson**: Biblioteca do Google para trabalhar com JSON em Java.
- **AwesomeAPI**: API utilizada para as cotações de moedas fiduciárias.
- **CoinGecko API**: API utilizada para as cotações de criptomoedas.
- **IDEs recomendadas**: [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou [Eclipse](https://www.eclipse.org/).
