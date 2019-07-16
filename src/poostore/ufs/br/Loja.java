package poostore.ufs.br;

import poostore.ufs.br.util.Lista;

/**
 *
 * @author isaac
 */
public class Loja {
    private Cliente[] clientes = { new Cliente(), new Cliente() };
    private Produto[] produtos = {};
    private Venda[] vendas = {};
    private int opcao;
    
    //Constantes
    private final int CADASTRAR_CLIENTES = 1;
    private final int CADASTRAR_PRODUTOS = 2;
    private final int CADASTRAR_VENDAS = 3;
    private final int LISTAR_TODOS_CLIENTES = 4;
    private final int LISTAR_TODOS_PRODUTOS = 5;
    private final int LISTAR_TODOS_PRODUTOS_ESTOQUE = 6;
    private final int LISTAR_TODAS_VENDAS = 7;


    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        switch(opcao) {
            case CADASTRAR_CLIENTES:
                cadastrarCliente();
                break;
            case CADASTRAR_PRODUTOS:
                cadastrarProdutos();
                break;
            case CADASTRAR_VENDAS:
                cadastrarVendas();
                break;
            case LISTAR_TODOS_CLIENTES:
                this.listarTodosClientes();
                break;
            case LISTAR_TODOS_PRODUTOS: 
                listarTodosProdutos(false);
                break;
            case LISTAR_TODOS_PRODUTOS_ESTOQUE:
                listarTodosProdutos(true);
                break;
            case LISTAR_TODAS_VENDAS:
                listarTodasVendas();
                break;        
        }
    }
    
    public void cadastrarCliente() {
        System.out.println("\nCadastrar Cliente");
    }
    
    public void cadastrarProdutos() {
        System.out.println("\nCadastrar Produtos");
    }
    
    public void cadastrarVendas() {
         System.out.println("\nCadastrar Vendas");       
    }
    
    public void listarTodosClientes() {
        System.out.println("\n----- Lista de todos os clientes -----");
        for(Cliente cliente : clientes) 
            System.out.println(cliente.toString());
        
        if(Lista.isVazio(clientes)) 
            System.out.println("\nNenhum cliente foi encontrado");
    }
    
    /**
     * Função que de acordo com 'noEstoque' pode listar todos os produtos ou filtrar os que estão no estoque 
     * @param noEstoque se for 'true' ele vai listar somente os produtos que estão no estoque, caso contrário vai listar todos 
     */
    public void listarTodosProdutos(boolean noEstoque) {
        System.out.println(noEstoque ? 
                "\n----- Lista de todos os produtos no estoque -----" : 
                "\n----- Lista de todos os produtos -----");
        
        Produto[] filtro = noEstoque ?  
                filtrarProduto(produtos) : 
                produtos;
        
        for(Produto produto : filtro) 
            System.out.println(produto.toString());
        
        if(Lista.isVazio(filtro)) 
            System.out.println("\nNenhum produto foi encontrado");
    }
    
    /**
     * Filtra os produtos que estão no estoque
     * @param produtos lista de produtos a ser filtrada
     * @return lista dos produtos no estoque
     */
    public Produto[] filtrarProduto(Produto[] produtos) {
        Produto[] filtro = {};
        for(Produto produto : produtos)
            if(produto.getQuantidade() > 0)
                filtro = Lista.addProduto(filtro, produto);
        
        return filtro;
    } 
    
    public void listarTodasVendas() {
        System.out.println("\n----- Lista de todas as vendas -----");
        for(Venda venda : vendas)
            System.out.println(venda.toString());
        
        if(Lista.isVazio(vendas)) 
            System.out.println("\nNenhuma venda foi encontrada");
    }
}