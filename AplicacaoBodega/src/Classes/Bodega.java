
package Classes;

import Excecoes.PJCException;
import Excecoes.PNEException;
import Interfaces.IEstoque;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Bodega {
    private IEstoque estoque;
    
    public Bodega(IEstoque estoque){
        this.estoque = estoque;
    }
    
    public void adicionarProduto(Produto produto)throws PJCException{
        try{
            this.estoque.adicionar(produto);
        }catch(PJCException e){
            throw e;
        }
    }
    
    public void removerProduto(String codigo)throws PNEException{
        try{
            consultarProduto(codigo);
            this.estoque.apagar(codigo);
        }catch(PNEException e){
            throw e;
        }
    }
    
    public Produto consultarProduto(String codigo)throws PNEException{
        Produto prod = this.estoque.buscar(codigo);
        if(prod != null){
            return prod;
        }else{
            throw new PNEException(codigo);
        }
    }
    
    public void estocarProduto(String codigo, int quantidade)throws PNEException{
        try{
            Produto produto = consultarProduto(codigo);
            int qntAnterior = produto.getQuantidade();
            produto.setQuantidade(qntAnterior + quantidade);
        }catch(PNEException e){
            throw e;
        }
    }
    
    public void venderProduto(String codigo, int quantidade)throws PNEException{
        try{
            Produto produto = consultarProduto(codigo);
            int qntAnterior = produto.getQuantidade();
            produto.setQuantidade(qntAnterior - quantidade);
        }catch(PNEException e){
            throw e;
        }
    }
    
    public ArrayList<Produto> produtosEmEstoque(){
        return this.estoque.produtosEmEstoque();
    }
    
    public ArrayList<Produto> produtosEmFalta(){
        return this.estoque.produtosEmFalta();
    }
}
