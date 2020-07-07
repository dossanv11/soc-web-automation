#language: pt
  Funcionalidade: Tela FAP

    @CTFormFAP
    Esquema do Cenario: Preencher Formulario FAP
      Dado que estou na tela de FAP
      Quando direciono para o formulario
      Entao preencho as informacoes '<empresa>', '<fap>', '<rat>' e '<massa_salarial>'

      Exemplos:
      |empresa|fap|rat|massa_salarial|
      |soc    |8  |2  |50000         |
