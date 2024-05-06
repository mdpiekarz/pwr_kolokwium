package zad1a;

class MojWatek extends Thread {
    public MojWatek(String nazwa) {
        super(nazwa);
    }

    public void run() {
        System.out.println("Wątek " + getName() + " uruchomiony");
    }
}