# Desafio de Projeto - Hospital <img align="center" height="30" width="40" src="https://ada-site-frontend.s3.sa-east-1.amazonaws.com/home/header-logo.svg" />

### Principais Informações
A ideia deste projeto é desenvolvedor um projeto que simule uma Locadora de Veículos na linguagem Java utilizando os conceitos e fundamentos aprendidos no curso. Aplicando principalmente os conceitos de _Interface_ e _SOLID_.

> _Este é um desafio de projeto desenvolvido durante o Curso da **ADA** no programa Polo Tech | Back-End durante a trilha POO-II_

### Entendendo o Desafio

Criar uma aplicação que gerencie o aluguel de veículos, onde cada item abaixo seja considerado com suas respectivas classes e regrnas de negócio.

#### Itens obrigatórios
* Cadastrar os veículos;
* Alterar um veículo cadastrado;
* Buscar um veículo por parte do nome;
* Cadastrar o cliente (pessoa física e jurídica)
* Alterar o cliente (pessoa física e jurídica)
* Alugar um veículo para pessoa física e jurídica;
* Devolver um veículo para pessoa física e jurídica;

#### Regras de negócio
* RN1: Os veículos não podem ser repetidos; Pode utilizar a placa como identificador de unicidade;
* RN2: Tipos de veículos que serão considerados: Carro, Moto, Caminhões;
* RN3: Os aluguéis e devoluções terão o local, data e horário;
* RN4: Considere aluguel em horas quebradas como uma diária completa. Exemplo: uma devolução de um veículo alugado no dia 25 de janeiro às 15h30 será cobrado uma (1) diária até dia 26 de janeiro às 15h30, a partir desse horário já serão cobradas duas (2) diárias e assim por diante.
* RN5: Os veículos que estiverem alugados não poderão estar disponíveis;
* RN6: Clientes não podem estar duplicados; Considerar CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade;
* RN7: Regras de devolução:
  * Caso o cliente pessoa física tenha ficado com o carro mais que 5 diárias terá direito a 5% de desconto.
  * Caso o cliente pessoa jurídica tenha ficado com o carro mais que 3 diárias terá direito a 10% de desconto.


### Linguagens e Ferramentas Utilizadas

- `VSCode`
- `Java`
- `GitHub`