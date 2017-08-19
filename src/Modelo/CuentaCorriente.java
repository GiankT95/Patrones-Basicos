/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Asus
 */
public class CuentaCorriente extends Cuenta{
    
    public CuentaCorriente(int balance){
        this.balance = balance;
        this.setTipo("CORRIENTE");
    }
    
    @Override
    public String toString() {
        
        return String.format(ManejadorConstantes.FORMATO_LISTA_CUENTAS, this.getTipo(), this.getBalance(), this.getTitular().getNombres(), this.getTitular().getApellidos());
    }

    @Override
    public void agregarTransaccion(Transaccion t) {
        this.getListaTrans().add(t);
    }
}
