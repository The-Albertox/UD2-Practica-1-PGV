import net.salesianos.client.Client;
import net.salesianos.farmer.Farmer;
import net.salesianos.farmer.classes.Storage;

public class App {
    public static void main(String[] args) throws Exception {
        int storageCapacity = 3; // Capacidad máxima del almacén
        int farmerPlantCapacity = 5; // Cantidad de verduras a plantar

        Storage storage = new Storage(storageCapacity);

        // Un único productor
        Farmer farmer = new Farmer("Khal-175", storage, farmerPlantCapacity);

        Client client = new Client("El Juan", storage, 5);

        farmer.start();
        client.start();

        farmer.join();
        client.join();

        System.out.println("fin.");
    }
}
