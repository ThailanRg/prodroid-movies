
## Tecnologias e Bibliotecas Utilizadas

- **Ktor**: Framework para comunicação HTTP com o backend.
- **Jetpack Compose**: Framework para construção da interface de usuário (UI).
- **Navigation Safe Args**: Utilizado para navegação entre telas, com passagem segura de dados.
- **Clean Architecture**: Organização de código dividida em camadas: Use Case, Repository e Data Source.
  
## Arquitetura

A arquitetura do projeto segue o padrão **Clean Architecture** com as seguintes camadas:

1. **Use Cases**: Contém a lógica de negócios do projeto, interagindo com os repositórios para recuperar ou enviar dados.
2. **Repositories**: Responsáveis por fornecer os dados para os casos de uso. Eles podem interagir com fontes de dados locais e remotas.
3. **Data Sources**: Fontes de dados específicas, como APIs remotas (via Ktor) ou bancos de dados locais.
