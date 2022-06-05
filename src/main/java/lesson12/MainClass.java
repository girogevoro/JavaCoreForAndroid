package lesson12;

import java.util.Arrays;

public class MainClass {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        //task
        oneThread();
        twoThreads();
    }

    private static void oneThread() {
        var arr = new float[SIZE];
        Arrays.fill(arr, 1);

        var a = System.currentTimeMillis();

        somethingDo(arr, 0);

        System.out.println(System.currentTimeMillis() - a);
    }

    private static void twoThreads() {
        var arr = new float[SIZE];
        Arrays.fill(arr, 1);

        var a = System.currentTimeMillis();

        var arr1 = new float[HALF];
        var arr2 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        var t1 = new Thread(() -> somethingDo(arr1, 0));
        t1.start();
        var t2 = new Thread(() -> somethingDo(arr2, HALF));
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.out.println(System.currentTimeMillis() - a) ;
    }

    private static void somethingDo(float[] arr, int shift) {
        for (int index = 0; index < arr.length; index++) {
            int i = index + shift;
            arr[index] = (float) (arr[index] * Math.sin(0.2f + 1.0 * i / 5) * Math.cos(0.2f + 1.0 * i / 5) *
                    Math.cos(0.4f + 1.0 * i / 2));
        }
    }
}
