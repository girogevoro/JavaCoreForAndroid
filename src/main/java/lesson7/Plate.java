package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int food) {
        this.food += food;
    }

    public boolean decreaseFood(int decrease) {
        if (food >= decrease) {
            food -= decrease;
            return true;
        }
        return false;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "plate: " + food;
    }
}
