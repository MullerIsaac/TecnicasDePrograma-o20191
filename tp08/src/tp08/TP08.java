
package tp08;

import br.ufc.dc.tpi.banco.AuditorBanco;
import br.ufc.dc.tpi.banco.BancoIndependente;
import br.ufc.dc.tpi.banco.VectorContas;
import br.ufc.dc.tpi.banco.contas.Conta;
import br.ufc.dc.tpi.banco.contas.ContaImposto;



public class TP08 {
    
    public static void main(String[] args) {

        AuditorBanco auditor = new AuditorBanco();
        VectorContas contas = new VectorContas();
        BancoIndependente banco = new BancoIndependente(contas);
        
        banco.cadastrar(new Conta("123456-A"));
        banco.creditar("123456-A", 1000);
       
        banco.cadastrar(new ContaImposto("654321-A"));
        banco.creditar("654321-A", 50);
        auditor.auditar(banco);  
        
    }
    
}
