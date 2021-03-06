package poostore.ufs.br;

/**
 * Classe que irá armazenar os clientes da loja
 * @author victor
 */
public class Cliente {

    public static int ultimoCodigo = 0;
    private int codigo;
    private String nome;
    private String cpf;

    public Cliente() {
        Cliente.ultimoCodigo += 1;
        this.setCodigo(Cliente.ultimoCodigo);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Código " + codigo + " - Nome: " + nome + ", CPF: " + cpf;
    }
}
