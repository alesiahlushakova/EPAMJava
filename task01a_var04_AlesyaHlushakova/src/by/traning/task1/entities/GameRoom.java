package by.traning.task1.entities;

import java.util.LinkedList;

/**
 * @author  AlesyaHlushakova
 * storage for toy objects.
 */
public class GameRoom {
    private LinkedList<Toy> toys;
    private int price;

    /**
     * constructs gameroom with already existing devices.
     * @param toys
     */
    public GameRoom(LinkedList<Toy> toys) {
        this.toys = toys;
    }

    /**
     * constructs gameroom without already existing devices.
     */
    public GameRoom() {
        this.toys = new LinkedList<Toy>();
    }

    /**
     *adds toy to storage.
     * @param toy toy to add
     */
    public void addToy(Toy toy) {
        toys.addLast(toy);
    }

    /**
     * removes toy from storage.
     * @param i index to remove
     */
    public void removeByIndex(int i) {

        toys.remove(i);
    }

    /**
     * removes toy by name.
     * @param name name of toy to delete
     */
    public void removeByName(String name) {
        for (Toy toy : toys) {
            if (toy.getName() == name) {
                toys.remove(toy);
            }
        }
    }
}
