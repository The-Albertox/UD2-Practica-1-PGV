package net.salesianos.farmer;

import java.util.Random;

import net.salesianos.farmer.classes.Storage;
import net.salesianos.farmer.classes.Vegetable;

public class Farmer extends Thread {
    private final String name;
    private final Storage storage;
    private final int plantCapacity;
    private final String[] vegetables = {
            "lettuce", "cabbage", "onion", "spinach", "potato", "celery",
            "asparagus", "radish", "broccoli", "artichoke", "tomato",
            "cucumber", "eggplant", "carrot", "green bean"
    };

    public Farmer(String name, Storage storage, int plantCapacity) {
        this.name = name;
        this.storage = storage;
        this.plantCapacity = plantCapacity;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < plantCapacity; i++) {
            try {
                String vegetableName = vegetables[random.nextInt(vegetables.length)];
                int growTime = random.nextInt(10000) + 1000;
                Vegetable vegetable = new Vegetable(vegetableName, growTime);

                System.out.println(name + " planta: " + vegetable);
                Thread.sleep(vegetable.getGrowTime());
                storage.storage(vegetable, name);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(name + " fue interrumpido.");
                break;
            }
        }
    }
}
