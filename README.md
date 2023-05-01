# Sistema de gestão de pedidos

Este é um projeto CRUD em Angular para gerenciar pedidos e produtos, consumindo uma API REST em Java com Spring Boot.

## Funcionalidades

- Criar novo pedido
- Visualizar lista de pedidos
- Visualizar detalhes de um pedido
- Editar um pedido
- Cadastrar novo produto
- Visualizar lista de produtos
- Visualizar detalhes de um produto
- Editar um produto

## Executando o projeto

### Requisitos

- Node.js (v12 ou superior)
- Angular CLI (v11 ou superior)
- Banco de dados SQL Server instalado com a porta 1433 aberta ou editado no arquivo application.properties do backend.

### Backend

1. Clone o repositório do projeto em uma pasta de sua escolha.
2. Acesse a pasta "backend" pelo terminal.
3. Digite o comando "mvn clean install" para instalar as dependências do projeto.
4. Digite o comando "mvn spring-boot:run" para iniciar o servidor backend. 

### Frontend

1. Acesse a pasta "frontend" pelo terminal.
2. Digite o comando "npm install" para instalar as dependências do projeto.
3. Digite o comando "ng serve --port 8081" para iniciar o servidor frontend.

Acesse http://localhost:8081/ para utilizar o sistema.

## Imagens do sistema

### Criar novo pedido

![Criar novo pedido](images/novo-pedido.png)

### Lista de pedidos

![Lista de pedidos](images/lista-pedidos.png)

### Detalhes do pedido

![Detalhes do pedido](images/detalhes-pedido.png)

### Editar pedido

![Editar pedido](images/editar-pedido.png)

### Cadastrar novo produto

![Cadastrar novo produto](images/novo-produto.png)

### Lista de produtos

![Lista de produtos](images/lista-produtos.png)

### Detalhes do produto

![Detalhes do produto](images/detalhes-produto.png)

### Editar produto

![Editar produto](images/editar-produto.png)
