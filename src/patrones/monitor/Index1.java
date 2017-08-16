/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.monitor;

/**
 *
 * @author jrudascas
 */
public class Index1 {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1, 1});

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        
        Cajera cajera1 = new Cajera("Cajera 1", cliente1, initialTime);
        Cajera cajera2 = new Cajera("Cajera 2", cliente2, initialTime);

        cajera1.procesarCompra();
        cajera2.procesarCompra();
        
        /*
        CajeraThread cajera3 = new CajeraThread("Cajera 3", cliente1, initialTime);
        CajeraThread cajera4 = new CajeraThread("Cajera 4", cliente2, initialTime);
        
        cajera3.start();
        cajera4.start();
        */
    }
}
