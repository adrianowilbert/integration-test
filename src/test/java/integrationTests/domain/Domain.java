package integrationTests.domain;

public interface Domain {

    /* Interfaces de domain servem para inserir valores que se repetem em várias classes,
    como mensagens de erro em testes de excessão, massa de dados default, status code
    padronizados ou tipos de erro.
    */

    //mensagens de erro
    String MSG_ERRO_CPF = "CPF inválido ou não encontrado";
    String MSG_ERRO_NOME = "Nome cliente inválido ou não encontrado";

    //Massa de dados
    Long CPF_INVALIDO = 12345678901L;
    Long CPF_PADRAO = 61554726107L;

    //Tipos de erro
    String NOT_FOUND = "NOT_FOUND";
    String VALIDATION = "VALIDATION";

    //Status Code
    Integer _200_OK = 200;
    Integer _204_NO_CONTENT = 204;
    Integer _400_BAD_REQUEST = 400;
    Integer _404_NOT_FOUND = 404;

}



