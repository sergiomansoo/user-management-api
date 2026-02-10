## CRUD de Usuários com Spring Boot
API REST para gerenciamento de usuários desenvolvida com Java 21 e Spring Boot. O foco do projeto foi aplicar padrões de Clean Architecture, organizando o código em camadas de business (regras de negócio) e infrastructure (persistência).

### 💻 O que o projeto faz:
Cadastro e Listagem: Criação e busca de usuários por e-mail (usando Optional pra evitar erros de null).

Update Inteligente: Atualiza apenas os campos enviados, sem perder os dados antigos no banco.

Banco H2: Configurado para rodar em memória, ideal para testar rápido sem precisar instalar um Postgres ou MySQL agora.


### 🛠 Tecnologias:
Java 21 e Spring Boot 3.

Lombok.

Spring Data JPA: Para lidar com o banco de dados.


### 📂 Organização (Arquitetura):
Diferente do básico service/controller, usei uma estrutura mais organizada:

controller: Onde ficam os endpoints da API.

business: Onde guardo a lógica de negócio (Services).

infrastructure: Onde fica a conexão com o banco (Entities e Repositories).
