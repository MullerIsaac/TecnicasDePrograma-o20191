
package br.ufc.dc.tpi.banco;

import Interfaces.IRepositorioConta;
import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import java.util.Vector;

public class VectorContas implements IRepositorioConta{
    public Vector<ContaAbstrata> contas;
    
    public VectorContas(){
        contas = new Vector<>();
    }
    
    @Override
    public void inserir(ContaAbstrata conta){
        contas.add(conta);
    }
    
    @Override
    public void remover(String numero){
        ContaAbstrata conta;
        conta = procurar(numero);
        contas.remove(conta);
    }
    
    @Override
    public ContaAbstrata procurar(String numero){
        for(ContaAbstrata abs : contas){
            if(abs.numero().equals(numero)){
                return abs;
            }
        }
        return null;
    }
    
    @Override
    public ContaAbstrata[] listar(){
        ContaAbstrata[] conta = new ContaAbstrata[tamanho()];
        int i = 0;
        for(ContaAbstrata c : contas){
            conta[i] = c;
            i++;
        }
        return conta;    
    }
    
    @Override
    public int tamanho(){
        return contas.size();
    }
}
