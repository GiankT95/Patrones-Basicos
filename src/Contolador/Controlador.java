/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contolador;

import Modelo.Banco;
import Modelo.Cajera;
import Modelo.Cliente;

/**
 *
 * @author Asus
 */
public class Controlador {
    
    public Banco banco;
    
    public Controlador(){
        
        banco = new Banco("Davivienda");
        
        Cliente c1 = new Cliente("Jorge", "Rudas", 1673728);
        Cliente c2 = new Cliente("Daniela", "Castillo", 1890458);
        Cliente c3 = new Cliente("Giancarlo", "Tovar", 10262937);
        Cliente c4 = new Cliente("Maria", "Rodriguez", 14296782);
        Cliente c5 = new Cliente("Juan", "Martinez", 1892362);
        Cliente c6 = new Cliente("Nicolas", "Perez", 1723621);
        Cliente c7 = new Cliente("Alejandra", "Acosta", 1383272);
                
        long initialTime = System.currentTimeMillis();
        
        Cajera cajera1 = new Cajera("Viviana", initialTime);
        Cajera cajera2 = new Cajera("Camila", initialTime);
        
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
        
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
 
    
    
}
