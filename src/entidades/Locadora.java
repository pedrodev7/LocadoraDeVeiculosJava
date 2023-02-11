package entidades;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Locadora {
    private HashMap<Veiculo, Pessoa> locadora;
    private String local;

    public Locadora(String local) {
        locadora = new HashMap<>();
        this.local = local;
    }

    public void alugar(Veiculo veiculo, Pessoa pessoa) {
        if (locadora.containsKey(veiculo) || veiculo.getDisponivel() == false) {
            System.out.println("Veiculo não está disponivel: " + veiculo.getMarca() + " " + veiculo.getModelo());
        } else {
            locadora.put(veiculo, pessoa);
            veiculo.setDiaAlugado(LocalDateTime.now());
            veiculo.setDisponivel(false);
            Recibo.listarInformacoesDeAluguel(veiculo, pessoa, local);
        }
    }

    public void devolucao(Veiculo veiculo) {

        if (locadora.containsKey(veiculo)) {
            veiculo.setDiaDevolucao(LocalDateTime.now());
            veiculo.setDisponivel(true);
            Recibo.listarInformacoesDeDevolucao(veiculo, locadora.get(veiculo), local, calcularAluguel(veiculo),
                    getDiasAlugados(veiculo));
            locadora.remove(veiculo);
        } else {
            System.out.println("Esse veiculo não foi alugado: " + veiculo.getMarca() + " " + veiculo.getModelo());
        }

    }

    public void devolverCincoDiasAFrente(Veiculo veiculo) {
        if (locadora.containsKey(veiculo)) {
            veiculo.setDiaDevolucao(LocalDateTime.now().plusDays(6));
            veiculo.setDisponivel(true);
            Recibo.listarInformacoesDeDevolucao(veiculo, locadora.get(veiculo), local, calcularAluguel(veiculo),
                    getDiasAlugados(veiculo));
            locadora.remove(veiculo);
        } else {
            System.out.println("Esse veiculo não foi alugado: " + veiculo.getMarca() + " " + veiculo.getModelo());
        }
    }

    private Long getDiasAlugados(Veiculo veiculo) {
        return Duration.between(veiculo.getDiaAlugado(), veiculo.getDiaDevolucao()).toDays() + 1;
    }

    private BigDecimal calcularAluguel(Veiculo veiculo) {
        long dias = getDiasAlugados(veiculo);
        Pessoa pessoa = locadora.get(veiculo);
        Double desconto = 0.0;

        if (pessoa instanceof PessoaFisica && dias > 5) {
            desconto = 0.05;
        }

        if (pessoa instanceof PessoaJuridica && dias > 3) {
            desconto = 0.1;
        }

        return switch (veiculo.getTipoVeiculo()) {
            case HATCH_BACK -> new BigDecimal((dias * 100) - (dias * 100 * desconto));
            case SEDAN -> new BigDecimal((dias * 150) - (dias * 150 * desconto));
            case SUV -> new BigDecimal((dias * 200) - (dias * 200 * desconto));
        };

    }

    public void buscarVeiculo(List<Veiculo> veiculo, String busca) {
        System.out.println("Lista de Veiculos com nome " + busca.toUpperCase());
        for (int i = 0; i < veiculo.size(); i++) {
            if (veiculo.get(i).getModelo().toLowerCase().contains(busca.toLowerCase())) {
                System.out.println(veiculo.get(i).toString());
            }
        }
    }

    public void listarVeiculosAlugados() {
        Set<Veiculo> chaves = locadora.keySet();
        System.out.println("=== LISTA DE VEICULOS ALUGADOS ===");
        for (Veiculo chave : chaves) {
            if (chave != null)
                System.out.println(chave + " | " + locadora.get(chave));
        }
        if (locadora.isEmpty() == true) {
            System.out.println("NÃO HÁ VEICULOS ALUGADOS NO MOMENTO");
        }
    }
}
