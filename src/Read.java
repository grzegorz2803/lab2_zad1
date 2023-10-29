import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Read {
 Status status;

    public Read(Status status) {
        this.status = status;
    }

    File file = new File("file.txt");
    synchronized void readFile(){
        try {

            RandomAccessFile rf = new RandomAccessFile(file, "r");
            rf.seek(status.getPozycja());
            String strLine;
            int i = 0;
            while ((strLine = rf.readLine()) != null) {
                System.out.println(strLine);
                i++;
                if(i==2){
                    break;
                }}
            status.setPozycja(rf.getFilePointer());
            rf.close();
        } catch (IOException e) {
            System.out.println("Błąd dostępu do pliku");
        }
    }
}
