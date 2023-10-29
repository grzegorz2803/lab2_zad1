import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Console console = System.console();
        Status status = new Status();
        status.setPozycja(0);
        //  int tnum = Integer.parseInt(args[0]);
        //  System.out.println("k - zakończ");
        for (int i = 0; i < 1000; i++) {
            ReadFile rf = new ReadFile(status);
            Thread th = new Thread(rf);
            th.start();
            th.join(500);

        }


    }

    }