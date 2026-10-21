package epbjc.psi.API.TREE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import epbjc.psi.Model.Veiculo;

import java.util.AbstractMap;

public class No {

    private String valor;
    private List<Map.Entry<No, Double>> arestas;
    private ArrayList<Veiculo> veiculos;

    public No(String valor) {
        this.valor = valor;
        this.arestas = new ArrayList<>();
        this.veiculos = new ArrayList<>();
    }

    public String getValor() {
        return valor;
    }

    public List<Map.Entry<No, Double>> getArestas() {
        return arestas;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if(infVeiculos() != 1){
            if (veiculo != null) {
                veiculos.add(veiculo);
                System.out.println("Veiculo adicionado ao no: " + valor);
            }
        }
    }

    private int infVeiculos() {
        if (veiculos.size() >= 5) {
            System.out.println("No " + valor + " atingiu o limite de veiculos.");
            return 1;
        }
        return 0;
    }

    public void ligarA(No destino, double custo) {
        arestas.add(
            new AbstractMap.SimpleEntry<>(destino, custo)
        );
    }

    public void mostrar() {
        System.out.println("No: " + valor);

        // Mostrar arestas
        if (arestas.isEmpty()) {
            System.out.println("  Sem arestas de saida.");
        } else {
            for (Map.Entry<No, Double> aresta : arestas) {
                System.out.println(
                    "  Vai para: " + aresta.getKey().getValor()
                    + " | Custo: " + aresta.getValue()
                );
            }
        }

        // Mostrar veiculos
        if (veiculos.isEmpty()) {
            System.out.println("  Sem veiculos neste no.");
        } else {
            System.out.println("  Veiculos:");

            for (Veiculo veiculo : veiculos) {
                System.out.println("    " + veiculo);
            }
        }
    }
}
