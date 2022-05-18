package Lesson8;

public class Robot implements Participant {

    private String name;
    private int runningDistance;
    private int jumpHeight;

    public Robot(String name, int runningDistance, int jumpHeight) {
        this.name = name;
        this.runningDistance = runningDistance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public boolean jump(int height) {
        if (jumpHeight >= height) {
            System.out.println(this + " прыгает на высоту " + height);
            return true;
        }
        System.out.println(this + " не смог прыгнуть на высоту " + height);
        return false;
    }

    @Override
    public boolean run(int distance) {
        if (runningDistance >= distance) {
            System.out.println(this + " пробегает дистанцию " + distance);
            return true;
        }
        System.out.println(this + " не смог пробежать дистанцию " + distance);
        return false;
    }

    @Override
    public String toString() {
        return "Robot " + name + " (max running " + runningDistance + " max jump " + jumpHeight + ")";
    }
}
