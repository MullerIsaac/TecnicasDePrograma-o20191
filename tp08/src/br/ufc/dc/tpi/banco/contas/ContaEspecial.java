/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.dc.tpi.banco.contas;

/**
 *
 * @author Lucas
 */
public class ContaEspecial extends Conta {
    
    private double bonus;
    private double taxaBonus = 0.01;
    
    public ContaEspecial(String numero) {
        super(numero);
        bonus = 0;
    }
    
    public void renderBonus(){
        super.creditar(bonus);
        bonus = 0;
    }
    
    @Override
    public void creditar(double valor){
        bonus += valor*taxaBonus;
        super.creditar(valor);
    }
    
}
