


import org.junit.jupiter.api.Test;

import epbjc.psi.Carro;

import static org.junit.jupiter.api.Assertions.*;

public class carroTest {

    @Test
    void deveCriarCarro() {
        Carro carro = new Carro(
                "AA-11-BB",
                "Toyota",
                "Corolla",
                "Preto",
                2020,
                5
        );

        assertNotNull(carro);
        assertEquals("AA-11-BB", carro.getMatricula());
        assertEquals("Toyota", carro.getMarca());
        assertEquals("Corolla", carro.getModelo());
        assertEquals("Preto", carro.getCor());
        assertEquals(2020, carro.getAno());
        assertEquals(5, carro.getNumeroLugares());
    }

    @Test
    void deveTerQuatroRodas() {
        Carro carro = new Carro(
                "AA-11-BB", "Toyota", "Corolla",
                "Preto", 2020, 5
        );

        assertEquals(4, carro.getNumeroRodas());
    }

    @Test
    void deveComecarComZeroQuilometros() {
        Carro carro = new Carro(
                "AA-11-BB", "Toyota", "Corolla",
                "Preto", 2020, 5
        );

        assertEquals(0.0, carro.getQuilometros());
    }

    @Test
    void deveAlterarNumeroLugares() {
        Carro carro = new Carro(
                "AA-11-BB", "Toyota", "Corolla",
                "Preto", 2020, 5
        );

        carro.setNumeroLugares(7);

        assertEquals(7, carro.getNumeroLugares());
    }

    @Test
    void naoDeveAceitarNumeroLugaresInvalido() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Carro(
                        "AA-11-BB", "Toyota", "Corolla",
                        "Preto", 2020, 0
                )
        );
    }
}
