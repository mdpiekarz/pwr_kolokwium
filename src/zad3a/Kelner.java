package zad3a;

class Kelner {
    private int N;
    private boolean[] gotowy;
    private Object monitor;

    public Kelner(int N) {
        this.N = N;
        gotowy = new boolean[N * 2];
        monitor = new Object();
    }

    public void randka(int id) {
        //pary procesów: 0-1,2-3,4-5, itd
        synchronized (monitor) {
            int partnerId = id % 2 == 0 ? id + 1 : id - 1;
            gotowy[id] = true; // Oznacz, że proces jest gotowy
            System.out.println("Proces " + id + " jest gotowy do spotkania");
            if (gotowy[partnerId]) { // Jeśli partner jest gotowy
                System.out.println("Proces " + id + " zajmuje stolik");
                monitor.notify(); // Powiadom partnera
                gotowy[id] = false; // Resetuj gotowość
                try {
                    Thread.sleep((long) (Math.random() * 5000)); // Symulacja spotkania
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Proces " + id + " spotyka się z partnerem");
                System.out.println("Proces " + id + " opuszcza stolik");
                monitor.notify(); // Powiadom partnera o zakończeniu spotkania
            } else {
                try {
                    monitor.wait(); // Powiadom partnera o gotowości
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
