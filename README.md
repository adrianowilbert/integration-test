# integration-teste-rest-assured
Projeto de teste de integração na linguagem Java utilizando a biblioteca Rest-assured
Este projeto de estudo utiliza a API REST ServeRest.

https://serverest.dev/

O ServeRest é uma API REST gratuita que simula uma loja virtual com intuito de servir de material de estudos de testes de API.

### Tecnologias e frameworks:

- [Java](https://www.java.com/pt_BR/)
- [JUnit 4](https://junit.org/junit4/)
- [Rest Assured](http://rest-assured.io/)
- [Lombok](https://projectlombok.org/)
- [Java Faker](https://github.com/DiUS/java-faker)
- [Allure Reports](https://docs.qameta.io/allure/)


### Suítes e ambientes

##### Ambientes:

Dentro do arquivo `application.yml` temos os ambientes mais conhecidos e utilizados nos processos de testes:

- DSV
- HML
- PRD

Para alterar o ambiente é necessário alterar somente o valor do ambiente dentro do arquivo. Por padrão está DSV.

Ex.: `ambiente: dsv` muda para HML `ambiente: hml`

##### Suítes

Por padrão o projeto possui 3 suites utilizáveis, podendo ser incrementado quantas necessárias.

- `ContractSuite` = Suíte que engloba todos os testes de contrato.
- `SmokeSuite` = Suíte para os testes rápidos e verificação do ambiente.
- `AllSuites` = Suíte para executar todos os testes.


### Exemplos de execução

##### All Suites:

- Terminal
`mvn clean verify -Dgroups=integraionTests.suites.AllSuites`

- Linha de comando de configuração
`clean verify -Dgroups=integraionTests.suites.AllSuites`

##### Contract Suites:

- Terminal
  `mvn clean verify -Dgroups=integraionTests.suites.ContractSuites`

- Linha de comando de configuração
  `clean verify -Dgroups=integraionTests.suites.AllSuites`


##### Smoke Suites:

- Terminal
  `mvn clean verify -Dgroups=integraionTests.suites.SmokeSuites`

- Linha de comando de configuração
  `clean verify -Dgroups=integraionTests.suites.SmokeSuites`
- 

### Implementação de uma classe e teste.

**Obrigatoriamente todo teste deve estender a BaseSetup** e conter as seguintes annotations:

- `@Feature` funcionalidade que está sendo desenvolvido este teste
- `@Story` descrição da funcionalidade e o nome, no qual vai para o relatório

Para cada teste implementado deve ser adicionado as `annotations` referente aquele teste.
Assim como o exemplo abaixo utilizamos:


- `@Test` para indicar que aquela classe é um teste.
- `@SneakyTrows` para tratamentos de erros de exceção.
- `@Severity` para indicar a severidade do teste.
- `@Category` deve apontar para a interface da Suíte que o teste deve estar.
- `@DisplayName` deve indicar o nome do teste.
- `@Description` deve indicar qual teste está em execução.


```java
@Feature("Nome do projeto")
@Story("Nome da story")
public class ExemploTest extends BaseTest {
    

    @Test
    @SneakyTrows
    @Severity(SeverityLevel.CRITICAL)
    @Category(Contracts.class)
    @DisplayName("Validar o contrato da listagem de posts")
    @Description("Deve validar o contrato Quando utilizado dados corretos")
    public void testExemplo() { ... }

}
```

### Relatórios

Para gerar o relatório na sua máquina, basta executar o comando:

- Terminal
  `mvn allure:serve`

- Linha de comando de configuração
  `allure:serve`

  
### Dúvida, criticas ou sugestões

Wilbert (adrianowilbert@gmail.com)
