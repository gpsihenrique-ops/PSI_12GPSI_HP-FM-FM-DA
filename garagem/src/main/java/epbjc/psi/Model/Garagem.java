package epbjc.psi.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Garagem {

    private String nome;
    private int capacidade;
    private final TipoVeiculo[] tiposPermitidos;
    private final List<Veiculo> veiculos;

    public Garagem(String nome, int capacidade, TipoVeiculo... tipos) {

        this.nome = validarNome(nome);
        validarCapacidade(capacidade);

        if (tipos == null || tipos.length == 0) {
            throw new IllegalArgumentException(
                    "É necessário indicar pelo menos um tipo"
            );
        }

        for (TipoVeiculo tipo : tipos) {
            if (tipo == null) {
                throw new IllegalArgumentException(
                        "Tipo de veículo inválido"
                );
            }
        }

        this.capacidade = capacidade;
        this.tiposPermitidos = Arrays.copyOf(tipos, tipos.length);
        this.veiculos = new ArrayList<>();
    }

    private static String validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        return nome.trim();
    }

    private static void validarCapacidade(int capacidade) {
        if (capacidade < 1 || capacidade > 100) {
            throw new IllegalArgumentException("Capacidade inválida");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public TipoVeiculo[] getTiposPermitidos() {
        return Arrays.copyOf(
                tiposPermitidos,
                tiposPermitidos.length
        );
    }

    public List<Veiculo> getVeiculos() {
        return new ArrayList<>(veiculos);
    }

    public int getOcupacao() {
        return veiculos.size();
    }

    public int getLugaresLivres() {
        return capacidade - veiculos.size();
    }

    public void setNome(String nome) {
        this.nome = validarNome(nome);
    }

    public void setCapacidade(int capacidade) {
        validarCapacidade(capacidade);

        if (capacidade < getOcupacao()) {
            throw new IllegalStateException(
                    "A capacidade não pode ser inferior à ocupação atual"
            );
        }

        this.capacidade = capacidade;
    }

    public boolean isCheia() {
        return getOcupacao() == capacidade;
    }

    public boolean isVazia() {
        return veiculos.isEmpty();
    }

    public boolean aceitaTipo(TipoVeiculo tipo) {
        if (tipo == null) {
            return false;
        }

        for (TipoVeiculo tipoPermitido : tiposPermitidos) {
            if (tipoPermitido == tipo) {
                return true;
            }
        }

        return false;
    }

    public int contarPorTipo(TipoVeiculo tipo) {
        if (tipo == null) {
            return 0;
        }

        int contador = 0;

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getTipo() == tipo) {
                contador++;
            }
        }

        return contador;
    }

    public boolean contem(String matricula) {
        if (matricula == null || matricula.trim().isEmpty()) {
            return false;
        }

        String matriculaNormalizada =
                matricula.trim().toUpperCase();

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getMatricula().equals(matriculaNormalizada)) {
                return true;
            }
        }

        return false;
    }

    public boolean podeEntrar(Veiculo veiculo) {
        if (veiculo == null) {
            return false;
        }

        if (isCheia()) {
            return false;
        }

        if (!aceitaTipo(veiculo.getTipo())) {
            return false;
        }

        return !contem(veiculo.getMatricula());
    }

    public void entrar(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("Veículo inválido");
        }

        if (!aceitaTipo(veiculo.getTipo())) {
            throw new IllegalArgumentException(
                    "Tipo de veículo não permitido"
            );
        }

        if (isCheia()) {
            throw new IllegalStateException(
                    "A garagem está cheia"
            );
        }

        if (contem(veiculo.getMatricula())) {
            throw new IllegalStateException(
                    "Já existe um veículo com essa matrícula"
            );
        }

        veiculos.add(veiculo);
    }

    public Veiculo sair(String matricula) {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Matrícula inválida"
            );
        }

        String matriculaNormalizada =
                matricula.trim().toUpperCase();

        for (int i = 0; i < veiculos.size(); i++) {

            Veiculo veiculo = veiculos.get(i);

            if (veiculo.getMatricula().equals(matriculaNormalizada)) {
                return veiculos.remove(i);
            }
        }

        throw new IllegalArgumentException(
                "Não existe nenhum veículo com essa matrícula"
        );
    }
}