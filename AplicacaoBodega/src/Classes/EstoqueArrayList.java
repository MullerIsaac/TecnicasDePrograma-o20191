
package Classes;

import Interfaces.IEstoque;
import java.util.ArrayList;

public class EstoqueArrayList implements IEstoque{
    public ArrayList<Produto> produtos;
    
    public EstoqueArrayList(){
        produtos = new ArrayList<>();
    }

    @Override
    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public Produto buscar(String codigo) {
        for(Produto prod : produtos){
            if(prod.getCodigo().equals(codigo))
                return prod;
        }
        return null;
    }

    @Override
    public void apagar(String codigo) {
        Produto produto = buscar(codigo);
        produtos.remove(produto);
    }

    @Override
    public int quantidade(String codigo) {
        int Total = 0;
        for(Produto prod : produtos){
            Total = Total + prod.getQuantidade();
        }
        return Total;
    }

    @Override
    public ArrayList<Produto> produtosEmEstoque() {
        return produtos;
    }

    @Override
    public ArrayList<Produto> produtosEmFalta() {
        ArrayList<Produto> produtosEmFalta = new ArrayList<>();
        for(Produto prod : produtos){
            if(prod.getQuantidade() == 0)
                produtosEmFalta.add(prod);
        }
        return produtosEmFalta;
    }
}
