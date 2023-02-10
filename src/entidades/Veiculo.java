package entidades;

import java.time.LocalDateTime;

import enums.TipoVeiculo;

public class Veiculo {
    private String marca;
    private String modelo;
    private String placa;
    private Boolean disponivel;
    private LocalDateTime diaAlugado;
    private LocalDateTime diaDevolucao;
    private TipoVeiculo tipoVeiculo;

    public Veiculo(String marca, String modelo, String placa, TipoVeiculo tipoVeiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.disponivel = true;
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDateTime getDiaAlugado() {
        return diaAlugado;
    }

    public void setDiaAlugado(LocalDateTime diaAlugado) {
        this.diaAlugado = diaAlugado;
    }

    public LocalDateTime getDiaDevolucao() {
        return diaDevolucao;
    }

    public void setDiaDevolucao(LocalDateTime diaDevolucao) {
        this.diaDevolucao = diaDevolucao;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Marca: " + marca
               + " | Modelo: " + modelo
               + " | Placa: " + placa
               + " | Tipo" + tipoVeiculo.toString();
    }
}
