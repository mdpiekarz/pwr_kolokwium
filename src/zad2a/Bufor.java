package zad2a;

import java.util.concurrent.Semaphore;

class Bufor {
    private int[] bufor;
    private int indexProducenta;
    private int indexKonsumenta;
    private final int ROZMIAR_BUFORA;
    private Semaphore mutex;
    private Semaphore pelny;
    private Semaphore pusty;

    public Bufor(int rozmiarBufora) {
        ROZMIAR_BUFORA = rozmiarBufora;
        bufor = new int[ROZMIAR_BUFORA];
        indexProducenta = 0;
        indexKonsumenta = 0;
        mutex = new Semaphore(1);
        pelny = new Semaphore(0);
        pusty = new Semaphore(ROZMIAR_BUFORA);
    }

    public void dodaj(int liczba) throws InterruptedException {
        pusty.acquire();
        mutex.acquire();
        bufor[indexProducenta] = liczba;
        indexProducenta = (indexProducenta + 1) % ROZMIAR_BUFORA;
        mutex.release();
        pelny.release();
    }

    public int pobierz() throws InterruptedException {
        pelny.acquire();
        mutex.acquire();
        int liczba = bufor[indexKonsumenta];
        indexKonsumenta = (indexKonsumenta + 1) % ROZMIAR_BUFORA;
        mutex.release();
        pusty.release();
        return liczba;
    }
}
