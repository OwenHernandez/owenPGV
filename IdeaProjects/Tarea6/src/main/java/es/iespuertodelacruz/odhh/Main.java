package es.iespuertodelacruz.odhh;

public class Main {
    public static void main(String[] args) {

        Plato p1 = new Plato(null);
        Plato p2 = new Plato(p1);
        Plato p3 = new Plato(p2);
        Plato p4 = new Plato(p3);
        Plato p5 = new Plato(p4);
        p1.setPlatoDer(p5);
        Filosofo f1 = new Filosofo(p1);
        Filosofo f2 = new Filosofo(p2);
        Filosofo f3 = new Filosofo(p3);
        Filosofo f4 = new Filosofo(p4);
        Filosofo f5 = new Filosofo(p5);


        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();
    }
}
