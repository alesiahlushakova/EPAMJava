package entities;

import entities.enums.Age;
import entities.enums.Size;
/**
 * @author AlesyaHlushakova
 */
public abstract class Toy {
    private String name;
    private Size size;
    private  Age age;
    private  int price;
    /**
     * @param name
     * @param price
     * @param size
     * @param age
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
}
