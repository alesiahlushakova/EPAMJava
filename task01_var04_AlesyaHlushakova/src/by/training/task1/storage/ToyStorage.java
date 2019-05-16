package by.training.task1.storage;

import by.training.task1.entity.Toy;
import by.training.task1.exception.StorageException;

import java.util.LinkedList;

/**
 * @author Alesya Hlushakova
 * class - storage for toys.
 */
public final class ToyStorage {


    /**
     * toy id.
     */
    private static int currId = 1;



    /**
     * list of toys.
     */
    private LinkedList<Toy> toys;
    /**
     * logger introduction.
     */
    private static final ToyStorage INSTANCE = new ToyStorage();
    /**
     * total price of toys.
     */
    private int totalPrice = 0;

    /**
     * constructor for storage.
     */
    private ToyStorage() {
        this.toys = new LinkedList<>();
    }

    /**
     * get list of toys in storage.
     * @return toy list
     */
    public LinkedList<Toy> getToys() {
        return toys;
    }

    /**
     * sets toys in storage.
     * @param toys list
     */
    public void setToys(final LinkedList<Toy> toys) {
        this.toys = toys;
    }

    /**
     *
     * @return id
     */
    public static int getCurrId() {
        return currId;
    }

    /**
     * sets id.
     * @param currId id
     */
    public static void setCurrId(final int currId) {
        ToyStorage.currId = currId;
    }
    /**
     * singleton realization.
     * @return if game room is single
     */
    public static ToyStorage getInstance() {
        return INSTANCE;
    }

    /**
     * adds toy to storage.
     * @param toy toy to add
     */
    public  void  addToy(final Toy toy) {
        toy.setId(currId);
        toys.addLast(toy);
        totalPrice += toy.getPrice();
        currId++;
    }

    /**
     * takes toy from the storage.
     * @return taken toy
     * @param index index
     * @throws StorageException exception while removing toy
     */
    public Toy takeToy(final int index) throws StorageException {
        if (!toys.isEmpty() || index >= 0 || index < countOfToys()) {
            return toys.get(index);
        } else {
            throw new StorageException("Wrong index or storage is empty");
        }
    }


    /**
     * method counts amount of toys.
     * @return amount of toys in storage
     */
    public int countOfToys() {
        return this.toys.size();
    }

    /**
     * method finds if the storage is empty.
     * @return is empty
     */
    public boolean isEmpty() {
        return toys.isEmpty();
    }
}

