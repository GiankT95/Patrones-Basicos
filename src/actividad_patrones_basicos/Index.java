package actividad_patrones_basicos;

/**
 * Simulación de creación y eliminación de clientes
 * @author jrudasc
 */

public class Index {
   
    public static void main(String[] arg) {

        ManejadorCliente manejadorCliente = new ManejadorCliente();
        
        Cliente cliente1 = new Cliente("Jorge", "Rudas", 1320549864, 500450, 656150);
        
        Cliente cliente2 = new Cliente("Daniela", "Castillo", 1254897542, 780500, 435200);
        
        manejadorCliente.guardar(cliente1);
        manejadorCliente.guardar(cliente2);
        
        //manejadorCliente.eliminar(cliente1);
    }
}
