package servidorWeb;

public class EntraServidor extends Thread{

    private RecursoServidor recurso;

    private int numVeces;

    public EntraServidor(int numVeces, RecursoServidor recurso) {
        this.numVeces = numVeces;
        this.recurso = recurso;
    }

    @Override
    public void run() {
        for (int i = 0; i < numVeces; i++) {
            synchronized (recurso) {
                recurso.incrementarCuenta();
            }

        }

    }
}
