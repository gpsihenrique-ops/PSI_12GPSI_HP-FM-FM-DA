package epbjc.psi.API.TREE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tree {

    private List<No> nos;

    public Tree() {
        nos = new ArrayList<>();
    }

    public void adicionarNo(No no) {
        if (!nos.contains(no)) {
            nos.add(no);
        }
    }

    public void ligar(No origem, No destino, double custo) {
        adicionarNo(origem);
        adicionarNo(destino);

        origem.ligarA(destino, custo);
    }

    public void mostrar() {
        System.out.println("ESTRUTURA DE NOS");

        for (No no : nos) {
            no.mostrar();
            System.out.println();
        }
    }

    private void procurarTodosOsCiclos(
            No atual,
            No inicio,
            List<No> caminho,
            Set<No> visitados,
            double custoAtual,
            int[] quantidadeCiclos) {

        for (Map.Entry<No, Double> aresta : atual.getArestas()) {

            No destino = aresta.getKey();
            double custo = aresta.getValue();

            if (destino == inicio && caminho.size() >= 3) {

                quantidadeCiclos[0]++;

                System.out.println("Ciclo " + quantidadeCiclos[0] + ":");
                System.out.print("Percurso: ");

                for (No no : caminho) {
                    System.out.print(no.getValor() + " -> ");
                }

                System.out.println(inicio.getValor());

                System.out.println("Custo total: "
                        + (custoAtual + custo));

                System.out.println("Numero de nos: "
                        + caminho.size());

                System.out.println("Forma: "
                        + identificarForma(caminho.size()));

                System.out.println();

            } else if (!visitados.contains(destino)) {

                caminho.add(destino);
                visitados.add(destino);

                procurarTodosOsCiclos(
                        destino,
                        inicio,
                        caminho,
                        visitados,
                        custoAtual + custo,
                        quantidadeCiclos
                );

                visitados.remove(destino);
                caminho.remove(caminho.size() - 1);
            }
        }
    }

    private String identificarForma(int quantidadeNos) {

        if (quantidadeNos == 3) {
            return "Triangulo";
        } else if (quantidadeNos == 4) {
            return "Quadrilatero";
        } else if (quantidadeNos > 4) {
            return "Outra forma fechada";
        } else {
            return "Forma nao identificada";
        }
    }

    public void listarCiclos(No inicio) {

        System.out.println("CICLOS ENCONTRADOS");

        if (inicio == null) {
            System.out.println("No inicial invalido.");
            return;
        }

        List<No> caminho = new ArrayList<>();
        Set<No> visitados = new HashSet<>();
        int[] quantidadeCiclos = {0};

        caminho.add(inicio);
        visitados.add(inicio);

        procurarTodosOsCiclos(
                inicio,
                inicio,
                caminho,
                visitados,
                0,
                quantidadeCiclos
        );

        if (quantidadeCiclos[0] == 0) {
            System.out.println("Nao foram encontrados ciclos.");
        } else {
            System.out.println("Total de ciclos: "
                    + quantidadeCiclos[0]);
        }
    }

    public static void main(String[] args) {

        Tree tree = new Tree();

        No a = new No("A");
        No b = new No("B");
        No c = new No("C");
        No d = new No("D");

        tree.ligar(a, b, 5);
        tree.ligar(a, d, 2);
        tree.ligar(b, c, 10);
        tree.ligar(c, a, 5);
        tree.ligar(d, c, 3);

        tree.mostrar();
        tree.listarCiclos(a);
    }
}