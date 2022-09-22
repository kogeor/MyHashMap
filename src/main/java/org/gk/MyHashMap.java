package org.gk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.Objects;
/** Класс служит для создания хранения HashMap, имплементирует интерфейса MAP
 @author Georgiy Koptlov
 @version 1.0
 22.09.2022.
 */
public class MyHashMap<K extends Comparable<? super K>, V> implements Map<K, V> {
    /** Класс, отвечающий за хранение элементов мапы, имплементируется  аналогичное интерфейса "Map.Entry"
     */
    private static class Pair<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;
        /** Конструктор для пары
         */
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        /** Метод получения ключа
         */
        public K getKey() {
            return key;
        }
        /** Метод получения значения
         */
        public V getValue() {
            return value;
        }
        /** Метод задания значения
         */
        public V setValue(V newValue) {
            V old = value;
            value = newValue;
            return old;
        }
        /** Метод сравнения для пар
         */
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair))
                return false;

            Pair pair = (Pair) o;
            return key.equals(pair.key) && value.equals(pair.value);
        }
        /** Метод перевода в строку для пары
         */
        @Override
        public String toString() {
            return key + "=" + value;
        }
        /** Метод для получения хэшкода
         */
        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

    }

    private ArrayList<LinkedList<Pair<K, V>>> table;
    private int size;
    /** Конструктор для мапы
     */
    public MyHashMap() {
        table = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            table.add(new LinkedList<>());
        }

        size = 0;
    }
    /** Конструктор для мапы с использованием другой мапы
     */
    public MyHashMap(Map<? extends K, ? extends V> map) {
        this();
        putAll(map);
    }

    private LinkedList<Pair<K, V>> getList(K key) {
        int index = Math.abs(key.hashCode() % table.size());
        return table.get(index);
    }
    /** Метод добавления пары ключ-значение с проверкой на наличие ключа в мапе
     */
    public V put(K key, V value) {
        LinkedList<Pair<K, V>> list = getList(key);

        V old = null;

        if (containsKey(key)) {
            for (Pair<K, V> pair : list) {
                if (pair.getKey().equals(key)) {
                    old = pair.getValue();
                    pair.setValue(value);
                }
            }
        } else {
            list.add(new Pair<>(key, value));
            size++;
        }

        return old;
    }
    /** Метод для удаления
     */
    public V remove(Object obj) {
        K key = (K) obj;
        V removedValue = null;

        if (containsKey(key)) {
            LinkedList<Pair<K, V>> list = getList(key);
            V value = get(key);

            int index = list.indexOf(new Pair<>(key, value));

            removedValue = list.get(index).getValue();
            list.remove(index);

            size--;
        }

        return removedValue;
    }
    /** Метод получения значения пол ключу
     */
    public V get(Object key) {
        LinkedList<Pair<K, V>> list = getList((K) key);
        for (Pair<K, V> pair : list) {
            if (pair.getKey().equals(key))
                return pair.getValue();
        }

        return null;
    }
    /** Метод проверки на наличие ключа
     */
    public boolean containsKey(Object key) {
        LinkedList<Pair<K, V>> list = getList((K) key);
        for (Pair<K, V> pair : list)
            if (pair.getKey().equals(key))
                return true;

        return false;
    }
    /** Метод проверки на наличие значения
     */
    public boolean containsValue(Object value) {
        for (LinkedList<Pair<K, V>> list : table)
            for (Pair<K, V> pair : list)
                if (pair.getValue().equals(value))
                    return true;

        return false;
    }
    /** Метод для получения набора пар
     */
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();

        for (LinkedList<Pair<K, V>> list : table) {
            set.addAll(list);
        }
        return set;
    }
    /** Метод для получения набора ключей
     */
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (LinkedList<Pair<K, V>> list : table) {
            for (Pair<K, V> pair : list) {
                set.add(pair.getKey());
            }
        }
        return set;
    }
    /** Метод для получения набора значений
     */
    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();
        for (LinkedList<Pair<K, V>> list : table)
            for (Pair<K, V> pair : list)
                values.add(pair.getValue());

        return values;
    }
    /** Метод вставки в мапу данных из другой мапы
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            put((K) key, (V) value);
        }
    }
    /** Метод очистки мапы
     */
    @Override
    public void clear() {
        for (LinkedList<Pair<K, V>> list : table)
            list.clear();

        size = 0;
    }
    /** Метод для получения размера мапы
     */
    public int size() {
        return size;
    }
    /** Метод для проверки на пустую мапу
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /** Метод для сортировки. Пока не работает как надо
     */
    public void sort() {
        K[] array = (K[]) keySet().toArray();
        QuickSort<K> sorter = new QuickSort<>();
        sorter.quicksort(array, 0, array.length - 1);
        System.out.println(java.util.Arrays.toString(array));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyHashMap))
            return false;

        MyHashMap other = (MyHashMap) o;

        if (size() != other.size())
            return false;

        if (this.entrySet().equals(other.entrySet()))
            return false;

        return true;
    }
    /** Метод для перевода мапы в текст, содержащий пары значения в следующем виде: {Ключ1=значение1, Ключ2=значение2}
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        int count = 0;

        for (LinkedList<Pair<K, V>> list : table) {
            for (Pair<K, V> pair : list) {
                count++;
                str.append(pair);

                if (count < size())
                    str.append(", ");
            }
        }

        str.append("}");

        return str.toString();
    }

}