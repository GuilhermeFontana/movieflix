# MovieFlix

Sistema de catálogo de filmes desenvolvido em Spring Boot para gerenciamento de filmes, categorias e serviços de streaming.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.4**
- **Spring Security** - Autenticação e autorização
- **Spring Data JPA** - Persistência de dados
- **PostgreSQL** - Banco de dados
- **Flyway** - Migração de banco de dados
- **JWT** - Autenticação via tokens
- **Lombok** - Redução de código boilerplate
- **Maven** - Gerenciamento de dependências

## Funcionalidades

### Autenticação
- Registro de novos usuários
- Login com email e senha
- Autenticação via JWT tokens

### Gerenciamento de Categorias
- Criar novas categorias
- Listar todas as categorias
- Buscar categoria por ID
- Excluir categorias

### Gerenciamento de Streaming
- Criar novos serviços de streaming
- Listar todos os serviços
- Buscar serviço por ID
- Excluir serviços

### Gerenciamento de Filmes
- Cadastrar novos filmes
- Listar todos os filmes
- Buscar filme por ID
- Atualizar informações do filme
- Excluir filmes
- Filtrar filmes por categoria
- Associar filmes a múltiplas categorias e serviços de streaming

## Estrutura do Banco de Dados

O sistema utiliza as seguintes tabelas:

- `users` - Dados dos usuários
- `category` - Categorias de filmes
- `streaming` - Serviços de streaming
- `movie` - Filmes
- `movie_category` - Relacionamento many-to-many entre filmes e categorias
- `movie_streaming` - Relacionamento many-to-many entre filmes e streaming

## Configuração do Ambiente

### Pré-requisitos

- Java 17
- PostgreSQL
- Maven

### Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL chamado `movieflix1`
2. Configure as credenciais no arquivo `application.yaml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/movieflix1
    username: postgres
    password: minhasenha
```

### Executando a Aplicação

1. Clone o repositório
2. Configure o banco de dados
3. Execute o comando:

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

## Endpoints da API

### Autenticação

**POST** `/movieflix/auth/register`
- Registra um novo usuário
- Body: `{"name": "string", "email": "string", "password": "string"}`

**POST** `/movieflix/auth/login`
- Realiza login
- Body: `{"email": "string", "password": "string"}`
- Retorna: `{"token": "jwt_token"}`

### Categorias

**GET** `/movieflix/category`
- Lista todas as categorias

**POST** `/movieflix/category`
- Cria nova categoria
- Body: `{"name": "string"}`

**GET** `/movieflix/category/{id}`
- Busca categoria por ID

**DELETE** `/movieflix/category/{id}`
- Exclui categoria

### Streaming

**GET** `/movieflix/streaming`
- Lista todos os serviços de streaming

**POST** `/movieflix/streaming`
- Cria novo serviço
- Body: `{"name": "string"}`

**GET** `/movieflix/streaming/{id}`
- Busca serviço por ID

**DELETE** `/movieflix/streaming/{id}`
- Exclui serviço

### Filmes

**GET** `/movieflix/movie`
- Lista todos os filmes

**POST** `/movieflix/movie`
- Cria novo filme
- Body:
```json
{
  "title": "string",
  "description": "string",
  "releaseDate": "dd/MM/yyyy",
  "rating": 0.0,
  "categories": [1, 2],
  "streamings": [1, 2]
}
```

**GET** `/movieflix/movie/{id}`
- Busca filme por ID

**PUT** `/movieflix/movie/{id}`
- Atualiza filme

**DELETE** `/movieflix/movie/{id}`
- Exclui filme

**GET** `/movieflix/movie/search?category={categoryId}`
- Filtra filmes por categoria

## Autenticação

Todos os endpoints, exceto registro e login, requerem autenticação via JWT token.

Incluir o token no header:
```
Authorization: Bearer {jwt_token}
```

## Migração do Banco

As migrações são executadas automaticamente pelo Flyway na inicialização da aplicação. Os arquivos de migração estão em `src/main/resources/db/migration/`.

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/br/com/movieflix/
│   │   ├── config/          # Configurações de segurança e JWT
│   │   ├── controller/      # Controladores REST
│   │   ├── entity/          # Entidades JPA
│   │   ├── exception/       # Exceções customizadas
│   │   ├── mapper/          # Mapeadores entre DTOs e entidades
│   │   ├── repository/      # Repositórios JPA
│   │   └── service/         # Regras de negócio
│   └── resources/
│       ├── db/migration/    # Scripts de migração
│       └── application.yaml # Configurações da aplicação
```

## Executando Testes

```bash
./mvnw test
```

## Comandos Maven Úteis

```bash
# Compilar o projeto
./mvnw compile

# Executar a aplicação
./mvnw spring-boot:run

# Gerar JAR
./mvnw package

# Executar migrações Flyway
./mvnw flyway:migrate
```
