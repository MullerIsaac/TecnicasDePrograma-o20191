
package Excecoes;

public class PNEException extends Exception{
    private String codigo;
    
    public PNEException(String codigo){
        super("Produto Inexistente!");
        this.codigo = codigo;
    }
    
    public String codigo(){
        return this.codigo;
    }
}
