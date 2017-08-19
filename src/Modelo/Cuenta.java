/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public abstract class Cuenta {
    
    public int balance;
    private String tipo;
    public Cliente titular;
    public ArrayList<Transaccion> listaTrans = new ArrayList();

    public abstract void agregarTransaccion(Transaccion t);
    
    
    @Override
    public abstract String toString();
    
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public ArrayList<Transaccion> getListaTrans() {
        return listaTrans;
    }

    public void setListaTrans(ArrayList<Transaccion> listaTrans) {
        this.listaTrans = listaTrans;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
