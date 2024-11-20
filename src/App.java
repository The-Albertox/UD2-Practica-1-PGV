import net.salesianos.client.Client;
import net.salesianos.farmer.Farmer;
import net.salesianos.farmer.classes.Storage;

public class App {
    public static void main(String[] args) throws Exception {
        int storgeCapacity = 5;
        int farmerVegeCapacity = 10;

        Storage storage = new Storage(storgeCapacity);

        Thread paco = new Thread(new Farmer("Paco", storage, farmerVegeCapacity));
        Thread ramon = new Thread(new Farmer("Ramón", storage, farmerVegeCapacity));

        Thread faustino = new Thread(new Client("Faustino", storage, 5));
        Thread mrGentleman = new Thread(new Client("Mr. Gentleman", storage, 10));
        Thread loquendo = new Thread(new Client("Loquendo", storage, 5));

        paco.start();
        ramon.start();

        paco.setPriority(Thread.MAX_PRIORITY);
        ramon.setPriority(Thread.MAX_PRIORITY);

        faustino.start();
        mrGentleman.start();
        loquendo.start();

        paco.join();
        ramon.join();
        faustino.join();
        mrGentleman.join();
        loquendo.join();
        System.out.println("fin");
    }
}
