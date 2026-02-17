# 🛒 E-commerce Java com Spring Boot

Projeto de e-commerce desenvolvido com o objetivo de consolidar conhecimentos em **Java backend**, **Spring Boot**, **arquitetura em camadas**, **segurança**, **APIs REST**, **testes automatizados** e **Docker**.

O projeto está sendo desenvolvido de forma incremental, utilizando **issues**, **branches** e **commits organizados**, simulando um fluxo real de desenvolvimento em equipe.

---

## 🚀 Tecnologias Utilizadas

- **Java 25** – Linguagem principal do projeto
- **Spring Boot** – Framework para criação da aplicação
- **Spring MVC** – Camada web (controllers e views)
- **Spring Security** – Autenticação, autorização e controle de acesso
- **Spring Data JPA** – Persistência de dados
- **Hibernate** – Implementação do JPA (ORM)
- **Thymeleaf** – Template engine para as páginas HTML
- **PostgreSQL** – Banco de dados relacional
- **Gradle** – Gerenciamento de dependências
- **JUnit** – Framework para testes automatizados em Java
- **Mockito** – Mock de dependências para testes
- **Docker** – Containerização da aplicação e do banco de dados

---

## 🧠 Arquitetura do Projeto

O projeto segue o padrão de **arquitetura em camadas**, separando responsabilidades para facilitar manutenção, testes e escalabilidade.

- **Controller** → Recebe requisições HTTP
- **Service** → Contém a regra de negócio
- **Repository** → Comunicação com o banco de dados
- **Entity** → Representação das tabelas
- **Initializer** → Base de dados ficticios

---

## 📦 Estrutura do Projeto

Abaixo está a estrutura principal do projeto:


### 📁 Pacotes

- [`controller`](src/main/java/com/ecommerce/controller)  
  Controllers responsáveis por rotas web e APIs REST.

- [`entity`](src/main/java/com/ecommerce/entity)  
  Entidades JPA (Hibernate) mapeadas para o banco de dados.

- [`initializer`](src/main/java/com/ecommerce/initializer)  
  Base de dados ficticios.

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

---

## 🧩 Funcionalidades em Desenvolvimento

O projeto está sendo desenvolvido com base em **issues**, abordando:

- Carrinho de compras e pedidos
- APIs REST
- Testes unitários e de integração
- Docker e Docker Compose
- Dashboard administrativo
- Melhorias de segurança e tratamento de erros

---

## ▶️ Como Executar o Projeto

### Pré-requisitos
- Java 25
- Gradle
- PostgreSQL (ou Docker)

### Executar localmente


📌 Observações

Este projeto tem caráter educacional, mas segue boas práticas de mercado, com foco em organização, legibilidade e evolução contínua.

Cada funcionalidade é implementada em sua própria branch, associada a uma issue, garantindo histórico limpo e rastreável.