package zad3b;
//W systemie działa N par procesów. Procesy z pary są nierozróżnialne. Każdy proces cyklicznie wykonuje własne_sprawy, a potem spotyka się z drugim procesem z pary (metoda randka) w kawiarni przy stoliku dwuosobowym. W kawiarni jest tylko jeden stolik. Procesy mogą zająć stolik tylko wtedy, gdy obydwa są gotowe do spotkania, ale odchodzą od niego pojedynczo (w różnym czasie kończą wykonywanie procedury randka). Napisz treść zadania PROCES oraz KELNER synchronizującego ich działanie. Do synchronizacji użyj semaforów.

public class Main {
    public static void main(String[] args) {
        int N = 5; // liczba par procesów
        Kelner kelner = new Kelner(N);
        Proces[] procesy = new Proces[N * 2];
        for (int i = 0; i < N * 2; i++) {
            procesy[i] = new Proces(i, kelner);
            procesy[i].start();
        }
    }
}