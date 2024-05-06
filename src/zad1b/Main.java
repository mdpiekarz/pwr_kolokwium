package zad1b;

public class Main {
    public static void main(String[] args) {
        final int NUMER_WATKOW = 30;
        Thread[] watki = new Thread[NUMER_WATKOW];

        for (int i = 0; i < NUMER_WATKOW; i++) {
            watki[i] = new Thread(new MojWatek(i + 1));
            watki[i].start();
        }

        // Czekamy na zakończenie pracy wszystkich wątków
        for (int i = 0; i < NUMER_WATKOW; i++) {
            try {
                watki[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Wszystkie wątki zakończyły pracę.");
    }
}
