package mainFiles;

import java.awt.*;

public class MiniMap {
    private static final int START_X = 62;
    private static final int START_Y = 53;
    private static final int WIDTH = 398;
    private static final int HEIGHT = 300;
    private static final int INTERFACE_WIDTH = 1354;
    private static final int INTERFACE_HEIGHT = 1022;

    private Image map;

    public float rectX = START_X;
    public float rectY = START_Y;
    private int rectWidth;
    private int rectHeight;

    public MiniMap(Image map) {
        this.map = map;

        rectWidth = (int) Math.ceil( WIDTH / Math.ceil(((double) map.getWidth(null) / INTERFACE_WIDTH)) );
        rectHeight = (int) Math.ceil( HEIGHT / Math.ceil(((double) map.getHeight(null) / INTERFACE_HEIGHT)) );
    }

    public void paintMiniMap(Graphics g) {
        g.drawImage(map, START_X, START_Y,
                WIDTH, HEIGHT, null);

        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.WHITE);
        g2D.drawRect((int) rectX, (int) rectY,
                rectWidth, rectHeight);
    }

}
