package interfaces;

import java.time.LocalDateTime;

public interface IVeiculo {
    double calcularAluguel(LocalDateTime diaAlugado, LocalDateTime diaDevolucao);
    long calcularDias(LocalDateTime diaAlugado, LocalDateTime diaDevolucao);
}
