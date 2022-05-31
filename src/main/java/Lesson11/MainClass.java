package Lesson11;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        //task 1
        String[] arr = {"box", "fox", "bot", "six", "boy","big",
                "six", "buy", "eye", "lay", "mob", "law", "pig",
                "dog", "six", "mob", "big", "bot"};
        Set<String> original = new HashSet<>(Arrays.asList(arr));
        System.out.println("Список уникальных строк: " + original);

        List<String> listStr = new ArrayList<>(Arrays.asList(arr));
        for (String str : original) {
            int cnt = 0;
            for (String s : listStr) {
                if (str.equals(s)) {
                    cnt++;
                }
            }
            System.out.printf("%s встречается %d раз(а)%n", str, cnt);
        }
        System.out.println();

        //task 2
        TelephoneDirectory book = new TelephoneDirectory();

        book.add("Ivanov", "9583483209");
        book.add("Sidorov", "9583483209");
        book.add("Ivanov", "5459879384");
        book.add("Smirnov", "6554556");

        book.get("Ivanov");
        book.get("Sidorov");
        book.get("Smirnov");

    }
}
