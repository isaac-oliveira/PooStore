package poostore.ufs.br.util;

/**
 * Classe para centralizar os texto e diminuir a 'poluíção' do código
 * @author isaac
 */
public class Textos {
    /** 
     * Texto do menu inicial
     */
    public static final String OPCOES_MENU = "Escolha uma opção:\n" +
                "   1. Listar todos os produtos cadastrados\n" +
                "   2. Listar os produtos disponíveis no estoque\n" +
                "   3. Listar todos os produtos esgotados no estoque\n" +
                "   4. Aumentar a quantidade de produtos no estoque\n" +
                "   5. Cadastrar um cliente\n" +
                "   6. Listar os clientes cadastrados\n" +
                "   7. Cadastrar vendas\n" +
                "   8. Listar todas as vendas\n" +
                "   9. Listar compras de um determinado cliente\n" + 
                "   10. Sair do programa";
    
    /**
     * Texto para digitar a opção desejada
     */
    public static final String DIGITAR_OPCAO_DESEJADA = "Digite a opção desejada: ";
    
    /**
     * Texto para opções inválidas
     */
    public static final String OPCAO_INVALIDA = "Opção inválida!";
    
    /**
     * Texto para mostrar o menu novamente
     */
    public static final String MOSTRAR_MENU_DENOVO = "Pressione algum caractere e depois aperte Enter para rever o menu";
}
