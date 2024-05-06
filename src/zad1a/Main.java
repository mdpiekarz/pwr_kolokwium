package zad1a;
//Zdefiniuj klasę wątku będącą rozszerzeniem klasy Thread. Napisz program, w którym utworzysz cztery wątki nadając im odpowiednie nazwy (Watek1, Watek2, Watek3, Watek4), uruchomisz je, a następnie każdy wątek, łącznie z głównym, wypisze swoją nazwę.

public class Main {
    public static void main(String[] args) {
        // Tworzenie i uruchamianie wątków
        MojWatek watek1 = new MojWatek("Watek1");
        MojWatek watek2 = new MojWatek("Watek2");
        MojWatek watek3 = new MojWatek("Watek3");
        MojWatek watek4 = new MojWatek("Watek4");

        watek1.start();
        watek2.start();
        watek3.start();
        watek4.start();

        // Wyświetlanie nazwy głównego wątku
        System.out.println("Nazwa głównego wątku: " + Thread.currentThread().getName());
    }
}
