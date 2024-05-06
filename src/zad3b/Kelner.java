package zad3b;

import java.util.concurrent.Semaphore;

class Kelner {
    private Semaphore[] gotowy;
    private Semaphore monitor;

    public Kelner(int N) {
        gotowy = new Semaphore[N * 2];
        for (int i = 0; i < N * 2; i++) {
            gotowy[i] = new Semaphore(0);
        }
        monitor = new Semaphore(1);
    }

    public void randka(int id) {
        // pary procesów: 0-1, 2-3, 4-5, itd.
        try {
            monitor.acquire();
            int partnerId = id % 2 == 0 ? id + 1 : id - 1;
            gotowy[id].release(); // Oznacz, że proces jest gotowy
            System.out.println("Proces " + id + " jest gotowy do spotkania");
            if (gotowy[partnerId].tryAcquire()) { // Jeśli partner jest gotowy
                System.out.println("Proces " + id + " zajmuje stolik");
                Thread.sleep((long) (Math.random() * 5000)); // Symulacja spotkania
                System.out.println("Proces " + id + " spotyka się z partnerem");
                System.out.println("Proces " + id + " opuszcza stolik");
                gotowy[partnerId].release(); // Powiadom partnera o zakończeniu spotkania
            }
            monitor.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



