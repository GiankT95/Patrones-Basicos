/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad_patrones_basicos;

import java.io.BufferedReader;
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
public class ManejadorTransacciones {
    
        private String ruta = "C:\\Users\\Asus\\Documents\\transacciones.txt";

    public List<Transaccion> listarTransacciones() {
        List<Transaccion> listarTransacciones = new ArrayList();

        try {
            BufferedReader br = ManejadorArchivos.abrirArchivoLectura(ruta);
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");
                listarTransacciones.add(new Transaccion(campos[0].trim()));
            }

            ManejadorArchivos.cerrarArchivo();
            return listarTransacciones;
        } catch (IOException ex) {
            Logger.getLogger(Transaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean guardar(Transaccion t) {
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

            pw.println(t.toString());

            ManejadorArchivos.cerrarArchivo();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Transaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean eliminar(Transaccion t) {
        try {
            BufferedReader br = ManejadorArchivos.abrirArchivoLectura(ruta);
            String contenido = "";
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] campos = linea.split(";");
                if (!(Integer.parseInt(campos[0]) == t.getCuenta().getTitular().getCedula())) {
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
            Logger.getLogger(Transaccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
