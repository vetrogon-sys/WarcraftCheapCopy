package mainFiles;

public enum Direction {
    UP(0),
    RIGHT_UP(1),
    RIGHT(2),
    RIGHT_DOWN(3),
    DOWN(4),
    LEFT_DOWN(5),
    LEFT(6),
    LEFT_UP(7),
    NONE(-1);

    public final int count;

    Direction(int count) {
        this.count = count;
    }
}
