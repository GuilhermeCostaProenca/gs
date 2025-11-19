# Global Solution – Programação Orientada a Objetos com Java e Web

## Sistema de Venda de Passagens Aéreas

**Aluno:** Guilherme Costa Proença — RM98937
**Professor:** Dr. Antonio Marcos Selmini
**Disciplina:** Java Web — 2º Semestre / 2025

---

## 📘 Descrição do Projeto

Este projeto implementa um sistema simples de venda de passagens aéreas utilizando Java Web (JSP + Servlets). O sistema permite:

* Cadastro e login de passageiros
* Compra de passagens para diferentes regiões do Brasil
* Cálculo automático de valores conforme o enunciado
* Painel administrativo com busca de passageiros
* Pesquisa de vendas por região
* Listagem completa de todas as vendas

O projeto utiliza **Oracle** como banco de dados e roda em **Tomcat 9**.

---

## 🗂 Estrutura do Projeto

```
src/
 └── br/fiap/
      ├── controller/       → Servlets
      ├── dao/              → Classes de acesso ao banco (JDBC)
      ├── model/            → Modelos (Usuario / Reserva)

WebContent/
 ├── index.jsp              → Tela de login
 ├── cadastro.jsp           → Cadastro de passageiro
 ├── venda.jsp              → Compra de passagens
 ├── admin.jsp              → Painel administrativo
 ├── listarVendas.jsp       → Relatórios de vendas
 ├── resultadoCompra.jsp    → Confirmação da compra
 └── WEB-INF/
        └── web.xml         → Mapeamento das Servlets
```

---

## 🛢 Banco de Dados Oracle (FIAP)

As tabelas foram criadas exatamente conforme solicitado no enunciado.

### Tabela `gs_usuario`:

```
id_usuario      number(10) primary key
email           varchar2(50)
senha           varchar2(50)
nome            varchar2(50)
tipo_usuario    varchar2(50)
```

### Tabela `gs_reserva`:

```
id_reserva      number(10) primary key
id_usuario      number(10) references gs_usuario(id_usuario)
destino         varchar2(50)
tipo_de_viagem  varchar2(50)
seguro          varchar2(50)
valor           number(10,2)
```

### Usuários iniciais para teste

```
(1000, 'passageiro@fiap.com', '123', 'Passageiro Teste', 'passageiro')
(1001, 'admin@fiap.com', '123', 'Administrador', 'admin')
```

---

## ▶ Como Executar o Projeto

### Requisitos

* Apache Tomcat 9
* JDK 17+
* Banco Oracle FIAP configurado
* Extensão Tomcat (se estiver usando Cursor ou VSCode)

### Passos

1. Configure seu Tomcat 9 e adicione o projeto como **war exploded**.
2. Inicie o servidor.
3. Acesse:

```
http://localhost:8080/gs/index.jsp
```

4. Faça login com os usuários de teste.

---

## 🎥 O que é demonstrado no vídeo

* Estrutura do projeto (controller/dao/model/JSP)
* Navegação completa do sistema
* Login como passageiro
* Compra de passagem e cálculo de valor
* Inserção da compra no banco Oracle
* Login como administrador
* Pesquisa de passageiros
* Pesquisa de vendas por região
* Listagem completa de vendas
* Prova de que o sistema funciona fim a fim

---

## ✔ Conclusão

O projeto cumpre 100% dos requisitos da Global Solution:

* JSP e Servlets
* Tomcat 9
* Conexão com Oracle via JDBC
* IDs gerados no Java conforme pedido
* Funcionalidades completas de passageiro e administrador
* Estrutura profissional, organizada e clara

Pronto para entrega no portal FIAP.
