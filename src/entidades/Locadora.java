package entidades;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Locadora {
    HashMap<Veiculo, Pessoa> locadora;

    public Locadora() {
        locadora = new HashMap<>();
    }

    public void alugar(Veiculo veiculo, Pessoa pessoa) {
        if (locadora.containsKey(veiculo) && veiculo.getDisponivel() == false) {
            System.out.println("Veiculo não está disponivel");
        } else {
            locadora.put(veiculo, pessoa);
            veiculo.setDiaAlugado(LocalDateTime.now());
            veiculo.setDisponivel(false);
            System.out.println("VEICULO ALUGADO COM SUCESSO");
        }

    }

    public Double devolucao(Veiculo veiculo) {

        if (locadora.containsKey(veiculo)) {
            locadora.remove(veiculo);
            veiculo.setDiaDevolucao(LocalDateTime.now());
            return calcularAluguel(veiculo);
        }

        System.out.println("Esse existe veiculo não foi alugado");
        return null;

    }

    private Double calcularAluguel(Veiculo veiculo) {
        long dias = Duration.between(veiculo.getDiaAlugado(), veiculo.getDiaDevolucao()).toDays() + 1;
        Pessoa pessoa = locadora.get(veiculo);
        Double desconto = 0.0;

        if (pessoa instanceof PessoaFisica && dias > 5) {
            desconto = 0.05;
            if (pessoa instanceof PessoaJuridica && dias > 5) {
                desconto = 0.1;
            }
        }

        return switch (veiculo.getTipoVeiculo()) {
            case CARRO -> (double) (dias * 100) - (dias * 100 * desconto);
            case MOTO -> (double) (dias * 150) - (dias * 150 * desconto);
            case CAMINHAO -> (double) (dias * 200) - (dias * 200 * desconto);
        };

    }

    public void buscarVeiculo(List<Veiculo> veiculo, String busca) {
        System.out.println("Lista de Veiculos com nome " + busca.toUpperCase());
        for (int i = 0; i < veiculo.size(); i++) {
            if (veiculo.get(i).getPlaca().toLowerCase().contains(busca)) {
                System.out.println(veiculo.get(i).toString());
            }
        }
    }

    public void listarVeiculosAlugados() {
        Set<Veiculo> chaves = locadora.keySet();
        for (Veiculo chave : chaves) {
            if (chave != null)
                System.out.println(chave + " | " + locadora.get(chave));
        }
    }
}
