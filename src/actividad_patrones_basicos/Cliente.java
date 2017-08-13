package actividad_patrones_basicos;

/**
 * Esta clase encapsula las propiedades y comportamientos de un cliente
 * @author jrudascas
 */
public class Cliente {

    private String nombres;
    private String apellidos;
    private int cedula;
    private Cuenta CuentaAhorros;
    private Cuenta CuentaCorriente;

    public Cliente(String nombres, String apellidos, int cedula, int montoAH, int montoCTE) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.CuentaAhorros = new CuentaAhorros(montoAH);
        this.CuentaCorriente = new CuentaCorriente(montoCTE);
    }

    /**
     * Este metodo permite realizar un debito sobre el saldo de su cuenta
     * @param monto Monto a debitar
     */
    
    public void retirarDineroCA(int monto) {
        CuentaAhorros.setBalance(CuentaAhorros.getBalance() - monto);
    }

    public String toString() {
        //return nombres + " " + apellidos;
        return String.format("C.C %10d|%10s %10s| Ahorros %10d| Corriente %10d|", cedula, nombres, apellidos, CuentaAhorros.getBalance(), CuentaCorriente.getBalance());
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

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
}