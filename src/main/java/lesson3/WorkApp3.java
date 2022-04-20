package lesson3;

import java.util.Arrays;

public class WorkApp3 {
    public static void main(String[] args) {

        // 1 task
        int[] arrInt = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("1 task \nвход  " + Arrays.toString(arrInt));
        replaceZeroWhitOne(arrInt);
        System.out.println("выход " + Arrays.toString(arrInt));

        // 2 task
        arrInt = new int[100];
        System.out.println("\n2 task");
        fillArr(arrInt);
        System.out.println(Arrays.toString(arrInt));

        // 3 task
        arrInt = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("\n3 task\nвход  " + Arrays.toString(arrInt));
        multiplySmallValue(arrInt);
        System.out.println("выход " + Arrays.toString(arrInt));

        // 4 task
        System.out.println("\n4 task");
        int[][] squareArr = createSquareArray(10);
        print2DArray(squareArr);

        // 5 task
        arrInt = createLineArray(10, 89);
        System.out.println("\n5 task\n" + Arrays.toString(arrInt));

        // 6 task
        arrInt = new int[]{157, 33, 43, 9, 445, 67, 1589, 500, 358, 386};
        System.out.println("\n6 task\n" + Arrays.toString(arrInt));
        printMaxMin(arrInt);

        // 7 task
        arrInt = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("\n7 task\n " + Arrays.toString(arrInt));
        if (isEqualSumPart(arrInt)) {
            System.out.println("Сумма левой и правой части массива равны");
        } else {
            System.out.println("Сумма левой и правой части массива не равны");
        }

        // 8 task
        arrInt = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int shift = 3;
        System.out.println("\n8 task\n" + Arrays.toString(arrInt));
        shiftArray(arrInt, shift);
        System.out.println("смещение на " + shift + "\n" + Arrays.toString(arrInt));


    }

    private static void replaceZeroWhitOne(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else if (arr[i] == 1) {
                arr[i] = 0;
            }
        }
    }

    private static void fillArr(int[] arrInt) {
        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = i + 1;
        }
    }

    private static void multiplySmallValue(int[] arrInt) {
        for (int i = 0; i < arrInt.length; i++) {
            if (arrInt[i] < 6) {
                arrInt[i] *= 2;
            }
        }
    }

    private static int[][] createSquareArray(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i == (n - 1 - j)) {
                    arr[i][j] = 1;
                }
            }
        }
        return arr;
    }

    private static void print2DArray(int[][] squareArr) {
        for (int[] arr : squareArr) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }

    private static int[] createLineArray(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }

    private static void printMaxMin(int[] arrInt) {
        int max = arrInt[0], min = max;
        for (int i = 1; i < arrInt.length; i++) {
            int val = arrInt[i];
            if (val > max) {
                max = val;
            }
            if (val < min) {
                min = val;
            }
        }
        System.out.printf(" max %d%n min %d%n", max, min);
    }

    private static boolean isEqualSumPart(int[] arrInt) {
        int i = 0, j = arrInt.length - 1;
        int sumA = arrInt[i], sumB = arrInt[j];
        int len = 2;
        while (len < arrInt.length) {
            if (sumA > sumB) {
                sumB += arrInt[--j];
            } else {
                sumA += arrInt[++i];
            }
            len++;
        }
        return sumA == sumB;
    }

    private static void shiftArray(int[] arrInt, int shift) {
        shift %= arrInt.length;
        int buf;

        if (shift < 0) {
            shift = arrInt.length + shift;
        }

        for (int i = 0; i < shift; i++) {
            buf = arrInt[arrInt.length - 1];
            for (int j = arrInt.length - 1; j > 0; j--) {
                arrInt[j] = arrInt[j - 1];
            }
            arrInt[0] = buf;
        }
    }


}
