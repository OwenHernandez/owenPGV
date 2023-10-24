package es.iespuertodelacruz.odhh.extensionThreats;

//public class Fibonacci implements Runnable{
public class Fibonacci extends Thread{

    public int parametro;

    public Fibonacci(int parametro) {
        this.parametro = parametro;
    }

    @Override
    public void run() {
        int num1 = 1;
        int num2 = 1;
        while (num1 <= parametro || num2 <= parametro) {
            if (num1 <= parametro) {
                System.out.println("num1: " + num1);
            }
            if (num2 <= parametro) {
                System.out.println("num2: " + num2);
            }
            num1 = num1 + num2;
            num2 = num1 + num2;
        }
    }
}
