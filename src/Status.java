public class Status {
    private long pozycja;

    public synchronized long getPozycja() {
        return pozycja;
    }

    public synchronized void setPozycja(long pozycja) {
        this.pozycja = pozycja;
    }
}
