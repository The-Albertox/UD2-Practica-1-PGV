package net.salesianos.client;

import java.util.Random;

import net.salesianos.farmer.classes.Storage;

public class Client extends Thread {
    private final String name;
    private final Storage storage;
    private final int amountToConsume;

    public Client(String name, Storage storage, int amountToConsume) {
        this.name = name;
        this.storage = storage;
        this.amountToConsume = amountToConsume;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < amountToConsume; i++) {
            try {
                Thread.sleep(random.nextInt(2000) + 1000);
                storage.consume(name);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(name + " fue interrumpido.");
                break;
            }
        }
    }
}