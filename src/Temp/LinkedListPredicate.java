package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LinkedListPredicate<T> {
    private List<T> elements;

    public LinkedListPredicate() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T find(Predicate<T> predicate) {
        return elements.stream().filter(predicate).findFirst().orElse(null);
    }

    public void remove(Predicate<T> predicate) {
        elements.removeIf(predicate);
    }

    public List<T> getAll() {
        return elements;
    }
}
