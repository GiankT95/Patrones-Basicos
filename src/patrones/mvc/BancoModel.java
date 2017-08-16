/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jrudascas
 */
public class BancoModel {

    private String nombre;
    private final float tasaPorDefecto = 0.024f;
    private final float porcentajeCapacidadPago = 0.3f;
    private List<ClienteModel> listClientes;

    public BancoModel(String nombre, List<ClienteModel> listClientes) {
        this.nombre = nombre;
        this.listClientes = listClientes;
    }

    public BancoModel(String nombre) {
        this.nombre = nombre;
        this.listClientes = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public float getTasaPorDefecto() {
        return tasaPorDefecto;
    }

    public List<ClienteModel> getListClientes() {
        return listClientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListClientes(List<ClienteModel> listClientes) {
        this.listClientes = listClientes;
    }

    public void addCliente(ClienteModel c) {
        listClientes.add(c);
    }

    private boolean validarViabilidadSolicitudCredito(ClienteModel e, int monto, int plazo) {
        if (e.getIngresos() * porcentajeCapacidadPago * plazo > e.getMontoCredito()) {
            return e.getIngresos() * porcentajeCapacidadPago > monto / plazo;
        } else {
            return false;
        }
    }

    private void aprobarSolicitudCredito(ClienteModel e, int monto, int plazo) {
        e.setMontoCredito(monto);
    }

    public void recibirSolicitudCredito(ClienteModel e, int monto, int plazo) throws Exception {
        if (validarViabilidadSolicitudCredito(e, monto, plazo)) {
            aprobarSolicitudCredito(e, monto, plazo);
            System.out.println("La solicitud recibida por " + e.getNombres());
        } else {
            throw new Exception("Solicitud rechazada");
        }
    }
}
