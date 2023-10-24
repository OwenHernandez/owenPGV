package es.iespuertodelacruz.odhh.extensionThreats;

public class Main {
    public static void main(String[] args) {
        Coche coche1 = new Coche();
        Coche coche2 = new Coche();
        Coche coche3 = new Coche();
        Coche coche4 = new Coche();
        Coche coche5 = new Coche();

        coche1.setTime(100);
        coche2.setTime(2000);
        coche3.setTime(3000);
        coche4.setTime(4000);
        coche5.setTime(5000);

        new Thread(coche1).start();
        new Thread(coche2).start();
        new Thread(coche3).start();
        new Thread(coche4).start();
        new Thread(coche5).start();
        /*
        Fibonacci f = new Fibonacci(20);
        f.start();
        //f.run();
        //new Thread(f).start();
        */

    }
}
