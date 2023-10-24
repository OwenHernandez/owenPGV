package jardin;

public class EntraJardin extends Thread{

    private RecursoJardin recurso;

    public EntraJardin(String nombre, RecursoJardin recurso) {
        this.setName(nombre);
        this.recurso = recurso;
    }

    @Override
    public void run() {
        recurso.incrementarCuenta();
    }
}
