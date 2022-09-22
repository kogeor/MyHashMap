package org.gk;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap<K, V> {
    private final float dLoadFactor = 0.75F;
    private final int dCapacity = 16;
    private int size = 0;
    private float loadFactor;
    private int capacity;
    private List<Entries> entries;

    public MyHashMap() {
        if (entries == null) {
            entries = new LinkedList<>();
        }
    }

    public List<Entries> getEntries() {
        return entries;
    }

    public int size() {
        return size;
    }

    class Entries<K, V> {
        private K key;
        private V value;

        Entries(K key, V value) {
            this.value = value;
            this.key = key;
        }

    }
}
