package zad1b;

class MojWatek implements Runnable {
    private int numer;

    public MojWatek(int numer) {
        this.numer = numer;
    }

    public void run() {
        System.out.println("Proces" + numer + " rozpoczyna działanie.");
        // Symulacja działania wątku
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Proces" + numer + " kończy działanie.");
    }
}
