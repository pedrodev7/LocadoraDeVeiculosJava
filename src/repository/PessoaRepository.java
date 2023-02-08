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
        listaDeClientes.add(pessoa);
        return pessoa;
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub
        return null;
    }

}
