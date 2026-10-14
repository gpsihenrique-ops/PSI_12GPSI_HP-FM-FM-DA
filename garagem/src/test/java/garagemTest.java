
import org.junit.jupiter.api.Test;

import epbjc.psi.Barco;
import epbjc.psi.Carro;
import epbjc.psi.Garagem;
import epbjc.psi.Mota;
import epbjc.psi.Veiculo;
import epbjc.psi.TipoVeiculo;


import static org.junit.jupiter.api.Assertions.*;

public class garagemTest {

    @Test
    void deveAdicionarCarro() {
        Garagem garagem = new Garagem(
                "Garagem Principal", 5, TipoVeiculo.CARRO
        );
        Carro carro = new Carro(
                "AA-11-BB", "Toyota", "Corolla", "Preto", 2020, 5
        );

        garagem.entrar(carro);

        assertEquals(1, garagem.getOcupacao());
        assertTrue(garagem.contem("AA-11-BB"));
    }

    @Test
    void deveRemoverCarro() {
        Garagem garagem = new Garagem(
                "Garagem Principal", 5, TipoVeiculo.CARRO
        );
        Carro carro = new Carro(
                "AA-11-BB", "Toyota", "Corolla", "Preto", 2020, 5
        );

        garagem.entrar(carro);
        Veiculo removido = garagem.sair("AA-11-BB");

        assertEquals(carro, removido);
        assertEquals(0, garagem.getOcupacao());
        assertFalse(garagem.contem("AA-11-BB"));
    }

    @Test
    void naoDevePermitirMaisDeCincoVeiculos() {
        Garagem garagem = new Garagem(
                "Garagem Principal", 5, TipoVeiculo.CARRO
        );

        garagem.entrar(new Carro(
                "AA-11-BB", "Toyota", "Corolla", "Preto", 2020, 5
        ));
        garagem.entrar(new Carro(
                "CC-22-DD", "BMW", "Serie 3", "Branco", 2021, 5
        ));
        garagem.entrar(new Carro(
                "EE-33-FF", "Audi", "A3", "Azul", 2019, 5
        ));
        garagem.entrar(new Carro(
                "GG-44-HH", "Ford", "Focus", "Cinzento", 2022, 5
        ));
        garagem.entrar(new Carro(
                "II-55-JJ", "Honda", "Civic", "Vermelho", 2023, 5
        ));

        Carro sextoCarro = new Carro(
                "KK-66-LL", "Mercedes", "Classe A", "Preto", 2024, 5
        );

        assertThrows(
                IllegalStateException.class,
                () -> garagem.entrar(sextoCarro)
        );
    }

    @Test
    void naoDevePermitirMotaQuandoSoAceitaCarros() {
        Garagem garagem = new Garagem(
                "Garagem Principal", 5, TipoVeiculo.CARRO
        );
        Mota mota = new Mota(
                "MM-11-NN", "Yamaha", "MT-07", "Preto", 2022, 689
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> garagem.entrar(mota)
        );
    }

    @Test
    void naoDevePermitirBarcoQuandoSoAceitaCarros() {
        Garagem garagem = new Garagem(
                "Garagem Principal", 5, TipoVeiculo.CARRO
        );
        Barco barco = new Barco(
                "BB-22-CC", "Beneteau", "Oceanis", "Branco", 2021, 10.5
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> garagem.entrar(barco)
        );
    }

    @Test
    void devePermitirCarroMotaEBarco() {
        Garagem garagem = new Garagem(
                "Garagem Principal",
                5,
                TipoVeiculo.CARRO,
                TipoVeiculo.MOTA,
                TipoVeiculo.BARCO
        );

        Carro carro = new Carro(
                "AA-11-BB", "Toyota", "Corolla", "Preto", 2020, 5
        );
        Mota mota = new Mota(
                "MM-11-NN", "Yamaha", "MT-07", "Preto", 2022, 689
        );
        Barco barco = new Barco(
                "BB-22-CC", "Beneteau", "Oceanis", "Branco", 2021, 10.5
        );

        garagem.entrar(carro);
        garagem.entrar(mota);
        garagem.entrar(barco);

        assertEquals(3, garagem.getOcupacao());
        assertTrue(garagem.contem("AA-11-BB"));
        assertTrue(garagem.contem("MM-11-NN"));
        assertTrue(garagem.contem("BB-22-CC"));
    }

    @Test
    void naoDevePermitirMatriculaDuplicada() {
        Garagem garagem = new Garagem(
                "Garagem Principal", 5, TipoVeiculo.CARRO
        );

        Carro carro1 = new Carro(
                "AA-11-BB", "Toyota", "Corolla", "Preto", 2020, 5
        );
        Carro carro2 = new Carro(
                "AA-11-BB", "BMW", "Serie 3", "Branco", 2021, 5
        );

        garagem.entrar(carro1);

        assertThrows(
                IllegalStateException.class,
                () -> garagem.entrar(carro2)
        );
    }
}
