# new feature
# Tags: 4All
# language: pt

Funcionalidade:
  Eu, enquanto candito a vaga de QA da 4All
  Preciso automatizar o teste proposto para vaga
  Para garantir aprovação no processo seletivo.
  https://www.youtube.com/watch?v=5eezIEYqfCo&list=PL6tu16kXT9PpteusHGISu_lHcV6MbBtA6&index=3

    @4all
    Esquema do Cenario: Desafio 1
    Dado      que configurei ambiente para acessar URL <Tipo_Browser>
    Quando    abri tela do simulador de investimento
    Entao     Retorna a tela com resultado
    Exemplos:
    | Tipo_Browser |
    | chrome       |

    @4all
    Cenario: Desafio 2
    Dado      configurei ambiente para acessar URL Chrome
    Quando    abri tela do simulador de investimento
    Entao     Retorna a tela com resultado
