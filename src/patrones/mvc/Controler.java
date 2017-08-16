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
public class Controler {

    BancoModel banco;

    public Controler() {
        banco = new BancoModel("Bancolombia");

        ClienteModel cliente1 = new ClienteModel(123, "Jorge", "Rudas", 23, 1000000);
        ClienteModel cliente2 = new ClienteModel(123, "Ana", "Perez", 43, 3300000);
        ClienteModel cliente3 = new ClienteModel(123, "Lucas", "Castro", 67, 27000000);

        banco.addCliente(cliente1);

        banco.addCliente(cliente2);

        banco.addCliente(cliente3);
    }

    public BancoModel getBanco() {
        return banco;
    }

    public void setBanco(BancoModel banco) {
        this.banco = banco;
    }
}
