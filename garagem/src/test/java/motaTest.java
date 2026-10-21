


import org.junit.jupiter.api.Test;

import epbjc.psi.Model.Mota;

import static org.junit.jupiter.api.Assertions.*;

public class motaTest {

    @Test
    void deveCriarMota() {
        Mota mota = new Mota(
                "MM-11-NN",
                "Yamaha",
                "MT-07",
                "Preto",
                2022,
                689
        );

        assertNotNull(mota);
        assertEquals("MM-11-NN", mota.getMatricula());
        assertEquals("Yamaha", mota.getMarca());
        assertEquals("MT-07", mota.getModelo());
        assertEquals("Preto", mota.getCor());
        assertEquals(2022, mota.getAno());
        assertEquals(689, mota.getCilindrada());
    }

    @Test
    void deveTerDuasRodas() {
        Mota mota = new Mota(
                "MM-11-NN",
                "Yamaha",
                "MT-07",
                "Preto",
                2022,
                689
        );

        assertEquals(2, mota.getNumeroRodas());
    }

    @Test
    void deveComecarComZeroQuilometros() {
        Mota mota = new Mota(
                "MM-11-NN",
                "Yamaha",
                "MT-07",
                "Preto",
                2022,
                689
        );

        assertEquals(0.0, mota.getQuilometros());
    }

    @Test
    void deveAlterarCilindrada() {
        Mota mota = new Mota(
                "MM-11-NN",
                "Yamaha",
                "MT-07",
                "Preto",
                2022,
                689
        );

        mota.setCilindrada(700);

        assertEquals(700, mota.getCilindrada());
    }

    @Test
    void naoDeveAceitarCilindradaInvalida() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Mota(
                        "MM-11-NN",
                        "Yamaha",
                        "MT-07",
                        "Preto",
                        2022,
                        0
                )
        );
    }
}
