
package Classes;

public class ProdutoPerecivel extends Produto{
    private String validade;
    
    public ProdutoPerecivel(String codigo) {
        super(codigo);
    }
    
    public void setValidade(String validade){
        this.validade = validade;
    }
    
    public String getValidade(){
        return this.validade;
    }
    
}
