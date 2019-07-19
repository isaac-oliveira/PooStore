package poostore.ufs.br;

import java.io.IOException;
import java.util.Scanner;
import poostore.ufs.br.util.Textos;

/**
 * Classe Principal
 * @author isaac
 */
public class PooStore {
    private static Scanner entrada = new Scanner(System.in);;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Loja loja = new Loja();
        int opcao = 0;
        while (opcao != 8) {
            System.out.println(Textos.OPCOES_MENU);
            System.out.print(Textos.DIGITAR_OPCAO);

            opcao = validarOpcao(entrada.nextInt());

            loja.setOpcao(opcao);

            if (opcao != 8) {
                System.out.print(Textos.REVER_MENU);
                System.in.read();
            } else {
                System.out.println(Textos.AGRADECIMENTO);
            }
        }
    }

    /**
     * Função responsável por validar a opção selecionada e solicitar uma nova
     * entrada quando for inválida
     *
     * @param opcao é o valor digitado pelo usuário
     * @return uma opção válida do tipo int
     */
    public static int validarOpcao(int opcao) {
        if (opcao >= 1 && opcao <= 8)
            return opcao;

        System.out.println(Textos.OPCAO_INVALIDA);
        System.out.print(Textos.DIGITAR_OPCAO);
        return validarOpcao(entrada.nextInt());
    }
}
