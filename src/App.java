import java.util.ArrayList;

import database.Dados;
import entidades.Locadora;
import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import entidades.Veiculo;
import enums.TipoVeiculo;
import repository.PessoaRepository;
import repository.VeiculoRepository;

public class App {
    public static void main(String[] args) throws Exception {

        // Inicializando Objetos e Repositorios com dados Mockup
        PessoaRepository listaClientes = new PessoaRepository(new ArrayList<>(new Dados().gerarClientes()));
        VeiculoRepository listaVeiculos = new VeiculoRepository(new ArrayList<>(new Dados().gerarVeiculos()));

        Locadora locadora = new Locadora("Brasil");

        Veiculo veiculo;
        Pessoa pessoa;

        // Alugando Veiculos Disponiveis PF e PJ
        pessoa = listaClientes.consultarCNPJ("03.925.339/0001-97");
        veiculo = listaVeiculos.consultar("MZE-4083");

        locadora.alugar(veiculo, pessoa);
        System.out.println();

        pessoa = listaClientes.consultarCPF("241.339.790-60");
        veiculo = listaVeiculos.consultar("NEQ-7745");

        locadora.alugar(veiculo, pessoa);
        System.out.println();

        // Alugando Veiculos Não Disponiveis PF e PJ
        locadora.alugar(veiculo, pessoa);
        System.out.println();

        // Listando Veiculos Alugados
        locadora.listarVeiculosAlugados();
        System.out.println();

        // Devolvendo Veiculos Disponiveis PF e PJ
        veiculo = listaVeiculos.consultar("MZE-4083");
        locadora.devolucao(veiculo);
        System.out.println();

        veiculo = listaVeiculos.consultar("NEQ-7745");
        // locadora.devolucao(veiculo);
        locadora.devolucao(veiculo);
        System.out.println();

        // Devolvendo Veiculos Não Disponiveis PF e PJ
        veiculo = listaVeiculos.consultar("NFB-6412");
        locadora.devolucao(veiculo);
        System.out.println();

        // Listando Veiculos Alugados Depois da Devolução
        locadora.listarVeiculosAlugados();
        System.out.println();

        // Buscando Veiculos por parte do Nome
        locadora.buscarVeiculo(listaVeiculos.listarTodos(), "FLex");
        System.out.println();

        // Cadastrando Veiculo em Memoria
        listaVeiculos.salvar(new Veiculo("Toyota", "Hilux SW4 4x4 3.0 12V V6", "MZU-3079", TipoVeiculo.SUV));
        listaVeiculos.salvar(new Veiculo("Toyota", "Hilux CD DX 4x4 3.0 8V 90cv Diesel", "MZU-3079", TipoVeiculo.SUV)); // Repetido
        listaVeiculos.salvar(new Veiculo("Toyota", "Corolla XEi 2.0 Flex 16V Aut.", "MRH-1604", TipoVeiculo.SEDAN));
        System.out.println();

        // Cadastrando Cliente PF e PJ em Memoria
        listaClientes.salvar(new PessoaFisica("Isis Rafaela Valentina Ribeiro", "923.519.448-28"));
        listaClientes.salvar(new PessoaFisica("Márcia Melissa Allana Cavalcanti", "090.869.177-71")); // Repetido
        listaClientes.salvar(new PessoaJuridica("Levi e Ana Assessoria Jurídica Ltda", "25.408.179/0001-41"));
        listaClientes.salvar(new PessoaJuridica("Jéssica e Jorge Locações de Automóveis ME", "22.415.053/0001-06")); // Repetido
        System.out.println();

        // Simulando Devolução com mais de 5 dias de Aluguel
        pessoa = listaClientes.consultarCNPJ("25.408.179/0001-41");
        veiculo = listaVeiculos.consultar("MZU-3079");

        locadora.alugar(veiculo, pessoa);
        locadora.devolverCincoDiasAFrente(veiculo);
        System.out.println();

        // Listando Veiculo e Clientes em Memoria
        System.out.println("=== LISTA DE CLIENTES ===");
        for (int i = 0; i < listaClientes.listarTodos().size(); i++) {
            System.out.println(listaClientes.listarTodos().get(i));
        }
        System.out.println();
        System.out.println("=== LISTA DE VEICULOS ===");
        for (int i = 0; i < listaVeiculos.listarTodos().size(); i++) {
            System.out.println(listaVeiculos.listarTodos().get(i));
        }
        System.out.println();

        // Alterando Veiculo em Memoria
        veiculo = listaVeiculos.consultar("MPX-7917");
        veiculo.setDisponivel(false); // Veiculo em Estado Não Disponivel
        listaVeiculos.atualizar(veiculo);

        // Alterando Cliente em Memoria
        pessoa = listaClientes.consultarCPF("865.372.339-09");
        pessoa.setNome("Pedro Miguel Pereira Moreira");
        listaClientes.atualizar(pessoa);

        // Lista Clientes e Veiculos Após Atualização
        System.out.println("=== LISTA DE CLIENTES ===");
        for (int i = 0; i < listaClientes.listarTodos().size(); i++) {
            System.out.println(listaClientes.listarTodos().get(i));
        }
        System.out.println();
        System.out.println("=== LISTA DE VEICULOS ===");
        for (int i = 0; i < listaVeiculos.listarTodos().size(); i++) {
            System.out.println(listaVeiculos.listarTodos().get(i));
        }
        System.out.println();

        // Tentando Alugar um Veiculo Depois da atualização com status indisponivel
        locadora.alugar(veiculo, pessoa);

    }
}
