package main.datastructure;

public interface Map<K,V> {

    /**
     * Returns the size of the Map.
     *
     * @param: Nothing
     * @return: int
     */

    int size();

    /**
     * Returns if the Map is empty.
     *
     * @param: Nothing
     * @return: boolean
     * */
    boolean isEmpty();

    /**
     * Returns an entry that is retrieved by using the key.
     *
     * @param: K key
     * @return: Entry<K, V>
     *
     * */
    Entry<K,V> get(K key);

    /**
     * Returns an entry that is add to the map.
     *
     * @param: K key, V value
     * @return: Entry<K, V>
     *
     * */
    Entry<K,V> put(K key, V value);

    /**
     * Returns an entry that is removed from the map.
     *
     * @param: K key
     * @return: Entry<K, V>
     *
     * */
    Entry<K,V> remove(K key);
}
