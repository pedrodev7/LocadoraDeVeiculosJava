package entidades;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import interfaces.IVeiculo;
import interfaces.TipoVeiculo;

public class Veiculo implements IVeiculo {
    private String placa;
    private Boolean disponivel;
    private LocalDate diaAlugado;
    private LocalDate diaDevolucao;
    private TipoVeiculo tipoVeiculo;


    @Override
    public double calcularAluguel(LocalDateTime diaAlugado, LocalDateTime diaDevolucao) {
        return calcularDias(diaAlugado, diaDevolucao) * 100;
    }

    @Override
    public long calcularDias(LocalDateTime diaAlugado, LocalDateTime diaDevolucao) {
        return Duration.between(diaAlugado, diaDevolucao).toDays() + 1;
    }
    
}
