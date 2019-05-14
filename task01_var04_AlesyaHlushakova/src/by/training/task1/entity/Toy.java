package by.training.task1.entity;

import by.training.task1.uconst.Age;
import by.training.task1.uconst.Size;

import java.util.Objects;

/**
 * abstract class for toys in game room.
 * @author AlesyaHlushakova
 */
public abstract class Toy {
    /**
     * toy name.
     */
    private String name;
    /**
     * toy size.
     */
    private Size size;
    /**
     * toy age.
     */
    private Age age;
    /**
     * toy price.
     */
    private  int price;


    /**
     * id for storage.
     */
    private int id;
    /**
     * constructor for toy.
     * @param name name of toy
     * @param price price of toy usage
     * @param size toy sizes
     * @param age age limit
     */
    public Toy(final String name, final int price, final Size size, final Age age) {
        this.name = name;
        this.price = price;
        this.age = age;
        this.size = size;
    }

    /**
     * method to get name of toy.
     * @return name of toy
     */
    public String getName() {
        return name;
    }

    /**
     * method to set tpy name.
     * @param name of toy
     * @return
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * method to get price eof toy.
     * @return price of toy
     */
    public int getPrice() {
        return price;
    }

    /**
     * method to set price of toy.
     * @param price toy price
     */
    public void setPrice(final int price) {
        this.price = price;
    }

    /**
     * method to get age restriction of a toy.
     * @return age restriction
     */
    public Age getAge() {
        return age;
    };

    /**
     * method to set age restriction of toy.
     * @param age restriction
     * @return
     */
    public void setAge(final Age age) {
        this.age = age;
    }

    /**
     * getter for size.
     * @return size
     */
    public Size getSize() {
        return size;
    }

    /**
     * getter for tiy id.
     * @return toy id
     */
    public int getId() {
        return id;
    }

    /**
     * setter for toy id.
     * @param id id of toy
     */
    public void setId(final int id) {
        this.id = id;
    }
    /**
     *
     * @param size
     * @return
     */
    public void setSize(final Size size) {
        this.size = size;
    }

    /**
     * overrides toString() to get info about toy.
     * @return
     */
    @Override
    public String toString() {
        return "Toy name: " + name + "; age restrictions: " + age + "; size: "
                + size + "; price: " + price;
    }

    /**
     * method overrides equals.
     * @param o comparable object
     * @return is equal
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Toy toy = (Toy) o;
        return price == toy.price
                && Objects.equals(name, toy.name)
                && size == toy.size
                && age == toy.age;

    }

    /**
     * overrides hash code.
     * @return new hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, size, age, price);
    }
}
