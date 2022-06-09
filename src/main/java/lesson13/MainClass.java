package lesson13;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT / 2), new Road(40));
        Car.SynchronizedRace synchronizedRace = new Car.SynchronizedRace(CARS_COUNT);

        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), synchronizedRace);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            synchronizedRace.startRace.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        try {
            synchronizedRace.finishRace.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        for (int place = 1; place <= CARS_COUNT; place++) {
            for (int j = 0; j < CARS_COUNT; j++) {
                if (cars[j].getPlaceInRace() == place) {
                    System.out.printf(" %d место занял  %s%n", place, cars[j].getName());
                    break;
                }
            }
        }
    }
}
