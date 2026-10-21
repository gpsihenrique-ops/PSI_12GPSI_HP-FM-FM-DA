


import org.junit.jupiter.api.Test;

import epbjc.psi.Model.TipoVeiculo;

import static org.junit.jupiter.api.Assertions.*;

public class TipoVeiculoTest {

    @Test
    void deveExistirTipoCarro() {
        assertNotNull(TipoVeiculo.CARRO);
    }

    @Test
    void deveExistirTipoMota() {
        assertNotNull(TipoVeiculo.MOTA);
    }

    @Test
    void deveExistirTipoBarco() {
        assertNotNull(TipoVeiculo.BARCO);
    }

    @Test
    void deveTerTresTiposDeVeiculo() {
        assertEquals(3, TipoVeiculo.values().length);
    }

    @Test
    void deveConverterTipoParaString() {
        assertEquals("CARRO", TipoVeiculo.CARRO.name());
        assertEquals("MOTA", TipoVeiculo.MOTA.name());
        assertEquals("BARCO", TipoVeiculo.BARCO.name());
    }
}
