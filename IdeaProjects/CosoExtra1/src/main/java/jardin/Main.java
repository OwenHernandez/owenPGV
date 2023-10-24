package jardin;

public class Main {
    public static void main(String[] args) {
        RecursoJardin recurso = new RecursoJardin();
        for (int i = 0; i <= 10; i++) {
            (new EntraJardin("Entra el hilo " + i, recurso)).start();
        }

        for (int i = 0; i <= 15; i++) {
            (new SaleJardin("Sale el hilo " + i, recurso)).start();
        }
    }
}
