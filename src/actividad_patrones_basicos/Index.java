package actividad_patrones_basicos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simulación de creación y eliminación de clientes
 * @author jrudasc
 */

public class Index {
   
    public static void main(String[] arg) throws IOException {

        Scanner sc = new Scanner(System.in);
        int opc;
        
        ManejadorCliente manejadorCliente = new ManejadorCliente();
        ManejadorCuentas manejadorCtas = new ManejadorCuentas();
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
        
        manejadorCliente.crearArchivo();
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
 
        
        /*for (Cliente c : listaClientes){
            manejadorCliente.verificarCliente(c);
            for(Cuenta e : c.getListaCuentas()){
                manejadorCtas.verificarCuenta(e);
            }
        }*/
        
        for(Cliente c : listaClientes){
            for(Cuenta e : c.getListaCuentas()){
                for (Transaccion t : e.getListaTrans()){
                    manejadorTrans.guardar(t);
                }
            }    
        }
        
        //manejadorCliente.eliminar(cliente1);
        
    }
}
