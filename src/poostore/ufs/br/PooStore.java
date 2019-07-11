package poostore.ufs.br;

import java.util.Scanner;
import poostore.ufs.br.util.Textos;

/** 
 * Classe Principal
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
            System.out.println(Textos.OPCOES_MENU);
            System.out.print(Textos.DIGITAR_OPCAO_DESEJADA);

            opcao = validarOpcao(entrada.nextInt());
             
            //código vem aqui
            
            System.out.print(Textos.MOSTRAR_MENU_DENOVO);
            entrada.next();
        }
    }
    /** 
     * Função responsável por validar a opção selecionada e solicitar uma nova entrada quando for inválida
     * @param opcao é o valor digitado pelo usuário
     * @return retorna uma opção válida do tipo int
    */
    public static int validarOpcao(int opcao) {
        if(opcao >= 1 && opcao <= 10) 
            return opcao;
        
        System.out.println(Textos.OPCAO_INVALIDA);
        System.out.print(Textos.DIGITAR_OPCAO_DESEJADA);
        return validarOpcao(entrada.nextInt());
    }
}
