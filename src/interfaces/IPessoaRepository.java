package interfaces;

import java.util.List;

import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public interface IPessoaRepository {
    Pessoa salvar(Pessoa pessoa);
    void atualizar(Pessoa pessoa);
    boolean deletar(Pessoa pessoa);
    PessoaFisica consultarPF(String cpf);
    PessoaJuridica consultarCNPJ(String cpf);
    List<Pessoa> listarTodos();
}
