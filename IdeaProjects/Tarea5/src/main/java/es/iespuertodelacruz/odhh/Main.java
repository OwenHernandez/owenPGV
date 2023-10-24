package es.iespuertodelacruz.odhh;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        Productor productor = new Productor(almacen);

        Consumidor consumidor = new Consumidor(almacen);

        productor.start();
        consumidor.start();
    }
}
