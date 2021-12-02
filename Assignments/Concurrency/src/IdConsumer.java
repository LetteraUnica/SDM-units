import static java.lang.Thread.sleep;

public class IdConsumer implements Runnable {
    private IdGenerator idGenerator;

    public IdConsumer(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public void run() {
        for(int i = 0; i < 25; i++) {
            int id = idGenerator.nextId();
            System.out.println(id);

            try {
                sleep(100, 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
