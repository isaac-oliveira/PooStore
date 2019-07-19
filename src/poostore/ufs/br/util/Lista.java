package poostore.ufs.br.util;

import poostore.ufs.br.*;

/**
 * @author isaac
 */
public class Lista {

    /**
     * Função para verificar se o cliente já foi cadastrado
     *
     * @param lista lista de clientes
     * @param cpf cpf do cliente
     * @return um booleano indicando se o cliente já foi cadastrado
     */
    public static boolean contemCliente(Cliente[] lista, String cpf) {
        for (Cliente c : lista) 
            if (c.getCpf().equals(cpf)) 
                return true;

        return false;
    }

    /**
     * Função para verificar se o produto já foi cadastrado
     *
     * @param lista lista de produtos
     * @param nome nome do produto
     * @return um booleano indicando se o produto já foi cadastrado
     */
    public static boolean contemProduto(Produto[] lista, String nome) {
        for (Produto p : lista) 
            if (p.getNome().equalsIgnoreCase(nome))
                return true;
            
        return false;
    }

    /**
     * Verifica se tem produto com um determiando código
     * 
     * @param lista lista a se analisada
     * @param codigo valor do código a ser comparado
     * @return se contém ou não um produto com aquele código
     */
    public static boolean contemProdutoPorCodigo(Produto[] lista, int codigo) {
        for (Produto p : lista) 
            if (p.getCodigoProduto() == codigo) 
                return true;
        
        return false;
    }

    /**
     * Função para verificar se o cliente já foi cadastrado
     *
     * @author victor
     * @param lista lista de clientes
     * @param data data da venda
     * @return um boolean indicando se o cliente já foi cadastrado
     */
    public static boolean contemVenda(Venda[] lista, String data) {
        for (Venda v : lista) 
            if (v.getDataVenda().equalsIgnoreCase(data)) 
                return true;
        
        return false;
    }

    /**
     * @author victor
     */
    public static Cliente encontreClientePorCPF(Cliente[] clientes, String cpf) {
        for (Cliente c : clientes) 
            if (c.getCpf().equalsIgnoreCase(cpf)) 
                return c;
        
        return null;
    }

    /**
     * @author victor
     */
    public static Produto encontreProdutoPorNome(Produto[] produtos, String nome) {
        for (Produto p : produtos) 
            if (p.getNome().equalsIgnoreCase(nome)) 
                return p;
        
        return null;
    }
    
    /**
     * Função para adicionar um novo Cliente a lista
     *
     * @param lista onde vamos adicionar o novo cliente
     * @param elemento cliente que será adicionado na lista
     * @return retorna a nova lista com um novo cliente
     */
    public static Cliente[] addCliente(Cliente[] lista, Cliente elemento) {
        Cliente[] novaLista = new Cliente[lista.length + 1];
        System.arraycopy(lista, 0, novaLista, 0, lista.length);
        novaLista[lista.length] = elemento;//add novo elemento no final da nova lista

        return novaLista;
    }

    /**
     * Função para adicionar um novo produto a lista
     *
     * @param lista aonde vamos adicionar um novo produto
     * @param elemento produto que será adicionado a lista
     * @return uma nova lista com um novo cliente
     */
    public static Produto[] addProduto(Produto[] lista, Produto elemento) {
        Produto[] novaLista = new Produto[lista.length + 1];
        System.arraycopy(lista, 0, novaLista, 0, lista.length);
        novaLista[lista.length] = elemento;//add novo elemento no final da nova lista

        return novaLista;
    }

    /**
     * Função para adicionar uma nova venda a lista
     *
     * @param lista onde vamos adicionar uma nova Venda
     * @param elemento venda que será adicionado a lista
     * @return uma nova lista com a nova Venda
     */
    public static Venda[] addVenda(Venda[] lista, Venda elemento) {
        Venda[] novaLista = new Venda[lista.length + 1];
        System.arraycopy(lista, 0, novaLista, 0, lista.length);
        novaLista[lista.length] = elemento;//add novo elemento no final da nova lista

        return novaLista;
    }

    /**
     * Verifica se a lista tá vazia
     * 
     * @param lista lista a ser analisada
     * @return se a lista tá vazia ou não
     */
    public static boolean isVazio(Object[] lista) {
        return lista.length == 0;
    }

    /**
     * Devolve uma lista com as compras do cliente referente ao código passado pelo
     * parametro.
     *
     * @param lista lista das vendas a ser filtrada
     * @param codigoCliente código cliente que será usado como query
     * @return lista de venda de determinado cliente
     */
    public static Venda[] encontreVendasPorCodigoCliente(Venda[] lista, int codigoCliente) {
        Venda[] filtrada = {};
        for (Venda venda : lista) 
            if (venda.getCliente().getCodigo() == codigoCliente) 
                filtrada = addVenda(filtrada, venda);
        
        return filtrada;
    }
    
    /**
     * Atualizar o valor da quantidade do produto
     * 
     * @param lista lista a ser analisada
     * @param codigoProduto codigo do produto que vai ser alterado
     * @param quantidadeAMais quanto do produto foi adicionado
     * @return a lista com a nova quantidade
     */
    public static Produto[] aumentarQuantidade(Produto[] lista, int codigoProduto, int quantidadeAMais) {
        for (Produto produto : lista) 
            if (produto.getCodigoProduto() == codigoProduto) 
                produto.setQuantidade(produto.getQuantidade() + quantidadeAMais);
         
        return lista;
    }
    
    /**
     * Printa uma lista na tela e caso seja vázia exibi uma mensagem
     * 
     * @param lista lista a ser printada
     * @param placeHolder mensagem de caso a lista seja vázia
     */
    public static void printLista(Object[] lista, String placeHolder) {
        for (Object object : lista) 
            System.out.println(object.toString());
        if (isVazio(lista)) 
            System.out.println(placeHolder);
    }
}
