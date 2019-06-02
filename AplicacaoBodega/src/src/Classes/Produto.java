
package Classes;

public class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private int quantidade;
    
    public Produto(String codigo){
        this.codigo = codigo;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
}
