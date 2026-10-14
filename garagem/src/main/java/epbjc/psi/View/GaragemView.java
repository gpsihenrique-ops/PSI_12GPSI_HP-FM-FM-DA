package epbjc.psi.View;

import epbjc.psi.Garagem;
import epbjc.psi.Veiculo;

public class GaragemView {

    public void mostrarGaragem(Garagem garagem) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("              GARAGEM");
        System.out.println("========================================");

        System.out.println("Nome: " + garagem.getNome());
        System.out.println("Ocupação: " + garagem.getOcupacao()
                + "/" + garagem.getCapacidade());
        System.out.println("Lugares livres: " + garagem.getLugaresLivres());

        System.out.println("----------------------------------------");

        if (garagem.isVazia()) {
            System.out.println("A garagem está vazia.");
        } else {

            int numero = 1;

            for (Veiculo veiculo : garagem.getVeiculos()) {

                System.out.println(
                        numero + ". "
                        + veiculo.getTipo()
                        + " | Matrícula: "
                        + veiculo.getMatricula()
                        + " | "
                        + veiculo.getMarca()
                        + " " + veiculo.getModelo()
                        + " | Ano: " + veiculo.getAno()
                );

                numero++;
            }
        }

        System.out.println("========================================");
        System.out.println();
    }
}