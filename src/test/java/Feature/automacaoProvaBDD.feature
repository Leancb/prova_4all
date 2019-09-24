# new feature
# Tags: 4All
# language: pt

Funcionalidade:
  Eu, enquanto candito a vaga de QA da 4All
  Preciso automatizar o teste proposto para vaga
  Para garantir aprovação no processo seletivo.

    @4all
  Esquema do Cenario: Desafio 1
    Dado      que configurei ambiente para acessar URL <Tipo_Browser>
    Quando    abri tela da prova 4all
    E         Selecionar categoria Doces
    E         Selecionar categoria Todos
    E         Acessar o carrinho e aumentar em 4 brigadeiros
    E         Clicar em finalizar compra
    E         Clicar no botão Fechar
    Entao     Fecha o Browser
    Exemplos:
      | Tipo_Browser |
      | chrome       |
      | firefox      |

    @4all
    Esquema do Cenario: Desafio 2
    Dado      que configurei ambiente para acessar URL <Tipo_Browser>
    Quando    abri tela da prova 4all
    E         Selecionar categoria Bebidas
    E         Selecionar categoria Todos
    E         Acidionar Rissole ao carrinho
    E         Acessar o carrinho e aumentar 9 rissoles e diminuir 5
    E         Validar o preço total
    E         Clicar em finalizar compra
    E         Clicar no botão Fechar
    Entao     Fecha o Browser
    Exemplos:
      | Tipo_Browser |
      | chrome       |
      | firefox      |