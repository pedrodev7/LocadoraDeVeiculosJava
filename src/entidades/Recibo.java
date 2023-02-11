package entidades;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Recibo {
    public static void listarInformacoesDeAluguel(Veiculo veiculo, Pessoa pessoa, String local) {
        System.out.println("=== VEICULO ALUGADO COM SUCESSO ===");
        System.out.println("Carro: " + veiculo.getMarca() + " " +veiculo.getModelo());
        System.out.println("Cliente: " + pessoa.getNome());
        System.out.println("Data: " + veiculo.getDiaAlugado().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Horario: " + veiculo.getDiaAlugado().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("Local: " + local);
    }

    public static void listarInformacoesDeDevolucao(Veiculo veiculo, Pessoa pessoa, String local, BigDecimal valor, long dias) {
        System.out.println("=== VEICULO DEVOLVIDO COM SUCESSO ===");
        System.out.println("Carro: " + veiculo.getMarca() + " " +veiculo.getModelo());
        System.out.println("Cliente: " + pessoa.getNome());
        System.out.println("Data: " + veiculo.getDiaDevolucao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Horario: " + veiculo.getDiaDevolucao().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println("Local: " + local);
        System.out.println("Quantidade de Diarias: " + dias);
        if(dias > 5){
            System.out.println("Desconto: SIM");
            if(pessoa instanceof PessoaFisica){
                System.out.println("Valor do Desconto: 5%");
            }
            if(pessoa instanceof PessoaJuridica){
                System.out.println("Valor do Desconto: 10%");
            }
        } else {
            System.out.println("Desconto: NÃO");
        }
        System.out.println("Valor a pagar em R$ " + valor.setScale(2));
    }
}
