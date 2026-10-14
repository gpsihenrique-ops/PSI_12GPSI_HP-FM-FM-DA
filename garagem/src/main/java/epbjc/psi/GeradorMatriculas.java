package epbjc.psi;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class  GeradorMatriculas {

    private static final Set<String> MATRICULAS_GERADAS = new HashSet<>();

    private GeradorMatriculas() {
    }

    public static String gerar(TipoVeiculo tipo) {

        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de veículo inválido");
        }

        String matricula;

        do {

            if (tipo == TipoVeiculo.BARCO) {
                matricula = gerarMatriculaBarco();
            } else {
                matricula = gerarMatriculaCarroOuMota();
            }

        } while (MATRICULAS_GERADAS.contains(matricula));

        MATRICULAS_GERADAS.add(matricula);

        return matricula;
    }

    public static String gerarMatriculaCarroOuMota() {

        char letra1 = gerarLetra();
        char letra2 = gerarLetra();

        int numero = ThreadLocalRandom.current().nextInt(0, 100);

        char letra3 = gerarLetra();
        char letra4 = gerarLetra();

        return String.format(
                "%c%c-%02d-%c%c",
                letra1,
                letra2,
                numero,
                letra3,
                letra4
        );
    }

    public static String gerarMatriculaBarco() {

        char letra1 = gerarLetra();
        char letra2 = gerarLetra();

        int numero = ThreadLocalRandom.current().nextInt(0, 10000);

        return String.format(
                "%c%c-%04d",
                letra1,
                letra2,
                numero
        );
    }

    private static char gerarLetra() {

        return (char) ThreadLocalRandom.current().nextInt(
                'A',
                'Z' + 1
        );
    }
}

