public class Dog extends Animal {

    private static final int RUN_DISTANCE = 500;
    private static final int SWIM_DISTANCE = 10;
    private static int count = 0;

    public Dog() {
        super(RUN_DISTANCE, SWIM_DISTANCE);
        count++;
    }

    public  static void printCount(){
        System.out.println("Собак " + count);
    }
}
