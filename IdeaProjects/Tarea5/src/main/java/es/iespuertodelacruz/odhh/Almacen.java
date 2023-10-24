package es.iespuertodelacruz.odhh;

import java.util.Stack;
import java.util.concurrent.Semaphore;

public class Almacen {

    private Stack<Character> datos;

    public Almacen() {
        datos = new Stack();
    }

    public synchronized void almacenarDatos(char dato) {
        try{
            while (datos.size() >= 6) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        datos.push(dato);
        System.out.println("Almacenado otro dato, tamaño: " + datos.size());
        this.notify();
    }

    public synchronized void sacarDatos() {
        try{
            while (datos.isEmpty()) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        datos.pop();
        System.out.println("Consumido otro dato, tamaño: " + datos.size());
        this.notify();
    }
}
