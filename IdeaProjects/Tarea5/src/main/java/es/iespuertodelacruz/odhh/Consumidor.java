package es.iespuertodelacruz.odhh;

public class Consumidor extends Thread{

    private Almacen almacen;

    public Consumidor(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            almacen.sacarDatos();
        }
    }
}
