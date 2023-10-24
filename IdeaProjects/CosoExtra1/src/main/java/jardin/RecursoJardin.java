package jardin;

public class RecursoJardin {
    private int cuenta;

    public RecursoJardin() {
        this.cuenta = 100;
    }

    public synchronized void incrementarCuenta() {
        System.out.println(Thread.currentThread().getName() + "--> Entra en el jardin");

        cuenta++;

        System.out.println("Hay " + getCuenta() + " personas en el jardin");
    }

    public synchronized void decrementarCuenta() {
        System.out.println(Thread.currentThread().getName() + "--> Sale en el jardin");

        cuenta--;

        System.out.println("Hay " + getCuenta() + " personas en el jardin");
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getCuenta() {
        return cuenta;
    }
}
