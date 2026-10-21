
package epbjc.psi.Model;

import java.time.Year;
import java.util.Objects;

public class Mota implements Veiculo {

    private static final int ANO_MINIMO = 1886;
    private static final String REGEX_MATRICULA =
            "^[A-Z]{2}-\\d{2}-[A-Z]{2}$";

    private final String matricula;
    private final int ano;

    private String marca;
    private String modelo;
    private String cor;
    private double quilometros;
    private int cilindrada;

    public Mota(String matricula, String marca, String modelo,
                String cor, int ano, int cilindrada) {

        this.matricula = validarMatricula(matricula);
        this.ano = validarAno(ano);
        this.marca = validarTexto(marca, "Marca");
        this.modelo = validarTexto(modelo, "Modelo");
        this.cor = validarTexto(cor, "Cor");

        validarCilindrada(cilindrada);
        this.cilindrada = cilindrada;
        this.quilometros = 0;
    }

    private static String validarMatricula(String matricula) {
        if (matricula == null) {
            throw new IllegalArgumentException("Matrícula inválida");
        }

        String normalizada = matricula.trim().toUpperCase();

        if (!normalizada.matches(REGEX_MATRICULA)) {
            throw new IllegalArgumentException("Matrícula inválida");
        }

        return normalizada;
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " inválida");
        }

        return valor.trim();
    }

    private static int validarAno(int ano) {
        int anoAtual = Year.now().getValue();

        if (ano < ANO_MINIMO || ano > anoAtual + 1) {
            throw new IllegalArgumentException("Ano inválido");
        }

        return ano;
    }

    private static void validarCilindrada(int cilindrada) {
        if (cilindrada <= 0) {
            throw new IllegalArgumentException("Cilindrada inválida");
        }
    }

    @Override
    public TipoVeiculo getTipo() {
        return TipoVeiculo.MOTA;
    }

    @Override
    public String getMatricula() {
        return matricula;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public String getCor() {
        return cor;
    }

    @Override
    public int getAno() {
        return ano;
    }

    @Override
    public double getQuilometros() {
        return quilometros;
    }

    @Override
    public int getNumeroRodas() {
        return 2;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setMarca(String marca) {
        this.marca = validarTexto(marca, "Marca");
    }

    public void setModelo(String modelo) {
        this.modelo = validarTexto(modelo, "Modelo");
    }

    public void setCor(String cor) {
        this.cor = validarTexto(cor, "Cor");
    }

    public void setCilindrada(int cilindrada) {
        validarCilindrada(cilindrada);
        this.cilindrada = cilindrada;
    }

    public void setQuilometros(double quilometros) {
        if (!Double.isFinite(quilometros)
                || quilometros < 0
                || quilometros < this.quilometros) {
            throw new IllegalArgumentException("Quilómetros inválidos");
        }

        this.quilometros = quilometros;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Veiculo)) {
            return false;
        }

        Veiculo outro = (Veiculo) obj;

        return getTipo() == outro.getTipo()
                && matricula.equals(outro.getMatricula());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipo(), matricula);
    }

    @Override
    public String toString() {
        return getTipo() + " " + matricula + " "
                + marca + " " + modelo + " (" + ano + ")";
    }
}
