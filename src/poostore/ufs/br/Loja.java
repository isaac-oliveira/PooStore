package poostore.ufs.br;

/**
 *
 * @author isaac
 */
public class Loja {
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
        System.out.println("Cadastrar Cliente");
    }
    
    public void cadastrarProdutos() {
        System.out.println("Cadastrar Produtos");
    }
    
    public void cadastrarVendas() {
         System.out.println("Cadastrar Vendas");       
    }
    
    public void listarTodosClientes() {
        System.out.println("Listar todos os clientes");
    }
    
    /**
     * Função que lista todos os produtos e também pode filtrar os que estão no estoque 
     * @param noEstoque filtro dos produtos que estão e não estão no estoque
     */
    public void listarTodosProdutos(boolean noEstoque) {
        System.out.println(noEstoque ? "Listar todos os produtos no estoque" : "Listar todos os produtos");
    }
    
    public void listarTodasVendas() {
        System.out.println("Listar todas as vendas");
    }
}
