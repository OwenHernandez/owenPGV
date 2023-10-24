package es.iespuertodelacruz.odhh;

import java.util.concurrent.Semaphore;

public class Plato {

    private Semaphore palilloIzq;

    private Plato platoDer;

    private boolean tienePalilloIzq;

    private boolean tienePalilloDer;

    public Plato(Plato platoDer) {
        palilloIzq = new Semaphore(1);
        this.platoDer = platoDer;
        tienePalilloIzq = false;
        tienePalilloDer = false;
    }

    public void cogerIzq() {
        try{
            if (palilloIzq.tryAcquire()) {
                System.out.println("Un filosofo cogio un palillo izquierdo");
                palilloIzq.acquire();
                tienePalilloIzq = true;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void cogerDer() {
        try {
            if (platoDer.palilloIzq.tryAcquire()) {
                System.out.println("un filosofo ha cogido el palillo del plato derecho");
                platoDer.palilloIzq.acquire();
                tienePalilloDer = true;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void comer() {
        while (!tienePalilloDer || !tienePalilloIzq) {
            int rnd = (int)(Math.random()*(11-0)+0);
            if (rnd < 3 && !tienePalilloDer) {
                cogerDer();
            } else if (rnd < 6 && !tienePalilloIzq) {
                cogerIzq();
            } else {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        try {
            System.out.println("Un filosofo ha comido");
            Thread.sleep(2000);
            palilloIzq.release();
            platoDer.palilloIzq.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Semaphore getPalilloIzq() {
        return palilloIzq;
    }

    public void setPalilloIzq(Semaphore palilloIzq) {
        this.palilloIzq = palilloIzq;
    }

    public Plato getPlatoDer() {
        return platoDer;
    }

    public void setPlatoDer(Plato platoDer) {
        this.platoDer = platoDer;
    }

    public boolean isTienePalilloIzq() {
        return tienePalilloIzq;
    }

    public void setTienePalilloIzq(boolean tienePalilloIzq) {
        this.tienePalilloIzq = tienePalilloIzq;
    }

    public boolean isTienePalilloDer() {
        return tienePalilloDer;
    }

    public void setTienePalilloDer(boolean tienePalilloDer) {
        this.tienePalilloDer = tienePalilloDer;
    }
}
