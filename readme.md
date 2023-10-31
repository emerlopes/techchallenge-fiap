# Investimento e Formalização de Proposta API

Esta documentação cobre os endpoints dos controladores `PlanoInvestimentoController` e `FormalizacaoPropostaController`, responsáveis pela gestão de planos de investimento e pela formalização de propostas, respectivamente.

# Executando o Projeto Localmente

Para executar o projeto em sua máquina local, siga as etapas abaixo:

1. **Clone o Repositório**:
2. **Execute a classe `ArinvestApplication`**:
3. **Testando as Chamadas HTTP**:

Dentro da pasta `misc`, você encontrará uma coleção em formato de arquivo que pode ser importada para o Insomnia.

Para isso:

- Abra o Insomnia.
- Clique em `Import` > `From File`.
- Navegue até a pasta `misc` do projeto clonado e selecione o arquivo da coleção.
- Uma vez importado, você poderá fazer todas as chamadas HTTP definidas na coleção diretamente do Insomnia, facilitando os testes dos endpoints.

## Endpoints de Planos de Investimento

### Consultar Todos os Planos de Investimento

- **GET** `/planos-investimento`
    - **Descrição**: Retorna todos os planos de investimento disponíveis.
    - **Respostas**:
        - `200 OK`: Sucesso na recuperação dos dados.

### Consultar Plano de Investimento por ID

- **GET** `/planos-investimento/{id}`
    - **Descrição**: Retorna um plano de investimento específico pelo seu ID.
    - **Parâmetros**:
        - `id`: ID do plano de investimento a ser consultado.

### Cadastrar Novo Plano de Investimento

- **POST** `/planos-investimento`
    - **Descrição**: Cria um novo plano de investimento.
    - **Corpo da Requisição**:
        - `PlanoInvestimentoRequestDTO`: Objeto contendo as informações do novo plano.

### Atualizar um Plano de Investimento

- **PUT** `/planos-investimento/{id}/atualizar-planos`
    - **Descrição**: Atualiza um plano de investimento existente.
    - **Parâmetros**:
        - `id`: ID do plano de investimento a ser atualizado.
    - **Corpo da Requisição**:
        - `PlanoInvestimentoAtualizacaoRequestDTO`: Objeto contendo as informações atualizadas do plano.

### Deletar um Plano de Investimento

- **DELETE** `/planos-investimento/{id}/deletar-planos`
    - **Descrição**: Remove um plano de investimento pelo seu ID.
    - **Parâmetros**:
        - `id`: ID do plano de investimento a ser removido.

## Endpoints de Formalização de Proposta

### Cadastrar Formalização de Proposta

- **POST** `/formalizacao-proposta/{id}`
    - **Descrição**: Cadastra a formalização de uma proposta usando o ID fornecido.
    - **Parâmetros**:
        - `id`: ID da proposta a ser formalizada.
    - **Respostas**:
        - `201 Created`: Retorna um objeto `FormalizacaoPropostaResponseDTO` com os detalhes da proposta formalizada.

## Exemplos de Corpo de Requisição para Planos de Investimento

### PlanoInvestimentoRequestDTO (para cadastro)

```json
{
  "nomeCliente": "Nome Cliente",
  "nomeModeloEquipamento": "Compressor",
  "valorTotalInvestimento": 50000.00,
  "valorTotalAnualInvestimento": 12000.00
}
```

### PlanoInvestimentoRequestDTO (para atualização)

```json
{
  "nomeCliente": "Nome Cliente",
  "nomeModeloEquipamento": "Compressor",
  "valorTotalInvestimento": 50000.00,
  "valorTotalAnualInvestimento": 12000.00,
  "statusPlanoInvestimentoEnum": "ENVIADO"
}
```