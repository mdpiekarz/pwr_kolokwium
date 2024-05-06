package zad2a;
//Napisz w języku Java program współbieżny, który będzie posiadał dwa typy procesów: P i K oraz korzystał z bufora cyklicznego o rozmiarze ROZMIAR_BUFORA przechowującego liczby całkowite. Program tworzy i startuje 8 wątków P. Każdy wątek rozpoczyna działanie od wyświetlenia komunikatu Watek numer # rozpoczyna prace, gdzie w miejscu # ma się pojawić numer wątku. Następnie każdy wątek, w pętli nieskończonej:
//•
//czeka losowy odcinek czasu (nie więcej niż 5 sekund),
//•
//a potem generuje kolejną wielokrotność liczby będącej numerem wątku (np. wątek o numerze 3 generuje kolejno 3, 6, 9, 12, ...) i wstawia ją do bufora.
//Proces K działa w pętli nieskończonej, odbiera daną z bufora i w zależności od parzystości liczby wykonuje jedną z metod: ObsłużParzyste() albo ObsłużNieparzyste() (metody wyświetlają tylko komunikat o rodzaju obsługiwanej liczby).
//Program należy samodzielnie podzielić na klasy (w rozsądny sposób). Napisz treść procesów P i K. W rozwiązaniu wykorzystaj semafory.

public class Main {
    public static void main(String[] args) {
        int ROZMIAR_BUFORA = 10;
        Bufor bufor = new Bufor(ROZMIAR_BUFORA);

        Producent[] producenci = new Producent[8];
        for (int i = 0; i < producenci.length; i++) {
            producenci[i] = new Producent(i + 1, bufor);
            producenci[i].start();
        }

        Konsument konsument = new Konsument(bufor);
        konsument.start();
    }
}
