package Lesson8;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean obstacle(Participant participant) {
        return participant.jump(height);
    }
}
