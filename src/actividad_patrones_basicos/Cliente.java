package actividad_patrones_basicos;

import java.util.ArrayList;

/**
 * Esta clase encapsula las propiedades y comportamientos de un cliente
 * @author jrudascas
 */
public class Cliente {

    private String nombres;
    private String apellidos;
    private int cedula;
    private ArrayList<Cuenta> listaCuentas = new ArrayList();


    public Cliente(String nombres, String apellidos, int cedula) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
    }

    public void agregarCuenta(Cuenta c) {
        this.listaCuentas.add(c);
    }
    
    public void eliminarCuenta(Cuenta c){
        this.listaCuentas.remove(c);
    }
    
    /**
     * Este metodo permite realizar un debito sobre el saldo de su cuenta
     * @param monto Monto a debitar
     */
    
    public void retirarDinero(int monto, Cuenta deCuenta) {      
        
        deCuenta.hacerDebito(monto);
    }
    
    public void depositarDinero(int monto, Cuenta aCuenta) {      
        
        aCuenta.hacerCredito(monto);
    }

    @Override
    public String toString() {
        //return nombres + " " + apellidos;
        return String.format(ManejadorConstantes.FORMATO_LISTA_CLIENTES, cedula, nombres, apellidos);
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getCedula() {
        return cedula;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }
    

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setListaCuentas(ArrayList<Cuenta> ListaCuentas) {
        this.listaCuentas = ListaCuentas;
    }
    
    
}