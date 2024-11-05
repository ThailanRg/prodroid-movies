
## Tópicos abordados

- **Ktor**: Framework para comunicação HTTP com o backend.
- **Jetpack Compose**: Framework para construção da interface de usuário (UI).
- **Navigation Safe Args**: Utilizado para navegação entre telas, com passagem segura de dados.
- **Clean Architecture**: Organização de código dividida em camadas: Use Case, Repository e Data Source.
  
## Arquitetura

A arquitetura do projeto segue o padrão **Clean Architecture** com as seguintes camadas:

1. **Use Cases**: Contém a lógica de negócios do projeto, interagindo com os repositórios para recuperar ou enviar dados.
2. **Repositories**: Responsáveis por fornecer os dados para os casos de uso. Eles podem interagir com fontes de dados locais e remotas.
3. **Data Sources**: Fontes de dados específicas, como APIs remotas (via Ktor) ou bancos de dados locais.


| Lista | Detalhes |
| -------- | ------- |
| <img src="https://github.com/user-attachments/assets/07d362ef-c497-4abc-9a9c-2e45eef5e3c9" height="800" />  | <img src="https://github.com/user-attachments/assets/925a73d3-2fc5-4013-aa1e-6a0b266ce0d3" height="800" />    |

