public class Cat extends Animal {

    private static final int RAN_DISTANCE = 200;
    private static final int SWIM_DISTANCE = 0;
    private static int count = 0;

    public Cat() {
        super(RAN_DISTANCE, SWIM_DISTANCE);
        count++;
    }

    @Override
    public void setSwimDistance(int swimDistance) {
    }


    public static void printCount() {
        System.out.println("Котов " + count);
    }
}
