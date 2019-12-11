#language: pt

Funcionalidade: Compra
    
  @BRQ
  Cenario: Fluxo de Compra
  Dado que acesse o link "http://automationpractice.com/index.php?"
  Dado que eu execute o cenario "Cenario de Fluxo de Compra"
  E Ambiente "Producao"
  E Funcionalidade "Compra de Produto"
  Dado que eu escolha o tipo de roupa produto para comprar e Categoria da roupa
  Entao deve ser demonstrado os produtos da categoria selecionada
  Quando eu escolher o produto desejado
  Entao deve ser demonstrado o Modal para CheckOut
  Dado que eu click no botao Proceed to checkout
  Entao deve ser demonstrado o sumario da compra
  Dado que eu click no botao Proceed to checkout sumario
  Entao deve ser demonstrado o campo para criacao de conta
  Dado que eu preencha o campo Email com "teste@provabrq11.com.br"
  Quando eu click no botao Create an account
  Entao deve ser demonstrado os demais campos para preenchimento
  Dado que eu selecione Tittle com "Mr."
  Dado que eu preencha o campo FirstName com "NomeTesteum"
  Dado que eu preencha o campo LastName com "NomeTestedois"
  Dado que eu preencha o campo senha com "123456"
  Dado que eu preencha o campo FirstName Adress com "AdressTesteum"
  Dado que eu preencha o campo LastName Adress com "AdressTestedois"
  Dado que eu preencha o campo Adress com "Rua do Teste"
  Dado que eu preencha o campo City com "Osasco"
  Dado que eu selecione no campo State a opcao "Alaska"
  Dado que eu prencha o campo Zip com "06160"
  Dado que eu selecione no campo Country a opcao "Estados Unidos"
  Dado que eu preencha o campo MobilePhone com "11-97684-6215"
  Dado que eu preencha Assign an Adress com "OutroEndereco"
  Quando eu clicar no botao Register
  Entao deve ser demonstrado a tela de confirmacao de entrega
  Entao valido se o endereco esta correto
  Dado que eu preencha o campo Comentario sobre o pedido com "ComentarioTeste"
  Quando eu clicar no botao Proceed to checkout
  Dado que eu click em  Aceite o termo
  Quando eu clicar no botao Proceed to checkout
  Entao deve ser demonstrado o valor da compra
  Dado que eu selecione o metodo de pagamento "Cheque"
  Entao deve ser demonstrado a confirmacao do pedido
  Dado que eu confirme meu pedido
  Entao valido se o pedido foi confirmado
  Entao deve ser salvo o pdf de evidencia  
  
  
  
  
  