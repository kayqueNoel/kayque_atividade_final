# Controle de Estoque da Cantina

**Aluno:** Kayque Feliciano Lima  
**Turma:** 2DS N  
**Tema:** Opção A - Controle de Estoque da Cantina

## Descrição

O programa permite cadastrar produtos, listar os produtos cadastrados, buscar um produto pelo código, registrar vendas e consultar o valor total do estoque.

Os dados ficam armazenados na memória enquanto o programa está aberto. Ao fechar o programa, os dados não são salvos.

## Como executar

1. Abra o projeto no IntelliJ IDEA.
2. Confira se os arquivos `Main.java` e `Produto.java` estão na pasta `src` (ou no mesmo pacote).
3. Execute a classe `Main`.
4. Use o menu exibido no console.

É necessário ter o Java instalado.

## Funcionalidades

- Cadastrar produto.
- Listar produtos.
- Buscar produto pelo código.
- Registrar venda, atualizando a quantidade.
- Calcular o valor total do estoque.
- Validar código repetido, nome vazio, preço e quantidade.
- Impedir venda com quantidade maior que o estoque.

## Testes realizados

| Teste | Dados/ação | Resultado esperado |
|---|---|---|
| Cadastro válido | Código 101, Suco, preço 5,00, quantidade 10 | Produto cadastrado |
| Código repetido | Cadastrar novamente o código 101 | Cadastro recusado |
| Busca existente | Buscar código 101 | Mostrar os dados do suco |
| Venda válida | Vender 3 unidades do código 101 | Estoque fica com 7 |
| Venda acima do estoque | Tentar vender 8 unidades | Venda recusada e estoque continua em 7 |
| Valor do estoque | Suco a R$ 5,00 com 7 unidades | Mostrar R$ 35,00 |
| Lista vazia | Listar sem cadastrar produtos | Informar que não há produtos |

## Uso de inteligência artificial

Foi utilizada uma ferramenta de inteligência artificial como apoio para organizar a estrutura inicial do código e revisar as validações. O código foi conferido e deve ser estudado e testado pelo aluno antes da apresentação.

## Limitações

O sistema funciona pelo console e mantém os dados somente durante a execução. Não possui banco de dados nem gravação em arquivos.
