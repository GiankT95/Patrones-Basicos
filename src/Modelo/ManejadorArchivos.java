/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ManejadorArchivos {

    public static FileWriter fichero = null;
    public static PrintWriter pw = null;
    public static FileReader fr = null;
    public static BufferedReader br = null;

    public static BufferedReader abrirArchivoLectura(String ruta) {
        try {
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);
            return br;
        } catch (Exception e) {
        }
        return null;
    }

    public static PrintWriter abrirArchivoEscritura(String ruta) {
        try {
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);
            return pw;
        } catch (Exception e) {
        }
        return null;
    }

    public static void cerrarArchivo() {
        try {
            if (null != fichero) {
                fichero.close();
            }
            if (null != fr) {
                fr.close();
            }

            if (null != br) {
                br.close();
            }
            if (null != pw) {
                pw.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
