import static java.lang.Thread.sleep;

public class ConcurrencyMain {
    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator();
        Thread thread1 = new Thread(new IdConsumer(idGenerator));
        Thread thread2 = new Thread(new IdConsumer(idGenerator));
        Thread thread3 = new Thread(new IdConsumer(idGenerator));
        Thread thread4 = new Thread(new IdConsumer(idGenerator));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
