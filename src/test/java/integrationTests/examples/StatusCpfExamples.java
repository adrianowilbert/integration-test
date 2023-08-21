package integrationTests.examples;

import java.util.ArrayList;
import java.util.HashMap;

public class StatusCpfExamples {

        /*Classes de exemplo são mappers e listas com valores utilizados em um mesma
        execução de testes somente alterando os dados, fazendo que em um mesmo teste
        possa ser validado uma quantidade maior de dados e o seu retorno.
        */

    public static HashMap<String, Long> statusDeCpf() { //String + Long

        HashMap<String, Long> statusCpf = new HashMap<>();
        statusCpf.put("INVALIDO", 271748L);
        statusCpf.put("ROUBADO", 271751L);
        statusCpf.put("BLOQUEADO", 271753L);

        return statusCpf;
    }

    public static HashMap<Integer, String> idDoNome() { //Int + String

        HashMap<Integer, String> idNome = new HashMap<>();
        idNome.put(1, "JOHN WICK");
        idNome.put(2, "JOHN CONSTANTINE");
        idNome.put(3, "JOHN JOHN");

        return idNome;
    }

    public static ArrayList<Long> idDeCliente() { //Lista de long

        final ArrayList<Long> idDeCliente = new ArrayList<>();
        idDeCliente.add(123456L);
        idDeCliente.add(234567L);
        idDeCliente.add(345678L);

        return idDeCliente;
    }

}
