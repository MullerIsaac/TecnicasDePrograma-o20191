/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.dc.tpi.banco.contas;


public class Conta extends ContaAbstrata{
    
    public Conta(String numero){
        super(numero);
    }
    
    @Override
    public void debitar(double valor){
        saldo -= valor;
    }
    
    
}
