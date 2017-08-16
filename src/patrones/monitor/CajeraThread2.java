package patrones.monitor;

public class CajeraThread2 extends Thread {

    private String nombre;

    private long initialTime;

    public CajeraThread2(String nombre, long initialTime) {
        this.nombre = nombre;
        this.initialTime = initialTime;
    }

    public String getNombre() {
        return nombre;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        procesarCompra();
    }

    public void procesarCompra() {
        try {
            while (true) {
                Cliente cliente = Index2.siguienteCliente();

                for (int i = 0; i < cliente.getCarroCompra().length; i++) {
                    this.esperarXsegundos(cliente.getCarroCompra()[i]);
                    Index2.cont++;
                    System.out.println(Index2.cont + ") Procesado el producto " + (i + 1)
                            + " del " + cliente.getNombre() + " por " + this.nombre + "->Tiempo: "
                            + (System.currentTimeMillis() - this.initialTime) / 1000
                            + "seg");
                }
            }
        } catch (Exception e) {
            System.out.println("La cajera " + this.nombre + " no tiene mas clientes que atender!");
        }
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
