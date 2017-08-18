/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class Transaccion {
    
    private String fecha;
    private String tipo;
    private int monto;
    private int tiempo;
    private Cuenta cuenta;

    public Transaccion(String tipo, int monto) {
        this.getFecha();
        this.tipo = tipo;
        this.monto = monto;
        this.getTiempo();
    }
    
    public String getFecha() {
        SimpleDateFormat f = new SimpleDateFormat(ManejadorConstantes.FORMATO_FECHA);
        
        Date d = new Date();
        
        fecha = f.format(d);
        
        return fecha;
    }
    
    @Override
    public String toString() {
      return String.format(ManejadorConstantes.FORMATO_TRANSACCION, this.getFecha(), this.getTipo(), this.getMonto(), this.getCuenta().getTitular().getNombres(), this.getCuenta().getTitular().getApellidos(), this.getCuenta().getTipo());
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getTiempo() {
        tiempo = (int) (Math.random()*15) + 5;
        
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
}
