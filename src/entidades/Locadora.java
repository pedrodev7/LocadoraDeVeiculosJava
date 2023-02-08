package entidades;

import java.time.Duration;
import java.util.HashMap;

public class Locadora {
    HashMap<Veiculo, Pessoa> locadora;

    public Locadora() {
        locadora = new HashMap<>();
    }

    public void alugar(Veiculo veiculo, Pessoa pessoa) {
        locadora.put(veiculo, pessoa);
    }

    public void devolucao(Veiculo veiculo) {
        locadora.remove(veiculo);
        calcularAluguel(veiculo);
    }

    private Double calcularAluguel(Veiculo veiculo) {
        long dias = Duration.between(veiculo.getDiaAlugado(), veiculo.getDiaDevolucao()).toDays();
        return (double) (dias * 100);
    }
}
