package zad2a;

class Konsument extends Thread {
    private Bufor bufor;

    public Konsument(Bufor bufor) {
        this.bufor = bufor;
    }

    public void run() {
        try {
            while (true) {
                int liczba = bufor.pobierz();
                if (liczba % 2 == 0) {
                    obsluzParzyste();
                } else {
                    obsluzNieparzyste();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void obsluzParzyste() {
        System.out.println("Obsluga liczby parzystej" );
    }

    private void obsluzNieparzyste() {
        System.out.println("Obsluga liczby nieparzystej" );
    }
}


