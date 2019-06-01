
package Interfaces;

import Classes.Produto;
import java.util.ArrayList;

public interface IEstoque {
    public void adicionar(Produto produto);
    public Produto buscar(String codigo);
    public void apagar(String codigo);
    public int quantidade(String codigo);
    public ArrayList<Produto> produtosEmEstoque();
    public ArrayList<Produto> produtosEmFalta();
}
