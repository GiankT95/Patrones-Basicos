package actividad_patrones_basicos;

/**
 * Simulación de creación y eliminación de clientes
 * @author jrudasc
 */

public class Index {
   
    public static void main(String[] arg) {

        ManejadorCliente manejadorCliente = new ManejadorCliente();
        ManejadorTransacciones manejadorTrans = new ManejadorTransacciones();
        
        Cliente cliente1 = new Cliente("Jorge", "Rudas", 1320549864);
        
        Cliente cliente2 = new Cliente("Daniela", "Castillo", 1254897542);
        
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
        
        
        manejadorCliente.guardar(cliente1);
        manejadorCliente.guardar(cliente2);
        
        for (Transaccion t : cuenta1.getListaTrans()){
        
            manejadorTrans.guardar(t);
        }
        
        for (Transaccion t : cuenta1.getListaTrans()){
            
            System.out.println(t.getTipo() +" "+ t.getFecha() +" "+ cuenta1.getTitular().getNombres());
        }
        
        
        //manejadorCliente.eliminar(cliente1);
    }
}
