package characters;

public enum Activity {
    STAND(0, 1),
    WALK(0, 5),
    ATTACK(5, 4),
    DIE(9, 3);

    public final int number;
    public final int start;

    Activity(int from, int number) {
        this.start = from;
        this.number = number;
    }
}
