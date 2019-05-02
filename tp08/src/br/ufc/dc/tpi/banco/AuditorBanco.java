
package br.ufc.dc.tpi.banco;

import Interfaces.IBanco;

public class AuditorBanco {
    
    public void auditar(IBanco banco){
        if((banco.saldoTotal()/banco.numeroContas()) > 50){
            System.out.println("Aprovado!");
        }else{
            System.out.println("Não aprovado");
        }
    }
}
