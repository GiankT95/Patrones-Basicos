package patrones.monitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Index2 {

    public static List<Cliente> listCliente = new ArrayList();
    public static Iterator clientes;
    public static int cont = 0;

    public static void main(String[] args) {
        listCliente.add(new Cliente("Cliente 1", new int[]{2, 2, 1, 5, 2, 3}));
        listCliente.add(new Cliente("Cliente 2", new int[]{1, 3, 5, 1, 1}));
        listCliente.add(new Cliente("Cliente 3", new int[]{1, 6, 2, 8}));
        listCliente.add(new Cliente("Cliente 4", new int[]{1, 1}));
        listCliente.add(new Cliente("Cliente 5", new int[]{5, 3, 5, 1}));
        listCliente.add(new Cliente("Cliente 6", new int[]{8, 1}));

        clientes = listCliente.iterator();

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        CajeraThread2 cajera1 = new CajeraThread2("Cajera 1", initialTime);
        CajeraThread2 cajera2 = new CajeraThread2("Cajera 2", initialTime);

        cajera1.start();
        cajera2.start();
    }

    //public synchronized static Cliente siguienteCliente() throws Exception {
    public static Cliente siguienteCliente() throws Exception {
        if (clientes.hasNext()) {
            return (Cliente) clientes.next();
        } else {
            throw new Exception("No hay mas clientes");
        }
    }
}
