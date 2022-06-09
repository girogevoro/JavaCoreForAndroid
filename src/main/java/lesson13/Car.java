package lesson13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;

    private int speed;
    private String name;

    private int placeInRace = 0;

    private SynchronizedRace synchronizedRace;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPlaceInRace() {
        return placeInRace;
    }

    public Car(Race race, int speed, SynchronizedRace synchronizedRace) {
        this.race = race;
        this.speed = speed;
        this.synchronizedRace = synchronizedRace;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            synchronizedRace.startRace.countDown();
            synchronizedRace.startPreparation.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        placeInRace = synchronizedRace.getPlaceInRace();
        if (placeInRace == 1) {
            System.out.println(getName() + " - WIN");
        }
        synchronizedRace.finishRace.countDown();
    }

    public static class SynchronizedRace {

        int place = 0;
        CyclicBarrier startPreparation;
        CountDownLatch startRace;
        CountDownLatch finishRace;

        ReentrantLock lock = new ReentrantLock();

        public SynchronizedRace(int countCars) {
            startPreparation = new CyclicBarrier(countCars);
            startRace = new CountDownLatch(countCars);
            finishRace = new CountDownLatch(countCars);
        }

        public int getPlaceInRace() {
            int placeCar;
            lock.lock();
            place++;
            placeCar = place;
            lock.unlock();
            return placeCar;
        }
    }
}
