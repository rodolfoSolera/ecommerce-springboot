# 🛒 E-commerce Java com Spring Boot

Projeto de e-commerce desenvolvido com o objetivo de consolidar conhecimentos em **Java backend**, **Spring Boot**, **arquitetura em camadas**, **segurança**, **APIs REST**, **testes automatizados** e **Docker**.

O projeto está sendo desenvolvido de forma incremental, utilizando **issues**, **branches** e **commits organizados**, simulando um fluxo real de desenvolvimento em equipe.

---

## 🚀 Tecnologias Utilizadas

### Backend:

- **Java 21 (LTS)** – Linguagem principal do projeto

- **Spring Boot 3.3.5** – Framework para criação da aplicação

- **Spring Web (Spring MVC)** – Camada web (controllers e rotas)

- **Spring Security** – Autenticação e controle de acesso

### Persistência de Dados:

- **Spring Data JPA** – Abstração para acesso a dados

- **Hibernate** – Implementação ORM do JPA

- **PostgreSQL** – Banco de dados relacional

### Frontend:

- **Thymeleaf** – Template engine para renderização de páginas HTML

### Ferramentas e DevOps:

- **Gradle** – Gerenciamento de dependências e build

- **Docker** – Containerização da aplicação e do banco de dados

### Testes:

- **Spring Boot Starter Test (JUnit + Mockito)**

---

## 🧠 Arquitetura do Projeto

O projeto segue o padrão de **arquitetura em camadas**, separando responsabilidades para facilitar manutenção, testes e escalabilidade.

- **Config** → Configuração/Base de dados ficticios.
- **Controller** → Recebe requisições HTTP
- **Model** → Representação das tabelas
- **Repository** → Comunicação com o banco de dados
- **Service** → Contém a regra de negócio

---

## 📦 Estrutura do Projeto

Abaixo está a estrutura principal do projeto:


### 📁 Pacotes

- [`api`](src/main/java/com/ecommerce/api)  
  Camada responsável pela exposição das APIs REST (endpoints da aplicação).

- [`config`](src/main/java/com/ecommerce/config)  
  Configuração/Base de dados ficticios.

- [`controller`](src/main/java/com/ecommerce/controller)  
  Controllers responsáveis por rotas web e APIs REST.

- [`dto`](src/main/java/com/ecommerce/dto)  
  Objetos de transferência de dados usados para comunicação entre camadas e com o cliente (request/response).

- [`model`](src/main/java/com/ecommerce/model)  
  Entidades JPA (Hibernate) mapeadas para o banco de dados.

- [`repository`](src/main/java/com/ecommerce/repository)  
  Interfaces JPA para acesso aos dados.

- [`service`](src/main/java/com/ecommerce/service)  
  Regras de negócio da aplicação.

---

## 🎯 Funcionalidades Implementadas

- Cadastro e autenticação de usuários
- Controle de acesso por perfil (admin / user)
- CRUD de produtos
- Página inicial com listagem dinâmica de produtos
- Inicialização automática de dados (data initializer)
- Integração com banco de dados PostgreSQL
- Estrutura preparada para carrinho de compras e pedidos
- Carrinho de compras e pedidos
- Dashboard administrativo
- APIs REST

---

## 🧩 Funcionalidades em Desenvolvimento

O projeto está sendo desenvolvido com base em **issues**, abordando:

- Testes unitários e de integração
- Docker e Docker Compose
- Melhorias de segurança e tratamento de erros

---

## ▶️ Como Executar o Projeto

### Pré-requisitos
- Java 21
- Gradle 9+
- PostgreSQL

### Opcional
- Docker (para rodar o PostgreSQL em container)

### Executar localmente

## ⚠️ Compatibilidade

Este projeto utiliza:

- Java 21 (LTS)
- Spring Boot 3.3.x

Versões mais recentes (como Java 25 ou Spring Boot 4) podem não ser compatíveis com todas as dependências.

📌 Observações

Este projeto tem caráter educacional, mas segue boas práticas de mercado, com foco em organização, legibilidade e evolução contínua.

Cada funcionalidade é implementada em sua própria branch, associada a uma issue, garantindo histórico limpo e rastreável.