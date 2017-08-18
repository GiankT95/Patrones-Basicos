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
    public static Iterator clientes;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Cajera> listaCajeras;
    
    public Banco(String nombre){
        this.nombre = nombre;
        listaClientes = new ArrayList();
        listaCajeras = new ArrayList();
    }
    
    public Cliente agregarCliente(String nombre, String apellido,int cedula){
        Cliente clienteNuevo = new Cliente(nombre, apellido, cedula);
        this.listaClientes.add(clienteNuevo);
        
        return clienteNuevo;
    }
    
    public void eliminarCliente(Cliente c){
        this.listaClientes.remove(c);
    }
    
    public Cajera agregarCajera(String nombre, long it){
        Cajera nuevaCajera = new Cajera(nombre, it);
        this.listaCajeras.add(nuevaCajera);
        
        return nuevaCajera;
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

    public ArrayList<Cliente> getClientes() {
        return listaClientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.listaClientes = clientes;
    }

    public ArrayList<Cajera> getCajeras() {
        return listaCajeras;
    }

    public void setCajeras(ArrayList<Cajera> cajeras) {
        this.listaCajeras = cajeras;
    }
    
}
