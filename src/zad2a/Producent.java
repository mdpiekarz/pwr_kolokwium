package zad2a;

import java.util.Random;

class Producent extends Thread {
    private int numerWatku;
    private Bufor bufor;
    private Random random;

    public Producent(int numerWatku, Bufor bufor) {
        this.numerWatku = numerWatku;
        this.bufor = bufor;
        random = new Random();
    }

    public void run() {
        try {
            System.out.println("Watek numer " + numerWatku + " rozpoczyna prace");
            while (true) {
                Thread.sleep(random.nextInt(5000)); // Czeka losowy czas
                int liczba = numerWatku;
                bufor.dodaj(liczba);
                liczba += numerWatku;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

