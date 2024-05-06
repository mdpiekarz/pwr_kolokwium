package zad2b;

class Producent extends Thread {
    private int id;
    private Bufor buffer;

    public Producent(int id, Bufor buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            System.out.println("Watek numer " + id + " rozpoczyna prace.");
            try {
                Thread.sleep((long) (Math.random() * 5000)); // Symulacja pracy
                int data = id;
                while (data <= 100) {
                    buffer.put(data);
                    data += id;
                    Thread.sleep((long) (Math.random() * 1000)); // Losowy czas oczekiwania
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

