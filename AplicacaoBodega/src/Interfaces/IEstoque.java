
package Interfaces;

import Classes.Produto;
import Excecoes.PJCException;
import Excecoes.PNEException;
import java.util.ArrayList;

public interface IEstoque {
    public void adicionar(Produto produto)throws PJCException;
    public Produto buscar(String codigo)throws PNEException;
    public void apagar(String codigo);
    public int quantidade(String codigo);
    public ArrayList<Produto> produtosEmEstoque();
    public ArrayList<Produto> produtosEmFalta();
}
