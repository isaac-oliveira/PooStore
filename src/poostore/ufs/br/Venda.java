package poostore.ufs.br;

/**
 * Classe que irá armazenar as vendas efetuadas
 * @author victor
 */
public class Venda {
    public static int ultimoCodigo = 0;
    
    private int codigoVenda;
    private String dataVenda;
    private Item itensVenda;
    private Cliente cliente;
    
    public Venda() {
        Venda.ultimoCodigo += 1;
        this.setCodigoVenda(Venda.ultimoCodigo);
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    private void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Item getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(Item itensVenda) {
        this.itensVenda = itensVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }  

    @Override
    public String toString() {
        return codigoVenda + 
                " - Data da venda: " + dataVenda + 
                ", Item comprado: " + itensVenda.getProdutoComprado().getNome() + 
                " x " + itensVenda.getQuantidadeVendida() + 
                ", Cliente: {" + cliente.toString() + "}";
    }   
}