package main.datastructure;

public interface Iterator<E> {

    boolean hasNext();
    E next();
    void remove();
    Iterator<E> iterator();
}
