package actividad_patrones_basicos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simulación de creación y eliminación de clientes
 * @author jrudasc
 */

public class Index {
   
    public static void main(String[] arg) {

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
        
        /*cliente1.retirarDinero(50000, cuenta1);
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
            for(Cuenta e : c.getListaCuentas()){
                manejadorCtas.guardar(e);
            }
        }
        
        for(Cliente c : listaClientes){
            for(Cuenta e : c.getListaCuentas()){
                for (Transaccion t : e.getListaTrans()){
                    manejadorTrans.guardar(t);
                }
            }    
        }*/
        
        while(true){
            
            do{
                System.out.println("Seleccione un cliente:\n");
                System.out.println("1 --> Jorge Rudas\n");
                System.out.println("2 --> Daniela Castillo\n");
                
                opc = sc.nextInt();
                
                if(opc!=1 || opc!=2){
                    System.out.println("\nDIGITE UNA OPCION VALIDA\n");
                }
            }while(opc<1 || opc>2);
            
            do{
                if(opc == 1){

                    System.out.println(cliente1.toString());

                    for(Cuenta c : cliente1.getListaCuentas()){
                        System.out.printf(ManejadorConstantes.FORMATO_LISTA_CUENTAS_CONSOLA, c.getTipo(),c.getBalance());
                    }
                    
                    System.out.println("\n(1) Retirar dinero");
                    System.out.println("(2) Depositar dinero");
                    System.out.println("(3) Ver historial de transacciones");
                    System.out.println("(4) Volver al menu");
                    System.out.println("Digite una opcion: ");
                    
                    opc = sc.nextInt();
                    
                    System.out.println("\n");
                    
                    if(opc == 1){
                       
                        int monto;
                        int cta;
                        int cont=1;
                        
                        for(Cuenta c : cliente1.getListaCuentas()){
                            System.out.printf("(%d)"+ManejadorConstantes.FORMATO_LISTA_CUENTAS_CONSOLA, cont, c.getTipo(),c.getBalance());
                            cont++;
                        }
                       
                        do{
                            System.out.println("Seleccione la cuenta de la que va a retirar: ");
                            cta = sc.nextInt();
                        }while(cta<1 || cta>2);
                        
                        do{
                            System.out.println("\nDigite la cantidad que va a retirar: ");
                            monto = sc.nextInt();
                        }while(monto<0);
                        
                        if(cta==1){
                            cliente1.retirarDinero(monto, cuenta1);
                        }
                        if(cta==2){
                            cliente1.retirarDinero(monto, cuenta2);
                        }
                        
                    }
                    
                    if(opc==2){
                        
                        int monto;
                        int cta;
                        int cont=1;
                        
                        for(Cuenta c : cliente1.getListaCuentas()){
                            System.out.printf("(%d)"+ManejadorConstantes.FORMATO_LISTA_CUENTAS_CONSOLA, cont, c.getTipo(),c.getBalance());
                            cont++;
                        }
                       
                        do{
                            System.out.println("Seleccione la cuenta a la que va a depositar: ");
                            cta = sc.nextInt();
                        }while(cta<1 || cta>2);
                        
                        do{
                            System.out.println("\nDigite la cantidad que va a depositar: ");
                            monto = sc.nextInt();
                        }while(monto<0);
                        
                        if(cta==1){
                            cliente1.depositarDinero(monto, cuenta1);
                        }
                        if(cta==2){
                            cliente1.depositarDinero(monto, cuenta2);
                        }
                        
                        
                    }
                    
                    if(opc==3){
                        for(Cuenta e : cliente1.getListaCuentas()){
                            for(Transaccion t : e.getListaTrans()){
                                if(e.getListaTrans().isEmpty()){
                                    System.out.println("No ha realizado ninguna transaccion\n");
                                }
                                else{
                                    System.out.printf(ManejadorConstantes.FORMATO_TRANSACCION_CONSOLA, t.getFecha(), t.getTipo(), t.getMonto(), t.getCuenta().getTipo());
                                }
                            }
                        }
                    }
                    
                }
                
                if(opc<1 || opc>4){
                    System.out.println("\nDIGITE UNA OPCION VALIDA\n");
                }
            }while(opc==1 || opc ==2 || opc==3 || opc==4);
        }
        
    }
}
