package Modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Simulación de creación y eliminación de clientes
 * @author jrudasc
 */

public class Index {
       
    public synchronized static void main(String[] arg) throws IOException {
        
        ManejadorCliente manejadorCliente = new ManejadorCliente();
        ManejadorCuentas manejadorCtas = new ManejadorCuentas();
        ManejadorTransacciones manejadorTrans = new ManejadorTransacciones();
        
        Banco banco = new Banco("Davivienda");
        
        //banco.crearCajeras(5);
        
        Cliente c1 = new Cliente("Jorge", "Rudas", 1673728);
        Cliente c2 = new Cliente("Daniela", "Castillo", 1890458);
        Cliente c3 = new Cliente("Giancarlo", "Tovar", 10262937);
        Cliente c4 = new Cliente("Maria", "Rodriguez", 14296782);
        Cliente c5 = new Cliente("Juan", "Martinez", 1892362);
        Cliente c6 = new Cliente("Nicolas", "Perez", 1723621);
        Cliente c7 = new Cliente("Alejandra", "Acosta", 1383272);
        
        /*banco.crearCajeras();
        banco.crearCajeras();
        banco.crearCajeras();
        
        synchronized(banco.getListaClientes()){
            banco.agregarCliente(c1);
            banco.agregarCliente(c2);
            banco.agregarCliente(c3);
            banco.agregarCliente(c4);
            banco.agregarCliente(c5);
            banco.agregarCliente(c6);
            banco.agregarCliente(c7);
            banco.getListaClientes().notifyAll();   
        }*/
        
        for(Transaccion t : c1.getListaTrans()){
            System.out.println(t.toString());
        }
        
        /*for(Cajera c: banco.getListaCajeras()){
       
            System.out.println("Cajera " + c.getIndex());
        }
        System.out.println("---------------");
        */
        
        
        
        /*Cajera cajera1 = new Cajera(1, initialTime);
        Cajera cajera2 = new Cajera(2, initialTime);
        
        banco.agregarCajera(cajera1);
        banco.agregarCajera(cajera2);
        
        banco.agregarCliente(c1);
        banco.agregarCliente(c2);
        banco.agregarCliente(c3);
        banco.agregarCliente(c4);
        banco.agregarCliente(c5);
        banco.agregarCliente(c6);
        banco.agregarCliente(c7);
        
        c1.transaccionAleatoria(500000);
        c2.transaccionAleatoria(250000);
        c3.transaccionAleatoria(485000);
        c4.transaccionAleatoria(125000);
        c5.transaccionAleatoria(340000);
        c6.transaccionAleatoria(180000);
        c7.transaccionAleatoria(90000);
        

        cajera1.start();
        cajera2.start();
        
        /*manejadorCliente.crearArchivo();
        manejadorCtas.crearArchivo();
        manejadorTrans.crearArchivo();
        
        if(manejadorCliente.listarClientes().isEmpty() && manejadorCtas.listarCuentas().isEmpty()){
           for (Cliente c : listaClientes){
             manejadorCliente.guardar(c);
                for(Cuenta e : c.getListaCuentas()){
                    manejadorCtas.guardar(e);
                }
            }
        }   
      
        for (Cliente c : listaClientes){
            manejadorCliente.verificarCliente(c);
            for(Cuenta e : c.getListaCuentas()){
                manejadorCtas.verificarCuenta(e);
            }
        }
        
        for(Cliente c : listaClientes){
            for(Cuenta e : c.getListaCuentas()){
                for (Transaccion t : e.getListaTrans()){
                    manejadorTrans.guardar(t);
                }
            }    
        }*/
    }
    
}
