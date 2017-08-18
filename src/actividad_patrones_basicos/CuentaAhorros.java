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
    
    ;
    
    public CuentaAhorros(int balance){
        this.balance = balance;
        this.setTipo("AHORROS");
    }

    @Override
    public void hacerDebito(int monto) { 
        Transaccion t = new Transaccion("Debito", monto);
        this.listaTrans.add(t);
        this.setBalance(balance - monto);
        t.setCuenta(this);
        
    }
    
    @Override
    public void hacerCredito(int monto) {
        Transaccion t = new Transaccion("Credito", monto);
        this.listaTrans.add(t);
        this.setBalance(balance + monto);
        t.setCuenta(this);
    }

    @Override
    public String toString() {
        
        return String.format(ManejadorConstantes.FORMATO_LISTA_CUENTAS, this.getTipo(), this.getBalance(), this.getTitular().getNombres(), this.getTitular().getApellidos());
    }
    
}
