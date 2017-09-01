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
    private static ArrayList<Cajera> listaCajeras;
    
    public Banco(String nombre){
        this.nombre = nombre;
        listaClientes = new ArrayList();
        listaCajeras = new ArrayList();        
    }
    
    public synchronized void agregarCliente(Cliente clienteNuevo){        
        
        synchronized(listaClientes){
            listaClientes.add(clienteNuevo);
            listaClientes.notifyAll();
        }
    }
    
    public void eliminarCliente(Cliente c){
        this.listaClientes.remove(c);
    }
    
    
    public synchronized void crearCajeras(){

        long initialTime = System.currentTimeMillis();

        if(getListaCajeras().isEmpty()){
            int x = 1;

            Cajera cajera = new Cajera(x, initialTime);
            agregarCajera(cajera);
            cajera.start();
        }
        
        else{
            int x = getListaCajeras().size()+1;

            Cajera cajera = new Cajera(x, initialTime);
            agregarCajera(cajera);
            cajera.start();
        }
        
    }
    
    public synchronized void agregarCajera(Cajera cajeraNueva){
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

    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public static ArrayList<Cajera> getListaCajeras() {
        return listaCajeras;
    }

    public void setListaCajeras(ArrayList<Cajera> listaCajeras) {
        this.listaCajeras = listaCajeras;
    }
    
    
}
