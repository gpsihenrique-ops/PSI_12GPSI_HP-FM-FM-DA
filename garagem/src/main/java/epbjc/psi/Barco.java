package epbjc.psi;

public class Barco implements Veiculo {

    private final String matricula;
    private final String marca;
    private final String modelo;
    private final String cor;
    private final int ano;
    private final double comprimento;
    private double quilometros;

    public Barco(
            String matricula,
            String marca,
            String modelo,
            String cor,
            int ano,
            double comprimento) {

        this.matricula = matricula.trim().toUpperCase();
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.comprimento = comprimento;
        this.quilometros = 0;
    }

    @Override
    public TipoVeiculo getTipo() {
        return TipoVeiculo.BARCO;
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
    public int getAno() {
        return ano;
    }

    @Override
    public String getCor() {
        return cor;
    }

    @Override
    public double getQuilometros() {
        return quilometros;
    }

    @Override
    public int getNumeroRodas() {
        return 0;
    }

    public double getComprimento() {
        return comprimento;
    }
}

