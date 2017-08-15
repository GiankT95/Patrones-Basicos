/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad_patrones_basicos;

/**
 *
 * @author Asus
 */
public class CuentaCorriente extends Cuenta{
    
    public CuentaCorriente(int balance){
        this.balance = balance;
    }

    @Override
    public void hacerDebito(int monto) { 
        Transaccion t = new Transaccion("Debito");
     
        this.setBalance(balance - monto);
        
        this.getListaTrans().add(t);
    }
    
    @Override
    public void hacerCredito(int monto) {
        Transaccion t = new Transaccion("Credito");
        
        this.setBalance(balance + monto);
        
        this.getListaTrans().add(t);
    }
}
