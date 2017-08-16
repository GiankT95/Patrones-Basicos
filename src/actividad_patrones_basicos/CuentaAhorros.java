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
public class CuentaAhorros extends Cuenta{
    
    public CuentaAhorros(int balance){
        this.balance = balance;
    }

    @Override
    public void hacerDebito(int monto) { 
        Transaccion t = new Transaccion("Debito");
        this.listaTrans.add(t);
        this.setBalance(balance - monto);
        t.setCuenta(this);
    }
    
    @Override
    public void hacerCredito(int monto) {
        Transaccion t = new Transaccion("Credito");
        this.listaTrans.add(t);
        this.setBalance(balance + monto);
        t.setCuenta(this);
    }

    @Override
    public String toString() {
        
        return "";
    }
    
    
}
