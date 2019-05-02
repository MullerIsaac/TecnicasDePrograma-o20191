/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.dc.tpi.banco.contas;

public class ContaPoupanca extends Conta {
    
    public ContaPoupanca(String numero) {
        super(numero);
    }
    
    public void renderJuros(double taxa){
         creditar(saldo()*taxa);
    }
}
