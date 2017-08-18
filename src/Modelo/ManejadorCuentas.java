/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ManejadorCuentas {
    
     private String ruta = ManejadorConstantes.FORMATO_RUTA_CUENTAS;

    public List<Cuenta> listarCuentas() {
        List<Cuenta> listarCuentas = new ArrayList();

        try {
            BufferedReader br = ManejadorArchivos.abrirArchivoLectura(ruta);
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");
                
                if(campos[0].equals("AHORROS")){
                    listarCuentas.add(new CuentaAhorros(Integer.valueOf(campos[1])));
                }
                else{
                    listarCuentas.add(new CuentaCorriente(Integer.valueOf(campos[1])));
                }
            }

            ManejadorArchivos.cerrarArchivo();
            return listarCuentas;
        } catch (IOException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean guardar(Cuenta e) {
        try {
            BufferedReader br = ManejadorArchivos.abrirArchivoLectura(ruta);
            String contenido = "";
            String linea;

            while ((linea = br.readLine()) != null) {
                if (!contenido.isEmpty()) {
                    contenido = contenido + "\r\n" + linea;
                } else {
                    contenido = linea;
                }
            }

            ManejadorArchivos.cerrarArchivo();

            PrintWriter pw = ManejadorArchivos.abrirArchivoEscritura(ruta);
            if (!contenido.isEmpty()) {
                pw.println(contenido);
            }

            pw.println(e.toString());

            ManejadorArchivos.cerrarArchivo();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean eliminar(Cuenta e) {
        try {
            BufferedReader br = ManejadorArchivos.abrirArchivoLectura(ruta);
            String contenido = "";
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] campos = linea.split(";");
                if (!(Integer.parseInt(campos[0]) == e.getTitular().getCedula())) {
                    if (!contenido.isEmpty()) {
                        contenido = contenido + "\r\n" + linea;
                    } else {
                        contenido = linea;
                    }
                }
            }

            ManejadorArchivos.cerrarArchivo();

            PrintWriter pw = ManejadorArchivos.abrirArchivoEscritura(ruta);
            pw.println(contenido);

            ManejadorArchivos.cerrarArchivo();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void verificarCuenta(Cuenta e){
        List<Cuenta> lista = this.listarCuentas();
        boolean b = false;
        
        for (Cuenta c : lista) {
            if(e.getTitular().getCedula() == lista.indexOf(c.getTitular().getCedula())){
                b = true;
            }
            else{
                this.guardar(e);
            }
        }
    }
    
    public void crearArchivo() throws IOException{
        
        File f = new File(ruta);
        
        if(!f.exists()){
            FileWriter fr = new FileWriter(f);
        }
    }
}
