package net.salesianos.farmer.classes;

import java.util.LinkedList;
import java.util.Queue;

public class Storage {
    private final Queue<Vegetable> storage = new LinkedList<>();
    private final int maxCapacity;

    public Storage(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public synchronized void storage(Vegetable vegetable, String name) throws InterruptedException {
        while (storage.size() == maxCapacity) {
            System.out.println("Almacén lleno. Granjero espera.");
            wait();
        }
        storage.add(vegetable);
        System.out.println("Granjero llevó al restaurante: " + vegetable);
        notifyAll();
    }

    public synchronized Vegetable consume(String client) throws InterruptedException {
        while (storage.isEmpty()) {
            System.out.println(client + " espera porque el almacén está vacío.");
            wait();
        }
        Vegetable vegetable = storage.poll();
        System.out.println(client + " consumió: " + vegetable);
        notifyAll();
        return vegetable;
    }
}