package repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Veiculo;
import interfaces.IVeiculoRepository;

public class VeiculoRepository implements IVeiculoRepository {

    private List<Veiculo> listaVeiculos;
    Scanner sc = new Scanner(System.in);

    public VeiculoRepository(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public VeiculoRepository() {
        this.listaVeiculos = new ArrayList<>();
    }

    @Override
    public Veiculo salvar(Veiculo veiculo) {
        Veiculo consultaVeiculo = consultar(veiculo.getPlaca());

        if (consultaVeiculo == null) {
            listaVeiculos.add(veiculo);
            return veiculo;
        }

        return null;
        // throw new IllegalArgumentException("Esse veiculo já existe na base de dados.");
    }

    @Override
    public void atualizar(Veiculo veiculo) {
        Veiculo consultaVeiculo = consultar(veiculo.getPlaca());

        if (consultaVeiculo == null) {
            throw new IllegalArgumentException("Esse veiculo não existe na base de dados.");
        }

        menuAtualizacao(veiculo);

    }

    private boolean verificarVeiculo(Veiculo veiculo) {
        Veiculo consultaVeiculo = consultar(veiculo.getPlaca());

        if (consultaVeiculo == null) {
            throw new IllegalArgumentException("Esse veiculo não existe na base de dados.");
        }

        return true;
    }

    @Override
    public boolean deletar(Veiculo veiculo) {
        verificarVeiculo(veiculo);
        listaVeiculos.remove(veiculo);
        return true;
    }

    @Override
    public Veiculo consultar(String placa) {
        for (int i = 0; i < listaVeiculos.size(); i++) {
            if (listaVeiculos.get(i).getPlaca().equals(placa)) {
                return listaVeiculos.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Veiculo> listarTodos() {
        return new ArrayList<>(listaVeiculos);
    }

    public void alugar(){
        Veiculo veiculo = listaVeiculos.get(0);
        veiculo.setDisponivel(true);
        veiculo.setDiaAlugado(LocalDateTime.now());
    }

    private void menuAtualizacao(Veiculo veiculo) {

        boolean condition = true;
        do {
            System.out.println("Qual operação deseja realizar no veiculo: " + veiculo.getPlaca());
            System.out.println("1- Alugar");
            System.out.println("2- Devolução");
            System.out.println("3- Sair");
            System.out.print(">> ");
            String opcao = sc.nextLine();

            switch (opcao) {

                case "1":
                    System.out.println("O Aluguel vai ocorrer agora: " + LocalDateTime.now());
                    veiculo.setDiaAlugado(LocalDateTime.now());
                    salvar(veiculo);
                    break;

                case "2":
                    System.out.println("A devolução vai ocorrer agora: " + LocalDateTime.now());
                    veiculo.setDiaDevolucao(LocalDateTime.now());
                    salvar(veiculo);
                    break;
                case "3":
                    condition = false;
                    break;
                default:
                    System.err.println("Opção Invalida. Tente Novamente.");
                    break;
            }
        } while (condition);

        sc.close();

    }

}
