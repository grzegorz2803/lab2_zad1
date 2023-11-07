import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Read {
private  BufferedReader reader;

 private  int currentLine;
 private final Lock lock;

 public Read(String fileName)  {
     this.currentLine = 0;
     this.lock = new ReentrantLock();
    try{
        this.reader = new BufferedReader( new FileReader(fileName));
    } catch (IOException e) {
        e.printStackTrace();
    }
 }
 public String[] readLines() {
lock.lock();
try{
    try {
        String l1 = reader.readLine();
        String l2 = reader.readLine();
        if(l1!=null && l2!=null){
            return  new String[]{l1,l2};
        }else {return null;}
    }catch (IOException e){
        e.printStackTrace();
        return null;
    }
}finally {
    lock.unlock();
}
 }

    public int getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(int currentLine) {
        this.currentLine = currentLine;
    }
}
