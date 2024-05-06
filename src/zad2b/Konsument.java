package zad2b;

class Konsument extends Thread {
    private Bufor buffer;

    public Konsument(Bufor buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                int data = buffer.get();
                if (data % 2 == 0) {
                    ObsłużParzyste();
                } else {
                    ObsłużNieparzyste();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void ObsłużParzyste() {
        System.out.println("Obsłużono liczbę parzystą.");
    }

    private void ObsłużNieparzyste() {
        System.out.println("Obsłużono liczbę nieparzystą.");
    }
}

