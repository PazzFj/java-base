package net.pazz.base.map;

public interface MyMap<K, V> {

    V get(K key);

    V put(K key, V value);

    int getNewTableSize();

    interface Entry<K,V> {
        K getKey();

        V getValue();
    }

}
