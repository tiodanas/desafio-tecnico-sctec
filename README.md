# DESAFIO TÉCNICO SCTEC - BACKEND API

## 📝 Descrição

Este é um projeto desenvolvido para o processo de seleção do curso IA para DEVs, do programa SCTEC.

O desafio técnico escolhido foi o Desafio Prático de Software, na opção de desenvolvimento de serviço backend, implementado como uma aplicação API REST.

Esta aplicação permite o gerenciamento de informações sobre empreendimentos, contemplando os seguintes campos:
* Nome do empreendimento
* Nome do(a) empreendedor(a) responsável
* Município de Santa Catarina
* Segmento de atuação
  * Tecnologia
  * Comércio
  * Indústria
  * Serviços
  * Agronegócio
* E-mail ou meio de contato
* Status (ativo ou inativo)

Esta aplicação backend permite as seguintes ações:
* Listar todos os empreendimentos cadastrados
* Buscar os dados cadastrados de um empreendimento em específico
* Cadastrar novo empreendimento
* Atualizar os dados de um empreendimento cadastrado
* Inativar um empreendimento cadastrado
* Ativar um empreendimento cadastrado
* Excluir todos os dados de um empreendimento cadastrado
* Listar todos os segmentos cadastrados
* Buscar os dados cadastrados de um segmentos em específico
* Cadastrar novo segmentos
* Atualizar os dados de um segmentos cadastrado
* Excluir todos os dados de um segmentos cadastrado

### Endpoints implementados para a realização das ações disponíveis
* `GET /api/v1/empreendimentos`
  * Lista todos os empreendimentos cadastrados


* `GET /api/v1/empreendimentos/{id}`
  * Busca os dados cadastrados de um empreendimento em específico - parâmetro {id}


* `POST /api/v1/empreendimentos`
  * Cadastrar novo empreendimento


* `PUT /api/v1/empreendimentos/{id}`
  * Atualizar os dados de um empreendimento cadastrado - parâmetro {id}


* `PATCH /api/v1/empreendimentos/{id}`
  * Inativar um empreendimento cadastrado - parâmetro {id}


* `PATCH /api/v1/empreendimentos/{id}`
  * Ativar um empreendimento cadastrado - parâmetro {id}


* `DELETE /api/v1/empreendimentos/{id}`
  * Excluir todos os dados de um empreendimento cadastrado - parâmetro {id}


* `GET /api/v1/segmentos`
    * Lista todos os segmentos cadastrados


* `GET /api/v1/segmentos/{id}`
    * Busca os dados cadastrados de um segmento em específico - parâmetro {id}


* `POST /api/v1/segmentos`
    * Cadastrar novo segmento


* `PUT /api/v1/segmentos/{id}`
    * Atualizar os dados de um segmento cadastrado - parâmetro {id}


* `DELETE /api/v1/segmentos/{id}`
    * Excluir todos os dados de um segmento cadastrado - parâmetro {id}

### Documentação Swagger

