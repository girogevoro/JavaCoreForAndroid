package Lesson8;

public class Treadmill implements Obstacle{
    private  int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean obstacle(Participant participant) {
        return participant.run(distance);
    }
}
