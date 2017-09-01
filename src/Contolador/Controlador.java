/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contolador;

import Modelo.Banco;
import Modelo.Cajera;
import Modelo.Cliente;
import Modelo.ManejadorConstantes;
import Vista.Interfaz;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class Controlador {
    
    public Banco banco;
    
    
    public Controlador(){
        
        banco = new Banco("Davivienda");
        
        this.setBanco(banco);
        
    }
    
    public synchronized void agregarCajeras(){
        
        this.getBanco().crearCajeras();
    }
    
    public static synchronized void moverFila(){
        Interfaz.modelo1.remove(0);
    }
    
    public synchronized Cliente agregarCliente(String nombre, String apellido, int cedula){
        
        Cliente e = new Cliente(nombre, apellido, cedula);
        
        banco.agregarCliente(e);

        return e;
    }
    
    public void eliminarCliente(Cliente e){
        
        banco.getListaClientes().remove(e);        
    }
    
    public void eliminarCajera(Cajera c){
        
        banco.getListaCajeras().remove(c);        
    }
    
    public static synchronized void mostrarProceso(String t, String n, String a, int i, int tiempo){
        
        Interfaz.areaConsola.append(String.format(ManejadorConstantes.MOSTRAR_PROCESO_INTERFAZ, t,n,a,i, tiempo));
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
 
    
    
}
