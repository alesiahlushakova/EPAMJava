package by.traning.task1.entities;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import by.traning.task1.entities.enums.Age;
import by.traning.task1.entities.enums.Size;

import java.util.Objects;

/**
 * @author AlesyaHlushakova
 */
public abstract class Toy {
    private String name;
    private Size size;
    private  Age age;
    private  int price;
    /**
     * @param name name of toy
     * @param price price of toy usage
     * @param size toy sizes
     * @param age age limit
     */
    public Toy(String name, int price, Size size, Age age) {
        this.name = name;
        this.price = price;
        this.age = age;
        this.size = size;
    }
    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int setPrice(int price) {
        return this.price = price;
    }

    /**
     * @return
     */
    public Age getAge() {
        return age;
    };

    /**
     *
     * @param age
     * @return
     */
    public Age setAge(Age age) {
        return this.age = age;
    }

    /**
     *
     * @return
     */
    public Size getSize() {
        return size;
    }

    /**
     *
     * @param size
     * @return
     */
    public Size setSize(Size size) {
        return this.size = size;
    }

    /**
     * info about toys.
     * @return
     */
    @Override
    public String toString() {
        return "Toy name: " + name + "; age restrictions: " + age + "; size: "
                + size + "; price: " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return price == toy.price &&
                Objects.equals(name, toy.name) &&
                size == toy.size &&
                age == toy.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, age, price);
    }
}
