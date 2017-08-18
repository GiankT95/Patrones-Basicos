/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author Fuller 101
 */
public class Cajera extends Thread{
    
    private String nombre;
    private long initialTime;

    public Cajera(String nombre, long initialTime) {
        this.nombre = nombre;
        this.initialTime = initialTime;
    }

    public void procesarTransaccion(){
        try {
            while (true) {
                Cliente cliente = Banco.siguienteCliente();
                
                //this.esperarXsegundos(int seg);
                
            }
        } catch (Exception e) {
            System.out.println("La cajera " + this.nombre + " no tiene mas clientes que atender!");
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }
    
    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
}