Esta aplicação disponibiliza uma página HTML com a sua documentação em formato Swagger, que é um conjunto de ferramentas open-source baseadas na OpenAPI Specification (OAS).
* [Swagger](https://swagger.io/)
* [OpenAPI Specification (OAS)](https://www.openapis.org/)

### Como acessar a documentação Swagger

Com a aplicação rodando, acesse esse link: [Documentação Swagger desta aplicação](http://localhost:8080/api-docs.html)

### Usando a documentação Swagger para testar a API

Além de ter acesso a documentação dos endpoints implementados nesta API,
a documentação Swagger também permite a execução desses endpoints.

**Veja maiores detalhes de como executar a chamada dos endpoints no vídeo pitch deste projeto.**

## 💻 Tecnologias utilizadas

### Linguagem de programação Java
* Versão 25
* [Documentação da Oracle para o JDK realease 25](https://docs.oracle.com/en/java/javase/25/index.html)

### Framework Spring Boot
* Possibilita a simplificação e agilidade no desenvolvimento de aplicações Java
* Versão 4.0.3
* [Site oficial](https://spring.io/projects/spring-boot)

### Banco de dados H2
* Sistema de Gerenciamento de Banco de Dados (SGBD) relacional H2
* Implementado como banco de dados in-memory
* [Site oficial](https://www.h2database.com/html/main.html)

### Controle de versão GIT
* Sistema de controle de versão distribuído GIT
* [Site oficial](https://git-scm.com/)

## 📁 Estrutura geral do projeto

* Diretório `./src`
    * Código fonte


* Diretório `./src/main`
    * Arquivos principais do código fonte


* Diretório `./src/main/java`
    * Arquivos de programação Java


* Diretório `.src/main/java/br/gov/sc/sctec/empreendedorismo/backend/api`
    * Pacote root dos arquivos de programação Java


* Diretório `.src/main/java/br/gov/sc/sctec/empreendedorismo/backend/api/common`
    * Classes de uso comum, atualmente possui as classes para tratamento de Exceptions 


* Diretório `.src/main/java/br/gov/sc/sctec/empreendedorismo/backend/api/config`
    * Classes de configuração, atualmente possui a classe para configuração da documentação swagger


* Diretório `.src/main/java/br/gov/sc/sctec/empreendedorismo/backend/api/controller`
    * Classes do padrão Controller (camada de apresentação), responsáveis pela definição das URIs dos endpoints e recebimento dos requests


* Diretório `.src/main/java/br/gov/sc/sctec/empreendedorismo/backend/api/dto`
    * Classes de beans DTOs, responsáveis pela definição dos formatos dos dados nos inputs e outputs dos endpoints 


* Diretório `.src/main/java/br/gov/sc/sctec/empreendedorismo/backend/api/model`
    * Classes do padrão Model (camada de dados), responsáveis pelo mapeamento das entidades de negócio com as tabelas da base de dados


* Diretório `.src/main/java/br/gov/sc/sctec/empreendedorismo/backend/api/repository`
    * Classes do padrão Repository (camada de acesso a dados), responsáveis pela abstração entre a lógica de negócios e o banco de dados


* Diretório `.src/main/java/br/gov/sc/sctec/empreendedorismo/backend/api/service`
    * Classes do padrão Service (camada de serviço), que encapsulam a lógica de negócio, separando-a da camada de apresentação e da camada de acesso a dados.


* Diretório `./src/main/resources`
  * Arquivos auxiliares de configuração em tempo de runtime


* Diretório `src/test`
    * Classes do testes automatizados, atualmente estão implementados os teste de integração da camada de apresentação - controller. 

## 🔀 Estratégia inicial para uso de branchs no GIT

### Este projeto possui 3 branchs principais:
* main
* stage
* develop

### Ciclo de branchs para toda nova implementação
* Deve-se criar uma nova branch com o nome `develop_<nome-da-funcionalidade>`
* A origem dessa nova branch deve ser sempre a `develop`
* Quando a implementação finalizar, deve-se fazer o merge desta nova branch de volta para a `develop`
* Para disponibilizar a nova funcionalidade no ambiente stage, fazer o merge da `develop` para a `stage`
* Quando pronto para subir em produção, fazer um pull request da branch `stage` para a `main`

### Ciclo de branchs para toda correção de bug apresentado em produção
* Deve-se criar uma nova branch com o nome `main_<nome-do-bug>`
* A origem dessa nova branch deve ser sempre a `main`
* Quando a implementação finalizar, deve-se fazer o merge desta nova branch de volta para a branch `stage`
* Quando pronto para subir em produção, fazer um pull request da branch `stage` para a `main`
* Para manter a branch develop atualizada, fazer o merge da branch `main` para a `develop`

## 🚀 Como Executar

### Método 1: com JDK e Maven locais
Siga estas etapas para rodar o projeto na sua máquina.

#### Pré-requisitos
* JDK 25 instalado
* Maven 3.9.x instalado

#### Passo a Passo
1. **Abra um terminal/prompt de comando**
2. **Clone o repositório GIT**
   ```bash
   git clone https://github.com/tiodanas/desafio-tecnico-sctec.git
3. **Acesse o diretório raiz onde o projeto foi clonado**
4. **Compile o projeto usando o maven**
   ```bash
   mvn clean package
5. **Rode o jar gerado**
   ```bash
   java -jar target\sctec-empreendedorismo-backend-api-0.0.1-SNAPSHOT.jar
6. **Acesse a página de documentação Swagger para ver se a aplicação está rodando, onde também pode-se testar os endpoints da API**
   * [http://localhost:8080/api-docs.html](http://localhost:8080/api-docs.html)

### Método 2: com docker
Siga estas etapas para rodar o projeto na sua máquina.

#### Pré-requisitos
* Docker instalado

#### Passo a Passo
1. **Abra um terminal/prompt de comando**
2. **Clone o repositório GIT**
   ```bash
   git clone https://github.com/tiodanas/desafio-tecnico-sctec.git
3. **Acesse o diretório raiz onde o projeto foi clonado**
4. **Execute o build da imagem usando o Docker (parâmetro -t indica o nome da imagem a ser gerada)**
   ```bash
   docker build -t desafio-tecnico-sctec-backend-api .
5. **Rode o container do Docker, subindo a imagem construída**
   ```bash
   docker run -p 8080:8080 -d desafio-tecnico-sctec-backend-api
6. **Acesse a página de documentação Swagger para ver se a aplicação está rodando, onde também pode-se testar os endpoints da API**
    * [http://localhost:8080/api-docs.html](http://localhost:8080/api-docs.html)

## 🎥 Link para o vídeo pitch

**[https://youtu.be/tC0mAwD5Nbs](https://youtu.be/tC0mAwD5Nbs)**
