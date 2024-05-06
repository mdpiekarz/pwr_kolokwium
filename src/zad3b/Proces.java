package zad3b;

import java.util.concurrent.ThreadLocalRandom;

class Proces extends Thread {
    private int id;
    private Kelner kelner;

    public Proces(int id, Kelner kelner) {
        this.id = id;
        this.kelner = kelner;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000)); // Symulacja czasu działania procesu
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            kelner.randka(id);
        }
    }
}

