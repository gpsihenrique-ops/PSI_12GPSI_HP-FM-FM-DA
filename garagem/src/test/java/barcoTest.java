


import org.junit.jupiter.api.Test;

import epbjc.psi.Model.Barco;
import epbjc.psi.Model.TipoVeiculo;

import static org.junit.jupiter.api.Assertions.*;

public class barcoTest {

    @Test
    void deveCriarBarco() {
        Barco barco = new Barco(
                "lx-12345",
                "Beneteau",
                "Oceanis",
                "Branco",
                2021,
                10.5
        );

        assertEquals("LX-12345", barco.getMatricula());
        assertEquals("Beneteau", barco.getMarca());
        assertEquals("Oceanis", barco.getModelo());
        assertEquals("Branco", barco.getCor());
        assertEquals(2021, barco.getAno());
        assertEquals(10.5, barco.getComprimento());
    }

    @Test
    void deveComecarComZeroQuilometros() {
        Barco barco = new Barco(
                "lx-12345",
                "Beneteau",
                "Oceanis",
                "Branco",
                2021,
                10.5
        );

        assertEquals(0.0, barco.getQuilometros());
    }

    @Test
    void deveTerZeroRodas() {
        Barco barco = new Barco(
                "lx-12345",
                "Beneteau",
                "Oceanis",
                "Branco",
                2021,
                10.5
        );

        assertEquals(0, barco.getNumeroRodas());
    }

    @Test
    void deveTerTipoBarco() {
        Barco barco = new Barco(
                "lx-12345",
                "Beneteau",
                "Oceanis",
                "Branco",
                2021,
                10.5
        );

        assertEquals(TipoVeiculo.BARCO, barco.getTipo());
    }

    @Test
    void deveGuardarComprimentoCorretamente() {
        Barco barco = new Barco(
                "lx-12345",
                "Beneteau",
                "Oceanis",
                "Branco",
                2021,
                10.5
        );

        assertEquals(10.5, barco.getComprimento());
    }
}
