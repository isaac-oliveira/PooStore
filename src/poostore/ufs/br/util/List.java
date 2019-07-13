package poostore.ufs.br.util;

import poostore.ufs.br.*;

/**
 * @author isaac
 */
public class List {
    /**
     * Função para verificar se o cliente já foi cadastrado
     * @param lista lista de clientes 
     * @param cliente cliente a ser verificado se está na lista pelo cpf
     * @return um boolean indicando se o cliente já foi cadastrado
     */
    public static boolean contemCliente(Cliente[] lista, Cliente cliente) {
        for(Cliente c : lista) 
            if(c.getCpf() == cliente.getCpf()) return true;
               
        return false;
    }
    
    /**
     * Função para verificar se o produto já foi cadastrado
     * @param lista lista de produtos 
     * @param produto produto a ser verificado se está na lista pelo nome
     * @return um boolean indicando se o produto já foi cadastrado
     */
    public static boolean contemProduto(Produto[] lista, Produto produto) {
        for(Produto p : lista) 
            if(p.getNome().equalsIgnoreCase(produto.getNome())) return true;
               
        return false;
    }
    
    /**
     * Função para verificar se o cliente já foi cadastrado
     * @param lista lista de clientes 
     * @param cliente cliente a ser verificado se está na lista pelo cpf
     * @return um boolean indicando se o cliente já foi cadastrado
     */
    public static boolean contemVenda(Cliente[] lista, Cliente cliente) {
        for(Cliente c : lista) 
            if(c.getCpf() == cliente.getCpf()) return true;
               
        return false;
    }
    
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
