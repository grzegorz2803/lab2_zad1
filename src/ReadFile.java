import java.io.*;


public class ReadFile implements Runnable{

Read read;
    public ReadFile(Status status) {
         read = new Read(status);
    }



    @Override
    public void run() {
        read.readFile();
        try {

                char klawisz = (char) System.in.read();
                if (klawisz == 'k') {
                    System.exit(0);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
