# Projeto E-commerce de Camisas de Futebol - Java

<br />

<div align="center"> <img src="https://i.imgur.com/IaD4lwg.png" title="source: imgur.com" width="35%"/> </div>
<br />

<div align="center"> 
  <img src="https://img.shields.io/github/languages/top/rafaelq80/aulas_java_t82?style=flat-square" /> 
  <img src="https://img.shields.io/github/repo-size/rafaelq80/aulas_java_t82?style=flat-square" /> 
  <img src="https://img.shields.io/github/languages/count/rafaelq80/aulas_java_t82?style=flat-square" /> 
  <img src="https://img.shields.io/github/last-commit/rafaelq80/aulas_java_t82?style=flat-square" /> 
  <img src="https://img.shields.io/github/issues/rafaelq80/aulas_java_t82?style=flat-square" /> 
  <img src="https://img.shields.io/github/issues-pr/rafaelq80/aulas_java_t82?style=flat-square" /> 
  <img src="https://img.shields.io/badge/status-concluído-green" alt="Status: Concluído"> 
</div>
<br />

## 1. Descrição

O **Projeto E-commerce de Camisas de Futebol** é um sistema de gestão desenvolvido para simular e administrar operações comuns em uma loja virtual de camisas de times de futebol. O sistema oferece funcionalidades como cadastro, consulta, atualização e remoção de camisas, organizando informações como nome, preço, tamanho e identificador único (ID).

Desenvolvido em **Java**, o projeto foca na aplicação dos conceitos de **Programação Orientada a Objetos (POO)**, incluindo:

- **Classes e Objetos**: Estruturação de entidades como `Produto` e `Camisa`.
- **Atributos e Métodos**: Definição de propriedades e comportamentos das classes.
- **Modificadores de Acesso**: Uso de `private` e `public` para encapsulamento.
- **Herança e Polimorfismo**: `Camisa` herda de `Produto`, com métodos sobrescritos.
- **Classes Abstratas**: `Produto` como base abstrata.
- **Interfaces**: `Repository` define um contrato para operações CRUD.
- **Collections**: Uso de `ArrayList` para gerenciar camisas.
- **Exceptions**: Validação de entradas com `IllegalArgumentException` e `InputMismatchException`.

O sistema foi construído em três etapas:
1. **Model**: Criação das classes `Produto` (abstrata) e `Camisa` (concreta).
2. **Repository**: Desenvolvimento da interface `Repository` e da classe `ProdutoRepository`.
3. **Controller**: Implementação da classe `Controller` para gerenciar operações CRUD.

O projeto oferece uma interface de console interativa com um menu visual, mensagens coloridas (via classe `Cores`), e exibição clara do ID das camisas na listagem, promovendo uma experiência de usuário eficiente e amigável.

<br />

## 2. Funcionalidades do Projeto

- **Cadastrar Camisa**: Adiciona uma nova camisa ao sistema, especificando nome, preço e tamanho (P, M, G). O ID é gerado automaticamente.
- **Listar Todas as Camisas**: Exibe todas as camisas cadastradas, incluindo o ID, nome, tamanho e preço.
- **Consultar Camisa por ID**: Localiza uma camisa específica pelo seu identificador único.
- **Atualizar Camisa**: Permite modificar os dados (nome, preço, tamanho) de uma camisa existente com base no seu ID.
- **Excluir Camisa**: Remove uma camisa do sistema usando seu ID.

<br />

## 3. Diagrama de Classes

Um Diagrama de Classes representa a estrutura do sistema, mostrando classes, atributos, métodos e relacionamentos como herança e associações. Ele auxilia no planejamento e na compreensão da arquitetura do projeto.

Abaixo está o Diagrama de Classes do **Projeto E-commerce de Camisas de Futebol**:

```mermaid
classDiagram
    class Produto {
        -id: int
        -nome: String
        -preco: double
        +getId() int
        +getNome() String
        +getPreco() double
        +setId(id: int) void
        +setNome(nome: String) void
        +setPreco(preco: double) void
        +exibirDetalhes() String
    }
    class Camisa {
        -tamanho: String
        +getTamanho() String
        +setTamanho(tamanho: String) void
        +exibirDetalhes() String
    }
    class Repository {
        <<interface>>
        +cadastrar(produto: Produto) void
        +listarTodos() void
        +buscarPorId(id: int) Produto
        +atualizar(produto: Produto) void
        +remover(id: int) void
    }
    class ProdutoRepository {
        -produtos: List~Produto~
        -proximoId: int
        +getProdutos() List~Produto~
        +cadastrar(produto: Produto) void
        +listarTodos() void
        +buscarPorId(id: int) Produto
        +atualizar(produto: Produto) void
        +remover(id: int) void
    }
    class Controller {
        -repositorio: Repository
        +cadastrarCamisa(nome: String, preco: double, tamanho: String) void
        +listarCamisas() List~Produto~
        +buscarCamisaPorId(id: int) Produto
        +atualizarCamisa(id: int, nome: String, preco: double, tamanho: String) void
        +removerCamisa(id: int) void
    }
    Camisa --> Produto
    ProdutoRepository --> Repository
    Controller --> Repository
    Controller --> ProdutoRepository