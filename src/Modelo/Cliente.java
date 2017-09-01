package Modelo;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Esta clase encapsula las propiedades y comportamientos de un cliente
 * @author jrudascas
 */
public class Cliente {

    private String nombres;
    private String apellidos;
    private int cedula;
    private ArrayList<Cuenta> listaCuentas;
    private ArrayList<Transaccion> listaTrans;


    public Cliente(String nombres, String apellidos, int cedula) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.listaCuentas = new ArrayList();
        this.listaTrans = new ArrayList();
        this.crearCuentas();
        this.transaccionAleatoria();
        
    }

    public void agregarCuenta(Cuenta c) {
        this.listaCuentas.add(c);
        c.setTitular(this);
    }
    
    public void eliminarCuenta(Cuenta c){
        this.listaCuentas.remove(c);
    }
    
    public void retirarDinero(int monto, Cuenta deCuenta) {
        Transaccion t = new Transaccion("Retiro", monto);
        t.hacerDebito(monto, deCuenta);
        this.agregarTransaccion(t);
        t.setCuenta(deCuenta);
    }
    
    public void depositarDinero(int monto, Cuenta aCuenta) {      
        Transaccion t = new Transaccion("Deposito", monto);
        t.hacerCredito(monto, aCuenta);
        this.agregarTransaccion(t);
        t.setCuenta(aCuenta);
    }
    
    public void agregarTransaccion(Transaccion t) {
        this.getListaTrans().add(t);
        t.setCliente(this);
    }
    
    public void transaccionAleatoria(){
        Random rnd = new Random();    
        
        int x = (int) (rnd.nextDouble()*3 + 1);
        
        int cont=0;

        do{
            int r = (int) (rnd.nextDouble()*2 + 1);
            
            if(r == 1){
                int monto = (int) (rnd.nextDouble()*500000 + 10000);
                
                if(monto>this.cuentaAleatoria().getBalance()){
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                            
                }
                else{
                    this.retirarDinero(monto, this.cuentaAleatoria());
                }
            }

            if(r == 2){
                int monto = (int) (rnd.nextDouble()*500000 + 10000);
                
                this.depositarDinero(monto, this.cuentaAleatoria());          
            }
            cont++;
        }while(cont<x);
    }
    
    public Cuenta cuentaAleatoria(){
        Random rnd = new Random();
        int r = (int) (rnd.nextDouble()*this.getListaCuentas().size());
        
        Cuenta c = this.getListaCuentas().get(r);
        
        return c;
    }
    
    private void crearCuentas(){
        Random x = new Random();
        
        int s = (int) (x.nextDouble()*2 + 1);
        int t = (int) (x.nextDouble()*3 + 1);
        
        for(int i=0; i<s; i++){
            int r = (int) (x.nextDouble()*5000000 + 1000000);
            Cuenta a = new CuentaAhorros(r);
            this.agregarCuenta(a);
        }
        
        for(int i=0; i<t; i++){
            int r = (int) (x.nextDouble()*5000000 + 1000000);
            Cuenta b = new CuentaCorriente(r);
            this.agregarCuenta(b);
        }
    }

    @Override
    public String toString() {
        //return nombres + " " + apellidos;
        return String.format(ManejadorConstantes.FORMATO_LISTA_CLIENTES, cedula, nombres, apellidos, this.getListaCuentas().size());
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

    public ArrayList<Transaccion> getListaTrans() {
        return listaTrans;
    }

    public void setListaTrans(ArrayList<Transaccion> listaTransacciones) {
        this.listaTrans = listaTransacciones;
    }

    
      
    
}