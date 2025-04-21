package model;

public class Veiculo {
    private int id;
    private String modelo;
    private String fabricante;
    private String tipo;
    private String anoModelo;
    private String cor;
    private String numeroPortas;
    private String placa;
    private double valorDiaria;
    private boolean disponivel;

    public Veiculo(int id, String modelo, String fabricante, String tipo, String anoModelo, String cor, String numeroPortas, String placa, double valorDiaria) {
        this.id = id;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.tipo = tipo;
        this.anoModelo = anoModelo;
        this.cor = cor;
        this.numeroPortas = numeroPortas;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }
    
    public Veiculo() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(String numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
  
}
