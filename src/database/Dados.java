package database;

import java.util.ArrayList;
import java.util.List;

import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import entidades.Veiculo;
import enums.TipoVeiculo;

public class Dados {

    private List<Veiculo> veiculos;
    private List<Pessoa> listaDeClientes;

    public Dados() {
        veiculos = new ArrayList<>();
        listaDeClientes = new ArrayList<>();
    }

    public List<Veiculo> gerarVeiculos() {
        veiculos = List.of(
                new Veiculo("Volvo", "S80 4.4 V8 315cv AWD Aut.", "NFB-6412", TipoVeiculo.SEDAN),
                new Veiculo("Volvo", "XC 90 2.5T 210cv AWD 5p.", "MVT-7286", TipoVeiculo.SUV),
                new Veiculo("Volvo", "S40 1.8 Mec.", "IAA-5389", TipoVeiculo.SEDAN),
                new Veiculo("Volvo", "S80 T6 2.8 BI-Turbo ARM", "MVM-0547", TipoVeiculo.SEDAN),
                new Veiculo("Volvo", "XC 60 2.0 T5  5p", "MDH-1154", TipoVeiculo.SUV),
                new Veiculo("Volvo", "XC 60 T-6  R-DESIGN 2.0 306cv FWD 5p", "NEQ-7745", TipoVeiculo.SUV),
                new Veiculo("Peugeot", "308 Allure 2.0 Flex 16V 5p Aut.", "MPX-7917", TipoVeiculo.HATCH_BACK),
                new Veiculo("Peugeot", "308 QUIKSILVER 1.6 Flex 16V 5p Mec.", "NDI-7853", TipoVeiculo.HATCH_BACK),
                new Veiculo("Peugeot", "208 Allure inconcert 1.6 Flex 16V 5p Aut", "LFN-2306", TipoVeiculo.HATCH_BACK),
                new Veiculo("Peugeot", "308 Roland Garros 1.6 Turbo 16V 5P", "HZG-3365", TipoVeiculo.HATCH_BACK),
                new Veiculo("Hyundai", "HB20S C.Style/C.Plus1.6 Flex 16V Aut. 4p", "MZE-4083", TipoVeiculo.SEDAN),
                new Veiculo("Honda", "HR-V LX 1.8 Flexone 16V 5p Aut.", "HRC-1893", TipoVeiculo.SUV));
        return veiculos;
    }

    public List<Pessoa> gerarClientes() {

        listaDeClientes = List.of(
                new PessoaFisica("Sabrina Olivia Moreira", "326.774.786-41"),
                new PessoaFisica("Juan Danilo Tiago Baptista", "090.869.177-71"),
                new PessoaFisica("Pedro Miguel Pereira", "865.372.339-09"),
                new PessoaFisica("Andreia Marli Porto", "241.339.790-60"),
                new PessoaFisica("Lucca Heitor Souza", "650.099.798-02"),
                new PessoaJuridica("Leandro e Nathan Construções ME", "68.835.326/0001-72"),
                new PessoaJuridica("Diego e Ryan Corretores Associados Ltda", "82.433.370/0001-87"),
                new PessoaJuridica("Manuela e Tatiane Corretores Associados ME", "03.925.339/0001-97"),
                new PessoaJuridica("Carolina e Jéssica Contábil Ltda", "22.415.053/0001-06"),
                new PessoaJuridica("Nina e Catarina Adega ME", "27.978.357/0001-03")

        );

        return listaDeClientes;
    }

}
