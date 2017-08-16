package actividad_patrones_basicos;

import java.util.ArrayList;

/**
 * Simulación de creación y eliminación de clientes
 * @author jrudasc
 */

public class Index {
   
    public static void main(String[] arg) {

        ManejadorCliente manejadorCliente = new ManejadorCliente();
        ManejadorTransacciones manejadorTrans = new ManejadorTransacciones();
        
        Cliente cliente1 = new Cliente("Jorge", "Rudas", 123456);
        
        Cliente cliente2 = new Cliente("Daniela", "Castillo", 7890458);
        
        ArrayList<Cliente> listaClientes = new ArrayList();
        
        Cuenta cuenta1 = new CuentaAhorros(850000);
        Cuenta cuenta2 = new CuentaCorriente(500000);
        
        Cuenta cuenta3 = new CuentaAhorros(745600);
        Cuenta cuenta4 = new CuentaCorriente(985800);
        
        cliente1.agregarCuenta(cuenta1);
        cliente1.agregarCuenta(cuenta2);
        
        cliente2.agregarCuenta(cuenta3);
        cliente2.agregarCuenta(cuenta4);
        
        cliente1.retirarDinero(50000, cuenta1);
        cliente1.depositarDinero(15000, cuenta1);
        cliente1.retirarDinero(45000, cuenta2);
        cliente1.depositarDinero(100000, cuenta2);
        
        cliente2.retirarDinero(150000, cuenta3);
        cliente2.depositarDinero(185000, cuenta3);
        cliente2.retirarDinero(505000, cuenta4);
        cliente2.depositarDinero(265000, cuenta4);
        
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        
        for (Cliente c : listaClientes){
            manejadorCliente.guardar(c);
        }
        
        for(Cliente c : listaClientes){
            for(Cuenta e : c.getListaCuentas()){
                for (Transaccion t : e.getListaTrans()){
                    manejadorTrans.guardar(t);
                }
            }    
        }
        
        //manejadorCliente.guardar(cliente2);
        //manejadorCliente.eliminar(cliente2);
    }
}
