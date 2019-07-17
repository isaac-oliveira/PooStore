package poostore.ufs.br;

import java.util.Scanner;
import poostore.ufs.br.util.Lista;

/**
 *
 * @author isaac
 */
public class Loja {
    private Scanner entrada = new Scanner(System.in);

    private Cliente[] clientes = {};
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
                listarProdutos(false);
                break;
            case LISTAR_TODOS_PRODUTOS_ESTOQUE:
                listarProdutos(true);
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
        Lista.printLista(clientes, "Nenhum cliente encontrado");
        if(!Lista.isVazio(clientes)) opcaoListarVendaPorCliente();
    }
    
    public void opcaoListarVendaPorCliente() {
        System.out.println("\nDeseja listar as compras de um determinado cliente?");
        System.out.print("Digite S para sim ou qualquer coisa para Não: ");
        if(entrada.next().equalsIgnoreCase("S")) 
            listarVendaPorCliente();
    }
    
    public void listarVendaPorCliente() {
        System.out.print("Então digite o código do cliente: ");
            Venda[] filtrada = Lista.encontreVendasPorCodigoCliente(vendas, entrada.nextInt());
            System.out.println("\n----- Lista das compras do cliente -----");
            Lista.printLista(filtrada, "Nenhuma compra encontrada");
    }
    
    /**
     * Função que de acordo com 'noEstoque' pode listar todos os produtos ou filtrar os que estão no estoque 
     * @param noEstoque se for 'true' ele vai listar somente os produtos que estão no estoque, caso contrário vai listar todos 
     */
    public void listarProdutos(boolean noEstoque) {
        System.out.println(noEstoque ? 
                "\n----- Lista de todos os produtos no estoque -----" : 
                "\n----- Lista de todos os produtos -----");
        
        Produto[] filtro = noEstoque ?  
                filtrarProdutos(produtos) : 
                produtos;
        
        Lista.printLista(filtro, "Nenhum produto encontrado");
        if(!Lista.isVazio(filtro)) aumentarQuantidadeProduto();
    }
    
    /**
     * Filtra os produtos que estão no estoque
     * @param produtos lista de produtos a ser filtrada
     * @return lista dos produtos no estoque
     */
    public Produto[] filtrarProdutos(Produto[] produtos) {
        Produto[] filtro = {};
        for(Produto produto : produtos)
            if(produto.getQuantidade() > 0)
                filtro = Lista.addProduto(filtro, produto);
        
        return filtro;
    } 
    
    public void aumentarQuantidadeProduto() {
        System.out.println("\nDeseja aumentar a quantidade de algum produto?");
        System.out.print("Digite S para sim ou alguma outra coisa para não: ");
        if(entrada.next().equalsIgnoreCase("S")) {
            System.out.print("Digite o código do produto a ser alterado: ");
            int codigoProduto = entrada.nextInt();
            
            System.out.print("Agora digite quanto desse produto a mais foi adicionado: ");
            int quantidadeAMais = entrada.nextInt();
            
            produtos = Lista.aumentarQuantidade(produtos, codigoProduto, quantidadeAMais);
            System.out.println("\nOperação realizada com sucesso!");
        }
    }
    
    public void listarTodasVendas() {
        System.out.println("\n----- Lista de todas as vendas -----");
        Lista.printLista(vendas, "\nNenhuma venda encontrada");
    }
}