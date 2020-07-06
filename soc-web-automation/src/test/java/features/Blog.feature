#language: pt
Funcionalidade: Site SOC

  @CTBusca
  Esquema do Cenario: Realizar busca
    Dado que estou na pagina inicial do blog
    Quando eu pesquiso por '<elemento_busca>'
    Entao verifico que obtive resultado na busca por '<elemento_busca>'

    Exemplos:
      | elemento_busca |
      | SIPAT          |