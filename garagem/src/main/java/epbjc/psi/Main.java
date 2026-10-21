package epbjc.psi;

import epbjc.psi.Model.Barco;
import epbjc.psi.Model.Carro;
import epbjc.psi.Model.Garagem;
import epbjc.psi.Model.GaragemView;
import epbjc.psi.Model.Mota;
import epbjc.psi.Model.TipoVeiculo;

public class Main {

    public static void main(String[] args) {

        Garagem garagem = new Garagem(
                "Garagem Principal",
                5,
                TipoVeiculo.CARRO,
                TipoVeiculo.MOTA,
                TipoVeiculo.BARCO
        );

        Carro carro1 = new Carro(
                "AA-11-BB",
                "Toyota",
                "Corolla",
                "Preto",
                2020,
                5
        );

        Carro carro2 = new Carro(
                "CC-22-DD",
                "BMW",
                "Serie 3",
                "Branco",
                2021,
                5
        );

        Carro carro3 = new Carro(
                "EE-33-FF",
                "Audi",
                "A3",
                "Azul",
                2019,
                5
        );

        Carro carro4 = new Carro(
                "GG-44-HH",
                "Ford",
                "Focus",
                "Cinzento",
                2022,
                5
        );

        Carro carro5 = new Carro(
                "II-55-JJ",
                "Honda",
                "Civic",
                "Vermelho",
                2023,
                5
        );

        Mota mota = new Mota(
                "MM-11-NN",
                "Yamaha",
                "MT-07",
                "Preto",
                2022,
                689
        );

        Barco barco = new Barco(
                "BB-22-CC",
                "Beneteau",
                "Oceanis",
                "Branco",
                2021,
                10.5
        );

        GaragemView view = new GaragemView();

        garagem.entrar(carro1);
        garagem.entrar(carro2);
        garagem.entrar(carro3);
        garagem.entrar(carro4);
        garagem.entrar(carro5);

        view.mostrarGaragem(garagem);

        garagem.sair("EE-33-FF");

        System.out.println("Carro EE-33-FF removido com sucesso.");

        view.mostrarGaragem(garagem);

        garagem.entrar(mota);

        System.out.println("Mota adicionada com sucesso.");

        view.mostrarGaragem(garagem);

        try {
            garagem.entrar(barco);
            System.out.println("Barco adicionado com sucesso.");
        } catch (IllegalStateException e) {
            System.out.println("Barco: " + e.getMessage());
        }

        view.mostrarGaragem(garagem);
    }
}
