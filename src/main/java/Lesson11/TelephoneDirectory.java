package Lesson11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    Map<String, List<String>> book = new HashMap<>();

    public void add(String name, String number) {
        if (!book.containsKey(name)) {
            book.put(name, new ArrayList<>());
        }
        book.get(name).add(number);
    }

    public void get(String name) {
        var list = book.get(name);
        if (list != null) {
            System.out.println(name + ": " + list);
        } else {
            System.out.println(name + ": телефона нет");
        }
    }
}
