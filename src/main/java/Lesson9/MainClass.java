package Lesson9;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {

        String[][] test1 = {
                {"4", "6", "7", "8"},
                {"45", "65", "76", "1"},
                {"5", "45", "2", "7"},
                {"76", "3", "87", "2"}
        };
        String[][] test2 = {
                {"4", "6", "7", "8"},
                {"45", "65", "76", "1", "84", "367"},
                {"5", "45", "2", "7"},
                {"76", "3", "87", "2"}
        };
        String[][] test3 = {
                {"4", "6", "minus7", "8"},
                {"45", "65", "76", "1"},
                {"5", "45", "2", "7"},
                {"76", "3", "87", "2"}
        };

        String[][][] arrs = {test1, test2, test3};

        for (String[][] arr : arrs) {
            try {
                int result = sumArray4x4(arr);
                System.out.printf("сумма для массива %s равна %d %n", Arrays.deepToString(arr), result );

            } catch (MyArraySizeException e) {
                e.printStackTrace();
                System.err.printf("\u001B[33mневерный размер массива %s%n\u001B[0m", Arrays.deepToString(arr) );

            } catch (MyArrayDataException e) {
                e.printStackTrace();
                System.err.printf("\u001B[33mневернае данные в массиве %s%n\u001B[0m", Arrays.deepToString(arr) );
            }
        }


    }

    public static int sumArray4x4(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            String[] strings = arr[i];
            if (strings.length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < strings.length; j++) {
                String string = strings[j];
                try {
                    sum += Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("[%d:%d]", i, j), string);
                }
            }
        }
        return sum;
    }
}
