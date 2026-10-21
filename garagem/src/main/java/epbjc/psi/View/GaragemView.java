
package epbjc.psi.view;

import java.util.Scanner;

public class GaragemView {

    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n==============================");
        System.out.println("       SISTEMA DE GARAGEM");
        System.out.println("==============================");
        System.out.println("1 - Gerir carros");
        System.out.println("2 - Gerir motas");
        System.out.println("3 - Gerir barcos");
        System.out.println("4 - Consultar veículos");
        System.out.println("0 - Sair");
        System.out.println("==============================");
        System.out.print("Escolha uma opção: ");
    }

    public int lerOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Opção inválida!");
            scanner.next();
            System.out.print("Escolha uma opção: ");
        }

        return scanner.nextInt();
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
