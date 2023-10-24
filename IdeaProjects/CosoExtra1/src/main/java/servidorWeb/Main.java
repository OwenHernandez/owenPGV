package servidorWeb;


public class Main {
    public static void main(String[] args) {
        RecursoServidor recurso = new RecursoServidor();

        EntraServidor serv1 = new EntraServidor(10, recurso);
        EntraServidor serv2 = new EntraServidor(2, recurso);
        EntraServidor serv3 = new EntraServidor(6, recurso);
        EntraServidor serv4 = new EntraServidor(20, recurso);

        serv1.start();
        serv2.start();
        serv3.start();
        serv4.start();

        /*for (int i = 0; i <= 10; i++) {
            (new EntraServidor("Entra el hilo " + i, recurso)).start();
        }*/
    }
}
