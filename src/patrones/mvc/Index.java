/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.mvc;

/**
 *
 * @author jrudascas
 */
public class Index {

    public static void main(String[] arg) {
        BancoModel bancolombia = new BancoModel("Bancolombia");
        short a = 10000;
        ClienteModel cliente1 = new ClienteModel(123, "Jorge", "Rudas", 23, 1000000);
        ClienteModel cliente2 = new ClienteModel(123, "Ana", "Perez", 43, 3300000);
        ClienteModel cliente3 = new ClienteModel(123, "Lucas", "Castro", 67, 27000000);

        bancolombia.addCliente(cliente1);
        bancolombia.addCliente(cliente2);
        bancolombia.addCliente(cliente3);

        for (ClienteModel e : bancolombia.getListClientes()) {
            System.out.println(e.getMontoCredito());
        }

        try {
            bancolombia.recibirSolicitudCredito(cliente1, 1000000, 36);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (ClienteModel e : bancolombia.getListClientes()) {
            System.out.println(e.getMontoCredito());
        }
    }
}
