package poostore.ufs.br;

/**
 *
 * @author victor
 */
public class Item {
    private Produto produtoComprado;
    private int quantidadeVendida;

    public Produto getProdutoComprado() {
        return produtoComprado;
    }

    public void setProdutoComprado(Produto produtoComprado) {
        this.produtoComprado = produtoComprado;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
    
    
}
