package lesson10;


import java.util.Arrays;

public class Box<E extends Fruit> {
    private Fruit[] arr;
    private int index = -1;
    private int indexMax = 2;

    public Box() {
        arr = new Fruit[indexMax];
    }

    public void add(E fruit) {
        index++;
        if (index >= indexMax) {
            indexMax = (int) Math.ceil(indexMax * 1.5);
            arr = Arrays.copyOf(arr, indexMax);
        }
        arr[index] = fruit;
    }

    public double getWeight() {
        double sumWeight = 0;
        for (int i = 0; i <= index; i++) {
            sumWeight += arr[i].getWeight();
        }
        return sumWeight;
    }

    public boolean compare(Box<?> box) {
        return getWeight() == box.getWeight();
    }

    public E pickUp() {
        if (index < 0) {
            return null;
        }
        E temp = (E) arr[index];
        arr[index] = null;
        index--;
        return temp;
    }

    public void pourIn(Box<E> box) {
        E fruit;
        while ((fruit = pickUp()) != null) {
            box.add(fruit);
        }
    }
}