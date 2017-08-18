/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jrudasc
 */
public class ManejadorCliente {

    private String ruta = ManejadorConstantes.FORMATO_RUTA_CLIENTES;

    public List<Cliente> listarClientes() {
        List<Cliente> listarClientes = new ArrayList();

        try {
            BufferedReader br = ManejadorArchivos.abrirArchivoLectura(ruta);
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");
                listarClientes.add(new Cliente(campos[1].trim(), campos[2].trim(), Integer.valueOf(campos[0])));
            }

            ManejadorArchivos.cerrarArchivo();
            return listarClientes;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean guardar(Cliente e) {
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
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean eliminar(Cliente e) {
        try {
            BufferedReader br = ManejadorArchivos.abrirArchivoLectura(ruta);
            String contenido = "";
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] campos = linea.split(";");
                if (!(campos[0].equals(e.getCedula()))) {
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
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void verificarCliente(Cliente e){
        List<Cliente> lista = this.listarClientes();
        boolean b = false;
        
        for (Cliente c : lista) {
            if(e.getCedula() == lista.indexOf(c.getCedula())){
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
