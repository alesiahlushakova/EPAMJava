package by.training.task02.composite;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Particle implements  Component {
    private String value;
    private ParticleType type;

    private Particle(String value, ParticleType type) {
        this.value = value;
        this.type = type;
    }

    public static Particle word(String value) {
        return new Particle(value, ParticleType.WORD);
    }

    public static Particle expression(String value) {
        return new Particle(value, ParticleType.EXPRESSION);
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public List<Component> getChildren() {
        return Collections.emptyList();
    }

    public String getValue() {
        return value;
    }

    public ParticleType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Particle lexeme = (Particle) o;
        return Objects.equals(value, lexeme.value) &&
                type == lexeme.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }

    @Override
    public String toString() {
        return value;
    }
}
