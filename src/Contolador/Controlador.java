/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contolador;

import Modelo.Banco;
import Modelo.Cajera;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class Controlador {
    
    public Banco banco;
    long initialTime = System.currentTimeMillis();
    
    public Controlador(){
        
        banco = new Banco("Davivienda");
        
        this.setBanco(banco);
        
    }
    
    public synchronized Cajera agregarCajera(String nombre){
        Cajera c = new Cajera(nombre, initialTime);
        banco.getListaCajeras().add(c);
        c.start();
        this.recibirCliente();
        
        return c;
    }
    
    public synchronized Cliente agregarCliente(String nombre, String apellido, int cedula){
        
        Cliente e = new Cliente(nombre, apellido, cedula);
        
        synchronized(banco.getListaClientes()){
        
            banco.getListaClientes().add(e);
            banco.getListaClientes().notify();

        }
        
        return e;
    }
    
    public synchronized void eliminarCliente(Cliente e){
        
        synchronized(banco.getListaClientes()){
        
            banco.getListaClientes().remove(e);
            banco.getListaClientes().notify();

        }
    }
    
    public synchronized Cliente recibirCliente(){
        
        if(banco.getListaClientes().isEmpty()){
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        Cliente cliente = banco.getListaClientes().get(0);
        banco.getListaClientes().remove(0);
        
        return cliente;
        
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
 
    
    
}
