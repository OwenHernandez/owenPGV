package es.iespuertodelacruz.odhh;

public class Filosofo extends Thread{

    private Plato plato;

    public Filosofo(Plato plato) {
        this.plato = plato;
    }

    @Override
    public void run() {
        plato.comer();
    }
}
