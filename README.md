# 📚  Sistema de Biblioteca

Sistema de gerenciamento de usuários e livros desenvolvido em Java com interface gráfica (Swing) e integração com banco de dados MySQL. O projeto simula um sistema de biblioteca com controle de permissões, CRUD completo e registro de ações por usuário logado.

---

## 🧩 Funcionalidades

### 🔐 Login
- Validação de usuários via banco de dados.
- Controle de acesso com base no tipo de usuário (`admin` ou `comum`).
- Sessão ativa que registra o usuário responsável por cada ação.

### 👥 Gerenciamento de Usuários (apenas Admin)
- **Cadastrar** novo usuário.
- **Consultar** usuários existentes.
- **Alterar** dados de usuários.
- **Remover** usuários do sistema.

### 📘 Gerenciamento de Livros (Admin e Comum)
- **Cadastrar** novos livros com vínculo ao usuário logado.
- **Consultar** lista de livros cadastrados.
- **Remover** livros da base de dados.

### 📌 Registro de Responsável
- Cada livro é vinculado ao **usuário logado** no momento do cadastro.

---

## 🗃️ Estrutura do Projeto

src/
├── ConexaoBD.java # Classe de conexão com o banco
├── Usuario.java # Modelo de usuário
├── Livro.java # Modelo de livro
├── UsuarioDAO.java # Regras de negócio e SQL para usuários
├── LivroDAO.java # Regras de negócio e SQL para livros
├── LoginTela.java # Tela de login
├── DashboardTela.java # Tela principal após login
├── UsuariosTela.java # Tela de gerenciamento de usuários
├── LivrosTela.java # Tela de gerenciamento de livros


---

## 🛠 Tecnologias Utilizadas

- **Java** (JDK 17+)
- **Swing** (GUI)
- **MySQL** (Banco de dados relacional)
- **Maven** (Gerenciamento de dependências)
- **NetBeans IDE**

---

## 🧪 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/projeto-a3-biblioteca.git
Estrutura do Banco de Dados (Exemplo)
sql

CREATE TABLE table_usuarios (
  nome VARCHAR(100) NOT NULL,
  senha VARCHAR(100) NOT NULL,
  tipo VARCHAR(20) NOT NULL,
  preferencia_livro_1 VARCHAR(100),
  preferencia_livro_2 VARCHAR(100)
);

CREATE TABLE table_livros (
  nome_livro VARCHAR(100) NOT NULL,
  autor VARCHAR(100),
  tipo_livro VARCHAR(100),
  ano_livro VARCHAR(4),
  usuario_responsavel VARCHAR(100)
);
