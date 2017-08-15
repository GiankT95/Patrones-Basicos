/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad_patrones_basicos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class Transaccion {
    
    private String fecha;
    private String tipo;
    private Cuenta cuenta;

    public Transaccion(String tipo) {
        this.getFecha();
        this.tipo = tipo;
    }
    
    public String getFecha() {
        SimpleDateFormat f = new SimpleDateFormat(ManejadorConstantes.FORMATO_FECHA);
        
        Date d = new Date();
        
        fecha = f.format(d);
        
        return fecha;
    }
    
    @Override
    public String toString() {
      return String.format(ManejadorConstantes.FORMATO_TRANSACCION, this.getFecha(), this.getTipo(), this.getCuenta().getBalance(), this.getCuenta().getTitular().getCedula());
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
    
    
}
