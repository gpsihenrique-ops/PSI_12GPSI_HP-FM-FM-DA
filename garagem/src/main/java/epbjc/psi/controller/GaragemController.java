package epbjc.psi.controller;

import epbjc.psi.Model.Barco;
import epbjc.psi.Model.Carro;
import epbjc.psi.Model.Garagem;
import epbjc.psi.Model.GeradorMatriculas;
import epbjc.psi.Model.Mota;
import epbjc.psi.Model.TipoVeiculo;
import epbjc.psi.Model.Veiculo;

public class GaragemController {

    private final Garagem garagem;

    public GaragemController(Garagem garagem) {

        if (garagem == null) {
            throw new IllegalArgumentException("Garagem inválida");
        }

        this.garagem = garagem;
    }

    public Garagem getGaragem() {
        return garagem;
    }

    public Carro criarCarro(
            String marca,
            String modelo,
            String cor,
            int ano,
            int numeroPortas) {

        String matricula =
                GeradorMatriculas.gerar(TipoVeiculo.CARRO);

        return new Carro(
                matricula,
                marca,
                modelo,
                cor,
                ano,
                numeroPortas
        );
    }

    public Mota criarMota(
            String marca,
            String modelo,
            String cor,
            int ano,
            int cilindrada) {

        String matricula =
                GeradorMatriculas.gerar(TipoVeiculo.MOTA);

        return new Mota(
                matricula,
                marca,
                modelo,
                cor,
                ano,
                cilindrada
        );
    }

    public Barco criarBarco(
            String marca,
            String modelo,
            String cor,
            int ano,
            double comprimento) {

        String matricula =
                GeradorMatriculas.gerar(TipoVeiculo.BARCO);

        return new Barco(
                matricula,
                marca,
                modelo,
                cor,
                ano,
                comprimento
        );
    }

    public void adicionar(Veiculo veiculo) {
        garagem.entrar(veiculo);
    }

    public Veiculo remover(String matricula) {
        return garagem.sair(matricula);
    }
}

