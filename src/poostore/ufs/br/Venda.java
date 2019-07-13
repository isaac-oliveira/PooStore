package poostore.ufs.br;

/**
 *
 * @author victor
 * 
 * Classe que irá armazenar as vendas efetuadas
 */
public class Venda {

    private int codigoVenda;
    private String dataVenda;
    private Item itensVenda;
    private Cliente cliente;

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
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
    
    
}
