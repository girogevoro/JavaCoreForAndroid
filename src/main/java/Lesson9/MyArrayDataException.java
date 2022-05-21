package Lesson9;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(String index, String value) {
        super(String.format("В ячейке %s неверные данные: %s", index, value));
    }
}
