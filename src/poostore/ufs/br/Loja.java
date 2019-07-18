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

    /**
     * @author victor
     */    
    public void cadastrarCliente() {
        System.out.println("\n----- Cadastrar Cliente -----");
        System.out.print("Digite o CPF do cliente: ");
        String cpf = entrada.next();

        if (!Lista.contemCliente(clientes, cpf)){
           System.out.print("Nome do cliente: ");
           String nome = entrada.next();

           Cliente c = new Cliente();
           c.setCpf(cpf);
           c.setNome(nome);

           clientes = Lista.addCliente(clientes, c);

           System.out.println("Cadastro efetuado com sucesso !");
        } else {
           System.out.println("\nJá existe um cliente cadastrado com esse CPF !");
        }       
        
    }
    
    /**
    * @author victor
    */

    public void cadastrarProdutos() {
        System.out.println("\n----- Cadastrar Produtos -----");
        System.out.print("Digite o nome do produto: ");
        String nome = entrada.next();
        
        if (!Lista.contemProduto(produtos, nome)){
            System.out.print("Quantidade: ");
            int qtd = entrada.nextInt();
            
            if(qtd >= 0) {
                System.out.print("Preço de venda: R$ ");
                float preco = entrada.nextFloat();

                Produto p = new Produto();
                p.setNome(nome);
                p.setPrecoVenda(preco);
                p.setQuantidade(qtd);

                produtos = Lista.addProduto(produtos, p);

                System.out.println("Cadastro efetuado com sucesso !");
            } else {
                System.out.println("Quantidade deve ser maior ou igual a zero!");
            }
            
        } else {
            System.out.println("\nJá existe um produto cadastrado com esse nome !");
        }
        
    }
    
    /**
     * @author victor
     */
    public void cadastrarVendas() { 
         System.out.println("\n----- Cadastrar Vendas -----");
          
         System.out.print("Digite a data e horário da venda no formato dd/mm/aaaa hh:mm:ss: ");
         String data = entrada.next();
         
         if (!Lista.contemVenda(vendas, data)){
             System.out.print("CPF do cliente que efetuou a compra: ");
             String cpf = entrada.next();
             
             Cliente cliente = Lista.encontreClientePorCPF(clientes, cpf);
             
             if (cliente != null){
                 System.out.print("Nome do produto comprado: ");
                 String nome = entrada.next();
                 Produto produto = Lista.encontreProdutoPorNome(produtos, nome);
                 
                    if(produto != null){
                        System.out.println("Quantidade do produto comprada: ");
                        int quantidade = entrada.nextInt();
                        
                            if(produto.getQuantidade() >= quantidade){
                                
                                produto.setQuantidade(produto.getQuantidade() - quantidade);
                                
                                Item item = new Item();
                                item.setProdutoComprado(produto);
                                item.setQuantidadeVendida(quantidade);
                                
                                Venda venda = new Venda();
                                venda.setCliente(cliente);
                                venda.setDataVenda(data);
                                venda.setItensVenda(item);
                                
                                vendas = Lista.addVenda(vendas, venda);
                                
                            }else{
                                System.out.println("Quantidade solicitada superior ao disponível em estoque !");
                            }

                    }else{
                        System.out.println("Produto não cadastrado, por gentileza cadastre-o !");
                    }

             }else{
                 System.out.println("Cliente não cadastrado, por gentileza cadastre-o !");
             }
         }    
    }
    
    public void listarTodosClientes() {
        System.out.println("\n----- Lista de todos os clientes -----");
        Lista.printLista(clientes, "Nenhum cliente encontrado");
        if(!Lista.isVazio(clientes)) opcaoListarVendaPorCliente();
    }
    
    public void opcaoListarVendaPorCliente() {
        System.out.println("\nDeseja listar as compras de um determinado cliente?");
        System.out.print("Digite S para sim ou alguma outra coisa para Não: ");
        if(entrada.next().equalsIgnoreCase("S")) 
            listarVendaPorCliente();
    }
    
    /**
     * Solicita o codigo de algum cliente e listar as compras dele 
     */
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
        if(!Lista.isVazio(filtro)) 
            opcaoAumentarQuantidadeProduto();
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
    /**
     * Pergunta se o usuário gostaria de aumentar a quantidade de algum produto no estoque
     */
    public void opcaoAumentarQuantidadeProduto() {
        System.out.println("\nDeseja aumentar a quantidade de algum produto?");
        System.out.print("Digite S para sim ou alguma outra coisa para não: ");
        if(entrada.next().equalsIgnoreCase("S")) 
            aumentarQuantidadeProduto();
    }
    
    /**
     * Solicita ao usuário o código do produto, a quantidade que foi adicionada no estoque e atualizar
     * o produto selecionado pelo código
     */
    public void aumentarQuantidadeProduto() {
        System.out.print("Digite o código do produto a ser alterado: ");
        int codigoProduto = entrada.nextInt();
        
        if(Lista.contemProdutoPorCodigo(produtos, codigoProduto)) {
            System.out.print("Agora digite quanto desse produto a mais foi adicionado: ");
            int quantidadeAMais = entrada.nextInt();

            produtos = Lista.aumentarQuantidade(produtos, codigoProduto, quantidadeAMais);
            System.out.println("\nOperação realizada com sucesso!");
        } else {
            System.out.println("\nProduto não encontrado!");
        }
    }
    
    /**
     * Lista todas as vendas cadastradas
     */
    public void listarTodasVendas() {
        System.out.println("\n----- Lista de todas as vendas -----");
        Lista.printLista(vendas, "\nNenhuma venda encontrada");
    }
}