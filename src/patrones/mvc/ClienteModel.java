/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package patrones.mvc;

/**
 *
 * @author jrudascas
 */
public class ClienteModel {
    
    private int cedula;
    private String nombres;
    private String apellidos;
    private int edad;
    private int ingresos;
    private int montoCredito = 0;

    public ClienteModel(int cedula, String nombres, String apellidos, int edad, int ingresos) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.ingresos = ingresos;
    }

    public int getCedula() {
        return cedula;
    }
   
    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public int getIngresos() {
        return ingresos;
    }

    public int getMontoCredito() {
        return montoCredito;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    public void setMontoCredito(int montoCredito) {
        this.montoCredito = montoCredito;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }    
    
    @Override
    public String toString(){
        return getCedula() + " - " + getNombres() + " " + getApellidos();
    }
}
