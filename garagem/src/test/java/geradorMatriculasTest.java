


import org.junit.jupiter.api.Test;

import epbjc.psi.Model.GeradorMatriculas;

import static org.junit.jupiter.api.Assertions.*;

public class geradorMatriculasTest {

    @Test
    void deveGerarMatriculaCarroValida() {
        String matricula = GeradorMatriculas.gerarMatriculaCarroOuMota();

        assertNotNull(matricula);

        assertTrue(
            matricula.matches("[A-Z]{2}-\\d{2}-[A-Z]{2}"),
            "Matrícula de carro inválida: " + matricula
        );

        assertFalse(matricula.isEmpty());
    }

    @Test
    void deveGerarMatriculaMotaValida() {
        String matricula = GeradorMatriculas.gerarMatriculaCarroOuMota();

        assertNotNull(matricula);

        assertTrue(
            matricula.matches("[A-Z]{2}-\\d{2}-[A-Z]{2}"),
            "Matrícula de mota inválida: " + matricula
        );

        assertFalse(matricula.isEmpty());
    }

    @Test
    void deveGerarMatriculaBarcoValida() {
        String matricula = GeradorMatriculas.gerarMatriculaBarco();

        assertNotNull(matricula);

        assertTrue(
            matricula.matches("[A-Z]{2}-\\d{4}"),
            "Matrícula de barco inválida: " + matricula
        );

        assertFalse(
            matricula.matches("[a-z]{2}-\\d{4}"),
            "A matrícula não deve conter letras minúsculas."
        );
    }

    @Test
    void deveGerarDuasMatriculasDeCarroOuMota() {
        String primeira = GeradorMatriculas.gerarMatriculaCarroOuMota();
        String segunda = GeradorMatriculas.gerarMatriculaCarroOuMota();

        assertNotNull(primeira);
        assertNotNull(segunda);

        assertTrue(primeira.matches("[A-Z]{2}-\\d{2}-[A-Z]{2}"));
        assertTrue(segunda.matches("[A-Z]{2}-\\d{2}-[A-Z]{2}"));
    }

    @Test
    void deveGerarDuasMatriculasDeBarco() {
        String primeira = GeradorMatriculas.gerarMatriculaBarco();
        String segunda = GeradorMatriculas.gerarMatriculaBarco();

        assertNotNull(primeira);
        assertNotNull(segunda);

        assertTrue(primeira.matches("[A-Z]{2}-\\d{4}"));
        assertTrue(segunda.matches("[A-Z]{2}-\\d{4}"));
    }
}
