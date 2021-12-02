public class IdGenerator {
    private final Object lock = new Object();
    private int id = 0;

    public int nextId() {
        synchronized (lock) {
            id += 1;
            return id;
        }
    }
}
