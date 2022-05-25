package lesson10;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {

        // task 1
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(arr));
        swap(arr, 5, 0);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        //task 2 :)

        // task 3
        Box<Apple> boxApples = new Box<>();
        Box<Orange> boxOranges = new Box<>();

        boxApples.add(new Apple());
        boxApples.add(new Apple());
        boxApples.add(new Apple());

        boxOranges.add(new Orange());
        boxOranges.add(new Orange());

        System.out.printf("Вес коробки Apples %.1f%n", boxApples.getWeight());
        System.out.printf("Вес коробки Oranges %.1f%n", boxOranges.getWeight());

        System.out.printf("Коробки весят одинаково? : %s%n",
                boxApples.compare(boxOranges) ? "да" : "нет");

        Box<Apple> boxApples2 = new Box<>();
        for (int i = 0; i < 5; i++) {
            boxApples2.add(new Apple());
        }
        boxApples.pourIn(boxApples2);
        System.out.printf("Bec коробки Apples %.1f%n", boxApples.getWeight());
        System.out.printf("Bec коробки Apples2 %.1f%n", boxApples2.getWeight());

    }

    public static <E> void swap(E[] arr, int i, int j) {
        if (i >= arr.length || j >= arr.length) {
            throw new IndexOutOfBoundsException(
                    String.format("параметры i = %d, j = %d выходят за границы массива длиной %d%n", i, j, arr.length));
        }
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
