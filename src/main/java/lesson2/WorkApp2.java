package lesson2;

import java.time.Year;

public class WorkApp2 {
    public static void main(String[] args) {

        // 1 task
        if (isInRange(10, 5)) {
            System.out.println("Сумма в диапазоне");
        } else {
            System.out.println(" Сумма не в диапазоне");
        }

        // 2 task
        printSingOfNumber(7);

        // 3 task
        if (isNegative(19)) {
            System.out.println("число отрицательное");
        } else {
            System.out.println("число положительное");
        }

        // 4 task
        printStrNCount("Hello", 3);

        // 5 task
        if(isLeapYear( 2196)){
            System.out.println("год  високосный");
        }else {
            System.out.println("год не високосный");
        }

    }

    private static boolean isInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    private static void printSingOfNumber(int number) {
        if (number >= 0) {
            System.out.println("число положительное");
        } else {
            System.out.println("число отрицательное");
        }
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }

    private static void printStrNCount(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    private static boolean isLeapYear(int year) {
        boolean isYear;
        if (year % 4 == 0) {
            isYear = (year % 100 != 0) || year % 400 == 0;

        }else{
            isYear = false;
        }
        return  isYear;
    }
}
