package es.iespuertodelacruz.odhh.extensionThreats;

//public class Coche extends Thread {
public class Coche implements Runnable {

    long time;

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(time);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("Ha llegado el coche: " + /*this*/new Thread().getName());
    }
}
