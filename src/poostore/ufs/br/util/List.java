package poostore.ufs.br.util;

/**
 * @author isaac
 */
public class List {
    /**
     * Função para adicionar um novo elemento na lista
     * @param lista lista aonde vamos adicionar o novo elemento
     * @param elemento elemento que será adicionado na lista
     * @return retorna a nova lista com um novo elemento
     */
    public static Object[] addElemento(Object[] lista, Object elemento) {
        Object[] novaLista = new Object[lista.length + 1];
        for(int i = 0; i < lista.length; i++)
            novaLista[i] = lista[i];
        novaLista[lista.length] = elemento;//add novo elemento no final da nova lista
        
        return novaLista;
    }  
}
