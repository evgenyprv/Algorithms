package main.datastructure.implementation;

/**
 *
 * @Author: Evgeny Pro.
 *
 * */


import java.util.Optional;

public class HashTable<E> {

    private static Integer TABLE_SIZE = 11;

    private LinkedList<E>[] table;
    private int size;

    public HashTable(){this(TABLE_SIZE);}

    public HashTable(int size){
        this.table = new LinkedList[size];
        this.size = 0;
    }

    public int size(){return size;}

    public boolean isEmpty(){return size == 0;}

    public E put(E element){
        checkIfElementNotNull(element);
        checkIfResizeNeeded();

        int tableKey = hash(element);

        final E e = Optional.ofNullable(table[tableKey])
                .map(elem -> elem.addLast(element))
                .orElseGet(() -> {
                    LinkedList<E> bucket = new LinkedList<>();
                    bucket.addFirst(element);
                    table[tableKey] = bucket;
                    size++;
                    return element;
                });
        return e;
    }

    public E remove(E element){
        checkIfElementNotNull(element);
        checkIfResizeNeeded();

        int tableKey = hash(element);

        return Optional.ofNullable(table[tableKey])
                .map(bucket -> {
                    if(checkBucketSize(bucket, tableKey)){
                        size--;
                    }
                    return bucket.remove(element);})
                .orElse(null);
    }

    /***
     *
     * The following are Error prevention functions.
     *
     * */

    private void checkIfResizeNeeded(){
        if(size() == table.length){
            resize();
        }
    }

    private void checkIfElementNotNull(E element){
        if(!Optional.ofNullable(element).isPresent()){
            throw new NullPointerException("Element cannot be null");
        }
    }

    private boolean checkBucketSize(LinkedList<E> bucket, int tableKey){
        if(bucket.size() == 1){
            table[tableKey] = null;
            return true;
        }
        return false;
    }

    /***
     *
     * The following are UTILITY functions.
     *
     * */

    private int hash(E element){
        return element.hashCode() % table.length;
    }

    /*
    *
    * O(n)
    *
    * */
    private void resize(){
        int newSize = isPrime(table.length*2);
        LinkedList<E>[] tmp = new LinkedList[newSize];
        for(int i = 0; i < table.length; i++){
            tmp[i] = table[i];
        }
        table = tmp;
    }

    /*
     *
     * O(n)
     *
     * */

    private int isPrime(int num){
        if(!(num % 2 == 0 || (num % 5) == 0)){
            return num;
        }
        return isPrime(num+1);
    }
}
