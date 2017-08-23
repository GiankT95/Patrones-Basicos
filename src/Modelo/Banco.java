/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Fuller 101
 */
public class Banco {
    
    private String nombre;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Cajera> listaCajeras;
    public static Iterator clientes;
    
    public Banco(String nombre){
        this.nombre = nombre;
        listaClientes = new ArrayList();
        listaCajeras = new ArrayList();
        clientes = listaClientes.iterator();
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
    
    public static Cliente siguienteCliente() throws Exception {
        if (clientes.hasNext()) {
            return (Cliente) clientes.next();
        } else {
            throw new Exception("No hay mas clientes");
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
