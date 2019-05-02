
package br.ufc.dc.tpi.banco;

import Interfaces.IBanco;
import Interfaces.IRepositorioConta;
import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import br.ufc.dc.tpi.banco.contas.ContaEspecial;
import br.ufc.dc.tpi.banco.contas.ContaImposto;
import br.ufc.dc.tpi.banco.contas.ContaPoupanca;
import java.util.Vector;

public class BancoIndependente implements IBanco{
    
    private IRepositorioConta contas;
    private double juros = 0.05;
    
    public BancoIndependente(IRepositorioConta contas){
        this.contas = contas;
    }
 
    @Override
    public void cadastrar(ContaAbstrata conta){
        this.contas.inserir(conta);
    }
    
    @Override
    public ContaAbstrata procurar(String numero){
        return this.contas.procurar(numero);  
    }
    
    @Override
    public void debitar(String numero, double valor){
        ContaAbstrata conta;
        conta = procurar(numero);
        ContaImposto imposto;
        if(conta != null){
            if(conta instanceof ContaImposto){
                imposto = (ContaImposto) conta;
                imposto.debitar(valor);
            }else{
                conta.debitar(valor);
            }
        }else{
            System.out.println("Conta Inexistente! Não foi possível creditar.");
        }
    }
    
    @Override
    public void creditar(String numero, double valor){
        ContaAbstrata conta;
        conta = procurar(numero);
        ContaEspecial especial;
        if(conta != null){
            if(conta instanceof ContaEspecial){
                especial = (ContaEspecial) conta;
                especial.creditar(valor);
            }else{
                conta.creditar(valor);
            } 
        }else{
            System.out.println("Conta Inexistente! Não foi possível debitar.");
        }
    }
    
    @Override
    public double saldo(String numero){
        ContaAbstrata conta;
        conta = procurar(numero);
        if(conta!=null){
            return conta.saldo();
        }else{
            System.out.println("Conta Inexistente! Não foi possível exibir o saldo");
            return 0;
        }
    }
    
    @Override
    public void transferir(String origem, String destino, double valor){
        ContaAbstrata conta1, conta2;
        conta1 = procurar(origem);
        conta2 = procurar(destino);
        if(conta1!=null && conta2!=null){
            conta1.debitar(valor);
            conta2.creditar(valor);
        }else{
            System.out.println("Impossível transferir! Uma das contas não existem.");
        }
    }
    
    public void renderJuros(String numero){
        ContaAbstrata conta;
        conta = procurar(numero);
        if(conta !=null){
            if(conta instanceof ContaPoupanca){
                ((ContaPoupanca)conta).renderJuros(juros);
            }else{
                System.out.println("A conta informada não é uma conta poupança!");
            }
        }else{
            System.out.println("A conta não existe!");
        }
        
    }
    
    public void renderBonus(String numero){
        ContaAbstrata conta;
        conta = procurar(numero);
        if(conta!=null){
            if(conta instanceof ContaEspecial){
                ((ContaEspecial)conta).renderBonus();
            }else{
                System.out.println("A conta não é do tipo Especial");
            }
        }else{
            System.out.println("A conta não existe");
        }
    }
    
    @Override
    public int numeroContas(){
        return contas.tamanho();
    }
    
    @Override
    public double saldoTotal(){
        double saldoTotal = 0;
        ContaAbstrata conta[] = contas.listar();
        for(ContaAbstrata c : conta){
            saldoTotal+= c.saldo();
        }
        return saldoTotal;
    }
    
}
