# Projeto Mottu Challenge - Sistema de Gestão de Motos

##  Descrição

Este projeto é uma aplicação Spring Boot desenvolvida para gerenciar o controle de **motos**, **galpões** e **vagas**, com funcionalidades completas de cadastro, consulta (com caching), paginação e integração com banco de dados H2. 

Ele simula um sistema interno de gerenciamento de ativos para empresas que operam com frotas de motos, como locadoras ou serviços de logística.

---
## TDesenvolvedores
--Julia Vasconcelos RM:558785 Turma: 2TDSPF
--Leonardo Cadena
--Davi Gonzaga

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
  - Spring Cache
- **Banco de Dados H2 (memória)**
- **Swagger/OpenAPI 3** para documentação
- **Lombok** para simplificar a criação de classes


---

## 🧩 Principais Funcionalidades

- Cadastro e atualização de **motos**
- Gerenciamento de **galpões** (local de armazenamento)
- Controle de **vagas** ocupadas por motos
- Busca de motos por:
  - **Placa**
  - **Chassi**
  - **Modelo**
  - **Status**
-  Implementação de **caching** com Spring Cache para otimizar performance nas consultas

---

##  Como Executar

### Pré-requisitos:
- JDK 17 instalado
- Maven ou Gradle
- IDE (IntelliJ, Eclipse, VSCode)

