
package Excecoes;


public class PJCException extends Exception{
    private String codigo;
    
    public PJCException(String codigo){
        super("Produto já cadastrado! Por favor use um código diferente");
        this.codigo = codigo;
    }
    
    public String codigo(){
        return this.codigo;
    }
}
