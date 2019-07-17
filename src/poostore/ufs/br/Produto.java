package poostore.ufs.br;

/**
 * Classe que irá armazenar os produtos da loja
 * @author victor
 */
public class Produto {
    
    public static int ultimoCodigo = 0;
    
    private int codigoProduto;
    private String nome;
    private float precoVenda;
    private int quantidade;
    
    public Produto() {
        Produto.ultimoCodigo += 1;
        this.setCodigoProduto(Produto.ultimoCodigo);
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }  
}