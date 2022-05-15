package lesson7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            isFull = true;
        }
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String strIsFull = (isFull) ? "сытый" : " голодный";
        return "cat " + name + " " + strIsFull;
    }
}
