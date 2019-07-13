package poostore.ufs.br.util;

import poostore.ufs.br.*;

/**
 * @author isaac
 */
public class List {
    /**
     * Função para adicionar um novo Cliente na lista
     * @param lista lista aonde vamos adicionar o novo cliente
     * @param elemento cliente que será adicionado na lista
     * @return retorna a nova lista com um novo cliente
     */
    public static Cliente[] addCliente(Cliente[] lista, Cliente elemento) {
        Cliente[] novaLista = new Cliente[lista.length + 1];
        for(int i = 0; i < lista.length; i++)
            novaLista[i] = lista[i];
        novaLista[lista.length] = elemento;//add novo elemento no final da nova lista
        
        return novaLista;
    }  
    /**
     * Função para adicionar um novo Cliente na lista
     * @param lista lista aonde vamos adicionar um novo cliente
     * @param elemento cliente que será adicionado na lista
     * @return retorna a nova lista com um novo cliente
     */
    public static Produto[] addProduto(Produto[] lista, Produto elemento) {
        Produto[] novaLista = new Produto[lista.length + 1];
        for(int i = 0; i < lista.length; i++)
            novaLista[i] = lista[i];
        novaLista[lista.length] = elemento;//add novo elemento no final da nova lista
        
        return novaLista;
    }  
    /**
     * Função para adicionar uma nova Venda na lista
     * @param lista lista aonde vamos adicionar uma nova Venda
     * @param elemento cliente que será adicionado na lista
     * @return retorna a nova lista com um nova Venda
     */
    public static Venda[] addVenda(Venda[] lista, Venda elemento) {
        Venda[] novaLista = new Venda[lista.length + 1];
        for(int i = 0; i < lista.length; i++)
            novaLista[i] = lista[i];
        novaLista[lista.length] = elemento;//add novo elemento no final da nova lista
        
        return novaLista;
    }  
}
