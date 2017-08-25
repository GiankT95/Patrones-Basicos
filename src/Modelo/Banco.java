/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fuller 101
 */
public class Banco {
    
    private String nombre;
    private static ArrayList<Cliente> listaClientes;
    private ArrayList<Cajera> listaCajeras;
    public static Iterator clientes;
    
    public Banco(String nombre){
        this.nombre = nombre;
        listaClientes = new ArrayList();
        listaCajeras = new ArrayList();        
    }
    
    public void agregarCliente(Cliente clienteNuevo){        
        this.listaClientes.add(clienteNuevo);
    }
    
    public void eliminarCliente(Cliente c){
        this.listaClientes.remove(c);
    }
    
    public void agregarCajera(Cajera cajeraNueva){
        this.listaCajeras.add(cajeraNueva);        
    }
    
    public void eliminarCajera(Cajera c){
        this.listaCajeras.remove(c);
    }
    
    public synchronized static Cliente siguienteCliente() throws Exception {
        if(!listaClientes.isEmpty()){
            Cliente aux = listaClientes.get(0);
            listaClientes.remove(0);
            
            return aux;
        }
        else{
           throw new Exception("No hay mas clientes por atender");
        }
    }
    
    public void iniciarCajeras(){
        
        for(Cajera c : this.listaCajeras){
            c.start();
        }
    }
    
    public void detenerCajeras(){
        
        for(Cajera c : this.listaCajeras){
            c.stop();
        }
    }

    public int numClientes(){
        return this.listaClientes.size();
    }
    
    public int numCajeras(){
        return this.listaCajeras.size();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Cajera> getListaCajeras() {
        return listaCajeras;
    }

    public void setListaCajeras(ArrayList<Cajera> listaCajeras) {
        this.listaCajeras = listaCajeras;
    }

    public static Iterator getClientes() {
        return clientes;
    }

    public static void setClientes(Iterator clientes) {
        Banco.clientes = clientes;
    }
    
    
}
