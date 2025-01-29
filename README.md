```markdown
# Desafio Itaú - Vaga 99 Júnior

Este repositório contém a solução para o desafio de programação proposto pelo Itaú Unibanco para a vaga de desenvolvedor júnior. A aplicação é uma API REST que recebe transações e retorna estatísticas sobre essas transações.

Link do desafio : https://github.com/rafaellins-itau/desafio-itau-vaga-99-junior

## Requisitos

- Java 11 ou superior
- Maven 3.6 ou superior

## Como Executar o Projeto

### 1. Clone o repositório

```

### Compile o projeto

```bash
mvn clean install
```

### Execute a aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080` ou se preferir `http://localhost:8080/swagger-ui/index.html`

## Endpoints da API

### POST /transacao

Recebe uma transação no formato JSON:

```json
{
    "valor": 123.45,
    "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

**Respostas:**
- `201 Created`: Transação aceita.
- `422 Unprocessable Entity`: Transação inválida.
- `400 Bad Request`: Requisição malformada.

### DELETE /transacao

Limpa todas as transações armazenadas.

**Resposta:**
- `200 OK`: Transações apagadas com sucesso.

### GET /estatistica

Retorna estatísticas das transações dos últimos 60 segundos:

```json
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

**Resposta:**
- `200 OK`: Estatísticas calculadas.


