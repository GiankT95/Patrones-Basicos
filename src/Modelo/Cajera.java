/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Contolador.Controlador;
import Vista.Interfaz;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fuller 101
 */
public class Cajera extends Thread {

    private int index;
    private long initialTime;

    public Cajera(int index, long initialTime) {
        this.index = index;
        this.initialTime = initialTime;
    }

    public synchronized void procesarTransaccion() {
    
        try {
            while (true) {
 
                    while(Banco.getListaClientes().isEmpty()){
                        wait();      
                    }
                  
                    Cliente cliente = Banco.siguienteCliente();

                    for(Transaccion t : cliente.getListaTrans()){
                        this.esperarXsegundos(t.getTiempo());

                        System.out.println("Procesada la transaccion (" + t.getTipo() + ") del cliente "
                            + cliente.getNombres() + " " + cliente.getApellidos() + " por la Cajera "
                            + this.getIndex() + "; Tiempo --> " + t.getTiempo()
                            + "seg");
                       
                        
                        Controlador.mostrarProceso(t.getTipo(), cliente.getNombres(), cliente.getApellidos(), index, t.getTiempo());
                    }
      
                
                Controlador.moverFila();
            }
        } catch (Exception e) {
            System.out.println("La cajera " + index + " no tiene mas clientes que atender!");
        }
    }

    @Override
    public void run() {
        procesarTransaccion();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
