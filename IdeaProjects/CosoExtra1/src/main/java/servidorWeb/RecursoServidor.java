package servidorWeb;

public class RecursoServidor {
    private int cuenta;

    public RecursoServidor() {
        this.cuenta = 0;
    }

    public void incrementarCuenta() {
        System.out.println(Thread.currentThread().getName() + "--> Entra en el servidor");

        cuenta++;

        System.out.println("Hay " + getCuenta() + " personas en el servidor");
    }
    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getCuenta() {
        return cuenta;
    }
}
