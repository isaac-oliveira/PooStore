package poostore.ufs.br.util;

import poostore.ufs.br.*;

/**
 * @author isaac
 */
public class Lista {
    /**
     * Função para verificar se o cliente já foi cadastrado
     * @param lista lista de clientes 
     * @param cliente cliente a ser verificado se está na lista pelo cpf
     * @return um booleano indicando se o cliente já foi cadastrado
     */
    public static boolean contemCliente(Cliente[] lista, int cpf) {
        for(Cliente c : lista) 
            if(c.getCpf() == cpf) 
                return true;
               
        return false;
    }
    
    /**
     * Função para verificar se o produto já foi cadastrado
     * @param lista lista de produtos 
     * @param produto produto a ser verificado se está na lista pelo nome
     * @return um booleano indicando se o produto já foi cadastrado
     */
    public static boolean contemProduto(Produto[] lista, String nome) {
        for(Produto p : lista) 
            if(p.getNome().equalsIgnoreCase(nome)) 
                return true;
               
        return false;
    }
    
    /**
     * Função para verificar se o cliente já foi cadastrado
     * @deprecated
     * @param lista lista de clientes 
     * @param cliente cliente a ser verificado se está na lista pelo cpf
     * @return um boolean indicando se o cliente já foi cadastrado
     */
    public static boolean contemVenda(Venda[] lista, Venda venda) {
        for(Venda v : lista) 
            if(v.getDataVenda().equalsIgnoreCase(venda.getDataVenda()))
                return true;
               
        return false;
    }
    
    /**
     * Função para adicionar um novo Cliente a lista
     * @param lista onde vamos adicionar o novo cliente
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
     * Função para adicionar um novo produto a lista
     * @param lista aonde vamos adicionar um novo produto
     * @param elemento produto que será adicionado a lista
     * @return uma nova lista com um novo cliente
     */
    public static Produto[] addProduto(Produto[] lista, Produto elemento) {
        Produto[] novaLista = new Produto[lista.length + 1];
        for(int i = 0; i < lista.length; i++)
            novaLista[i] = lista[i];
        novaLista[lista.length] = elemento;//add novo elemento no final da nova lista
        
        return novaLista;
    }  
    /**
     * Função para adicionar uma nova venda a lista
     * @param lista onde vamos adicionar uma nova Venda
     * @param elemento venda que será adicionado a lista
     * @return uma nova lista com a nova Venda
     */
    public static Venda[] addVenda(Venda[] lista, Venda elemento) {
        Venda[] novaLista = new Venda[lista.length + 1];
        for(int i = 0; i < lista.length; i++)
            novaLista[i] = lista[i];
        novaLista[lista.length] = elemento;//add novo elemento no final da nova lista
        
        return novaLista;
    }  
    
    public static boolean isVazio(Object[] lista) {
        return lista.length == 0;
    }
    
    /**
     * Devolve uma lista com as compras do cliente com o código passado pelo parametro.
     * @param lista lista das vendas a ser filtrada
     * @param codigoCliente código cliente que será usado como query
     * @return lista de venda de determinado cliente
     */
    public static Venda[] encontreVendasPorCodigoCliente(Venda[] lista, int codigoCliente) {
        Venda[] filtrada = {};
        for(Venda venda : lista)
            if(venda.getCliente().getCodigo() == codigoCliente)
                filtrada = addVenda(filtrada, venda);
        
        return filtrada;
    }
    
    public static Produto[] aumentarQuantidade(Produto[] lista, int codigoProduto, int quantidadeAMais) {
        for(Produto produto : lista) 
            if(produto.getCodigoProduto() == codigoProduto)
                produto.setQuantidade(produto.getQuantidade() + quantidadeAMais);
        
        return lista;
    }
    
    public static void printLista(Object[] lista, String placeHolder) {
        for(Object object : lista)
            System.out.println(object.toString());
        
        if(isVazio(lista)) System.out.println(placeHolder);
    }
}