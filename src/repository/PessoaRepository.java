package repository;

import java.util.ArrayList;
import java.util.List;

import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import interfaces.IPessoaRepository;

public class PessoaRepository implements IPessoaRepository {
    List<Pessoa> listaDeClientes;

    public PessoaRepository(List<Pessoa> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

    public PessoaRepository() {
        this.listaDeClientes = new ArrayList<>();
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        if (validaClienteNaBaseDeDados(pessoa)) {
            return null;
        }

        listaDeClientes.add(pessoa);
        return pessoa;
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        if(!validaClienteNaBaseDeDados(pessoa)){
            listaDeClientes.remove(pessoa);
            salvar(pessoa);
        }

    }

    @Override
    public boolean deletar(Pessoa pessoa) {
        listaDeClientes.remove(pessoa);
        return true;
    }

    @Override
    public PessoaFisica consultarPF(String cpf) {
        PessoaFisica pessoaFisica;
        for (int i = 0; i < listaDeClientes.size(); i++) {
            if (listaDeClientes.get(i) instanceof PessoaFisica) {
                pessoaFisica = (PessoaFisica) listaDeClientes.get(i);
                if (pessoaFisica.getCpf().equalsIgnoreCase(cpf)) {
                    return pessoaFisica;
                }
            }

        }

        return null;
    }

    @Override
    public PessoaJuridica consultarCNPJ(String cpf) {
        PessoaJuridica pessoaJuridica;
        for (int i = 0; i < listaDeClientes.size(); i++) {
            if (listaDeClientes.get(i) instanceof PessoaJuridica) {
                pessoaJuridica = (PessoaJuridica) listaDeClientes.get(i);
                if (pessoaJuridica.getCnpj().equalsIgnoreCase(cpf)) {
                    return pessoaJuridica;
                }
            }

        }

        return null;
    }

    @Override
    public List<Pessoa> listarTodos() {
        return new ArrayList<>(listaDeClientes);
    }

    private boolean validaClienteNaBaseDeDados(Pessoa pessoa) {
        PessoaFisica pf;
        if (pessoa instanceof PessoaFisica) {
            pf = (PessoaFisica) pessoa;
            String cpf = pf.getCpf();
            pf = consultarPF(cpf);
            if (pf != null) {
                System.out.println("CPF já Existe na Base de Dados");
                return true;
            }
        }

        PessoaJuridica pj;
        if (pessoa instanceof PessoaJuridica) {
            pj = (PessoaJuridica) pessoa;
            String cnpj = pj.getCnpj();
            pj = consultarCNPJ(cnpj);
            if (pj != null) {
                System.out.println("CNPJ já Existe na Base de Dados");
                return true;
            }
        }

        return false;
    }

}
