package poostore.ufs.br;

import java.util.Scanner;

/**
 *
 * @author isaac
 */
public class PooStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
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
        int opcao = input.nextInt();
    }
}
