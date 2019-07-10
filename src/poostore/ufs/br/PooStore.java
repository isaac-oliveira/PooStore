package poostore.ufs.br;

import java.util.Scanner;

/**
 *
 * @author isaac
 */
public class PooStore {
    private static Scanner entrada;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        entrada = new Scanner(System.in);
        
        int opcao = 0;
        while(opcao != 10) {
            System.out.println("Escolha uma opção:\n" +
                "   1. Listar todos os produtos cadastrados\n" +
                "   2. Listar os produtos disponíveis no estoque\n" +
                "   3. Listar todos os produtos esgotados no estoque\n" +
                "   4. Aumentar a quantidade de produtos no estoque\n" +
                "   5. Cadastrar um cliente\n" +
                "   6. Listar os clientes cadastrados\n" +
                "   7. Cadastrar vendas\n" +
                "   8. Listar todas as vendas\n" +
                "   9. Listar compras de um determinado cliente\n" + 
                "   10. Sair do programa");
        
            System.out.print("Digite a opção desejada: ");

            opcao = validarOpcao(entrada.nextInt());
            
            //código vem aqui
            
            System.out.print("Pressione Enter para rever o menu");
            entrada.next();
        }
    }
    
    public static int validarOpcao(int opcao) {
        if(opcao >= 1 && opcao <= 10) 
            return opcao;
        
        System.out.println("Opção inválida!");
        System.out.print("Digite a opção desejada: ");
        return validarOpcao(entrada.nextInt());
    }
}
