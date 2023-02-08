package entidades;

import java.time.Duration;
import java.time.LocalDateTime;

import enums.TipoVeiculo;

public class Veiculo {
    private String placa;
    private Boolean disponivel;
    private LocalDateTime diaAlugado;
    private LocalDateTime diaDevolucao;
    private TipoVeiculo tipoVeiculo;

    public Veiculo(String placa, TipoVeiculo tipoVeiculo) {
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

    public double calcularAluguel() {
        long dias = Duration.between(diaDevolucao, diaAlugado).toDays() + 1;
        return dias * 100;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipoVeiculo
            + " Placa: " + placa;
    }
}
