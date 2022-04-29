public abstract class Animal {
    private int runDistance;
    private int swimDistance;
    private static int count = 0;

    public Animal(int runDistance, int swimDistance) {
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
        count++;
    }

    public boolean run(int distance) {
        return distance <= runDistance;
    }

    public boolean swim(int distance) {
        return distance <= swimDistance;
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }

    public void setSwimDistance(int swimDistance) {
        this.swimDistance = swimDistance;
    }

    public static void printCount(){
        System.out.println("Животных " + count);
    }
}
