package lesson7;

public class MainClass {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 5);
        Plate plate = new Plate(100);
        plate.info();
        cat.eat(plate);
        plate.info();
        cat.info();

        System.out.println();
        plate.addFood(5);
        plate.info();

        Cat[] cats = new Cat[]{
                new Cat("Murzik", 25),
                new Cat("Bars", 15),
                new Cat("Kot Tom Black", 35),
                new Cat("Kotomyr", 30),
                new Cat("Grom", 55)
        };

        for (Cat c : cats) {
            c.eat(plate);
            c.info();
        }

        plate.info();

    }
}
