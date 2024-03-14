# ADA LocateCar - Locadora de veículos

`Santander Coders - ADA Tech`

`Projeto final do módulo de POO-II`

## Integrantes

- Davison Cavalcante Barros;
- Pedro Medeiros das Chagas;

## Professor Orientador

- Igor Mascarenhas;

## Objetivo do projeto

Criar uma aplicação que gerencie o aluguel de veículos, aplicando os conceitos vistos em aula.

## Requisitos Funcionais

- RF-01: Os veículos não podem ser repetidos; Pode utilizar a placa como identificador de unicidade;
- RF-02: Tipos de veículos que serão considerados: PEQUENO, MEDIO e SUV;
- RF-03: Os aluguéis e devoluções terão o local, data e horário;
- RF-04: Considere aluguel em horas quebradas como uma diária completa.
- RF-05: Os veículos que estiverem alugados não poderão estar disponíveis;
- RF-06: Clientes não podem estar duplicados; Considerar CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade;
- RF-07: Caso o cliente pessoa física tenha ficado com o carro mais que 5 diárias terá direito a 5% de desconto;
- RF-08: Caso o cliente pessoa jurídica tenha ficado com o carro mais que 3 diárias terá direito a 10% de desconto;
- RF-09: Os valores de aluguel devem ser: SUV: 200, MEDIO: 150, PEQUENO: 100.

## Estrutura dos pacotes:

```
_src
 |__main
 |  |__java
 |     |__com
 |        |__ada_locate
 |           |__controller
 |               |__ClientController.java
 |               |__VehicleController.java
 |               |__RentController.java
 |           |__infra
 |               |__DAO.java
 |               |__RentDAO.java
 |               |__RentItensDAO.java
 |               |__VehicleDAO.java
 |           |__model
 |               |__enums
 |                   |__VehicleType.java
 |               |__interfaces
 |                   |__ClientIdentificator.java
 |               |__response
 |                   |__RentInfo.java
 |               |__Client.java
 |               |__LegalPerson.java
 |               |__NaturalPerson.java
 |               |__Rent.java
 |               |__RentItens.java
 |               |__Vehicle.java
 |           |__service
 |               |__ClientService.java
 |               |__RentService.java
 |               |__VehicleService.java
 |           |__utils
 |               |__DocumentUtils.java
 |               |__LicencePlateUtils.java
 |           |__view
 |               |__ClientView
 |                   |__ClientOptions.java
 |               |__GeneralView
 |                   |__MenuPrincipal.java
 |                   |__TypeOptions.java
 |               |__RentView
 |                   |__RentOptions.java
 |               |__VeiculoView
 |                   |__VehicleOptions.java
 |           |__App.java
 |  |__resources
 |    |__persistence.xml
_target
_pom.xml
-.gitignore
```
1. com.ada_locate.controller:

- ClientController.java: Controlador para operações relacionadas a clientes.
- VehicleController.java: Controlador para operações relacionadas a veículos.
- RentController.java: Controlador para operações relacionadas a aluguel.

2. com.ada_locate.infra:

- DAO.java: Interface base para classes de acesso a dados.
- RentDAO.java: Implementação específica para operações relacionadas a aluguel.
- RentItensDAO.java: Implementação específica para operações relacionadas a itens de aluguel.
- VehicleDAO.java: Implementação específica para operações relacionadas a veículos.

3. com.ada_locate.model:

3.1 enums:

- VehicleType.java: Enumeração para tipos de veículos.
  
3.2 interfaces:

- ClientIdentificator.java: Interface para identificação de clientes.
  
3.3 response:
  
- RentInfo.java: Classe para informações de aluguel.
  
3.4 modelos:
  
- Client.java: Classe para representar clientes.
- LegalPerson.java: Classe para representar pessoas jurídicas.
- NaturalPerson.java: Classe para representar pessoas físicas.
- Rent.java: Classe para representar aluguéis.
- RentItens.java: Classe para representar itens de aluguel.
- Vehicle.java: Classe para representar veículos.

4. com.ada_locate.service:

- ClientService.java: Serviço para lógica de negócios relacionada a clientes.
- RentService.java: Serviço para lógica de negócios relacionada a aluguel.
- VehicleService.java: Serviço para lógica de negócios relacionada a veículos.

5. com.ada_locate.utils:

- DocumentUtils.java: Utilitário para manipulação de documentos.
- LicencePlateUtils.java: Utilitário para manipulação de placas de veículos.

6. com.ada_locate.view:

6.1 ClientView:

- ClientOptions.java: Opções relacionadas a clientes.
  
6.2 GeneralView:

- MenuPrincipal.java: Menu principal da aplicação.
- TypeOptions.java: Opções de tipos gerais.
  
6.3 RentView:

- RentOptions.java: Opções relacionadas a aluguel.
  
6.4 VeiculoView:

- VehicleOptions.java: Opções relacionadas a veículos.

App.java: Classe principal que inicia a aplicação.

## Conceitos

O projeto em questão demonstra a aplicação de conceitos avançados em programação orientada a objetos em Java, utilizando principalmente interfaces e generics. Esses elementos são essenciais para promover reutilização de código, flexibilidade e uma estrutura mais robusta.

