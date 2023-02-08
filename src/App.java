import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class App {
    public static void main(String[] args) throws Exception {
        PessoaFisica pf1 = new PessoaFisica("Ana", "12345");
        PessoaFisica pf2 = new PessoaFisica("Robert", "67890");
        PessoaFisica pf3 = new PessoaFisica("James", "11223");

        PessoaJuridica pj1 = new PessoaJuridica("Java SE", "0001");
        PessoaJuridica pj2 = new PessoaJuridica("Java EE", "0002");
        PessoaJuridica pj3 = new PessoaJuridica("Oracle", "0003");



        
    }
}
