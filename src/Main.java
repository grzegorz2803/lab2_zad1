
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        ArrayList<Thread> threads = new ArrayList<>();
        Read read = new Read("file.txt");

        Runnable rt = () -> {
            while (!Thread.currentThread().isInterrupted()){
               int currentLine = read.getCurrentLine();
               String[] lines = read.readLines();
               if(lines == null){
                   break;
               }
                System.out.println(Thread.currentThread().getName() +"  -   "+lines[0]);
                System.out.println(Thread.currentThread().getName()+ "  -   "+lines[1]);
                read.setCurrentLine(currentLine+2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Wątek "+Thread.currentThread().getName()+ " został przerwany");
                    break;
                }
            }

        };
        for (int i=0; i<Integer.parseInt(args[0]);i++){
            Thread th = new Thread(rt);
            threads.add(th);
            th.start();
        }
while (true){
    String userInput = sc.nextLine();
    if(userInput.equalsIgnoreCase("k")){
        threads.forEach(Thread::interrupt);
        break;
    }
}

    }

    }