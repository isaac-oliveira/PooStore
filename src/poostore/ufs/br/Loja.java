package poostore.ufs.br;

import java.util.Scanner;
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
   private Scanner entrada = new Scanner(System.in);
    
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
        
         System.out.println("\n----- Cadastrar Cliente -----");
         System.out.print("Digite o CPF do cliente: ");
         int cpf = entrada.nextInt();
        
         boolean resp = Lista.contemCliente(clientes, cpf) ;
       
         if (resp){
           System.out.println("\nJá existe um cliente cadastrado com esse CPF !");
         }
        
         else {
           System.out.print("Digite o nome do cliente: ");
           String nome = entrada.next();
           
          Cliente c = new Cliente();
          c.setCpf(cpf);
          c.setNome(nome);
          
          Lista.addCliente(clientes, c);
           
         }       
        
    }
    
    public void cadastrarProdutos() {
        System.out.println("\n----- Cadastrar Produtos -----");
        System.out.print("Digite o nome do produto: ");
        String nome = entrada.next();
        
        boolean resp = Lista.contemProduto(produtos, nome);
        
        if (resp){
            System.out.println("\nJá existe um produto cadastrado com esse nome !");
        }
        
        else{
            System.out.print("Preço de venda: R$");
            float preco = entrada.nextFloat();
            
            System.out.print("Quantidade: ");
            int qtd = entrada.nextInt();
            
            Produto p = new Produto();
            p.setPrecoVenda(preco);
            p.setQuantidade(qtd);
            
            Lista.addProduto(produtos, p);
        }
    }
    
    public void cadastrarVendas() {
         System.out.println("\n----- Cadastrar Vendas -----");       
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
    public void listarProdutos(boolean noEstoque) {
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