package Lesson8;

public class MainClass {
    public static void main(String[] args) {
        Participant[] participants = new Participant[]{
                new Cat("LikeMilk", 1000, 5),
                new Human("Ivan", 500, 1),
                new Robot("Nick", 3000, 0)
        };

        Obstacle[] obstacles = new Obstacle[]{
                new Treadmill(100),
                new Treadmill(1000),
                new Wall(3)
        };

        for (var par : participants) {
            boolean isPassed = true;

            for (var obs : obstacles) {
                if (!obs.obstacle(par)) {
                    System.out.println(par + " сходит с дистанции!!!");
                    isPassed = false;
                    break;
                }
            }

            if (isPassed) {
                System.out.println(par + " проходит дистанцию!!!");
            }

            System.out.println();
        }
    }
}
