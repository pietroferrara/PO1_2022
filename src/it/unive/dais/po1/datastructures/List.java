package it.unive.dais.po1.datastructures;

import it.unive.dais.po1.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;

public class List<T> {
    private T[] array;

    public List() {
        //ignore it
        array = (T[]) new ArrayList<T>().toArray();
    }

    public T get(int i) {
        return array[i];
    }

    public void add(T t) {
        int n = array.length;
        array = Arrays.copyOf(array, n+1);
        array[n] = t;
    }


    public void replace(int i, T t) {
        array[i] = t;
    }

    public int size() {
        return array.length;
    }

    public static <T extends Vehicle> List<T> toList(T value) {
        List<T> result = new List<>();
        result.add(value);
        return result;
    }
}
