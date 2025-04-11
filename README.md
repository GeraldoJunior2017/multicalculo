# MultiCálculo

Projeto desenvolvido em Spring Boot para cálculo de propostas com base em dados de cliente e plano de saúde.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (pode ser trocado)
- Lombok
- Swagger (Documentação da API)
- Maven

---

## ⚙️ Como executar o projeto

1. **Clone o repositório:**

git clone https://github.com/GeraldoJunior2017/multicalculo.git
cd multicalculo
Abra no IntelliJ ou VS Code (com suporte a Java)

Execute a aplicação:

Pelo terminal:

./mvnw spring-boot:run
Ou direto pela IDE, rodando a classe MulticalculoApplication.

🧪 Testando a API com Swagger
Após subir a aplicação, acesse:

http://localhost:8080/swagger-ui/index.html
📥 Exemplo de requisição POST /api/calculos

json
{
  "nomeCliente": "João da Silva",
  "idade": 30,
  "dependentes": 2,
  "planoId": 1
}
📌 Endpoints principais
POST /api/planos → Cadastrar novo plano de saúde

GET /api/planos → Listar todos os planos

POST /api/calculos → Realizar cálculo com base no cliente e plano

GET /api/historico → Listar histórico de cálculos realizados

👤 Autor
José Geraldo Cabral de Figueiredo Junior
📧 geraldojrfigueiredo@gmail.com
📞 (47) 99288-9573
LinkedIn

📝 Licença
Esse projeto está sob a licença MIT.
