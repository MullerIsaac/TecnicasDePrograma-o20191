
package Classes;

import Interfaces.IEstoque;
import java.util.ArrayList;

public class Bodega {
    private IEstoque estoque;
    
    public Bodega(IEstoque estoque){
        this.estoque = estoque;
    }
    
    public void adicionarProduto(Produto produto){
        this.estoque.adicionar(produto);
    }
    
    public void removerProduto(String codigo){
        this.estoque.apagar(codigo);
    }
    
    public Produto consultarProduto(String codigo){
        return this.estoque.buscar(codigo);
    }
    
    public void estocarProduto(String codigo, int quantidade){
        Produto produto = consultarProduto(codigo);
        int qntAnterior = produto.getQuantidade();
        produto.setQuantidade(qntAnterior + quantidade);
    }
    
    public void venderProduto(String codigo, int quantidade){
        Produto produto = consultarProduto(codigo);
        int qntAnterior = produto.getQuantidade();
        produto.setQuantidade(qntAnterior - quantidade);
    }
    
    public ArrayList<Produto> produtosEmEstoque(){
        return this.estoque.produtosEmEstoque();
    }
    
    public ArrayList<Produto> produtosEmFalta(){
        return this.estoque.produtosEmFalta();
    }
}
