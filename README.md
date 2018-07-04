# CRUD pessoas físicas

## Tecnologias utilizadas

1. Linguagem Java
2. IDE Eclipse
3. Banco de dados MariaDB
4. Biblioteca JSON-simple

## Descrição

O projeto consiste de um programa em Java, no qual é possível cadastrar pessoas físicas, informando seus principais dados como nome, CPF, telefone, e-mail, CEP e numero da residência, a partir destes dados, o programa verifica se o CPF informa é um CPF valido, assim como obtém as informações de moradia da pessoa, a partir de uma [API publica](http://viacep.com.br/) a qual retorna em formato JSON estes dados a partir do CEP informado.
Na realização do cadastro, as informações da pessoa são salvos em um banco de dados, o qual foi utilizado o banco [MariaDB](https://mariadb.org), o programa também contem uma lista com todas pessoas cadastradas, lista esta que é possível se ordenar clicando-se no cabeçalho da coluna que se deseja utilizar como referência da ordenação, além de disponibilizar opções de filtro por CPF, CEP e UF. 
O programa também permite a edição e exclusão das pessoas cadastradas, realizando isto a partir da pessoa selecionada na lista disponível e uma exportação de todas a pessoas cadastradas para um arquivo de texto.

## Classes

O programa possui 4 classes sendo elas duas classes de controle, ambas finais com todos seu métodos públicos estáticos, uma para validação dos dados de entrada como CPF e CEP, e a outra para controlar toda a comunicação com o banco de dados e a exportação para o arquivo de texto, uma classe de modelo, classe está que serve para representar a pessoa a ser gerenciada e uma classe de interface, classe está feita utilizando a biblioteca do Swing disponível na JDK. Estas classe são:

- ValidacaoController
- DBancoController
- Pessoa
- GerenciaView