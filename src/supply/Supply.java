package supply;

import characters.Character;
import characters.State;
import mainFiles.Direction;
import mainFiles.MyMain;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class Supply {
    public int dirX;
    public int dirY;
    public int speed;
    public int damage;

    protected int projectiveHeadX;
    protected int projectiveHeadY;

    public Image currentFrame;
    public BufferedImage supplyImage;
    protected Map<Direction, Image> supplySprites = new HashMap<>();

    public int width;
    public int height;

    protected Direction direction;

    protected MyMain game;

    public Supply(MyMain game, int dirX, int dirY, Direction dir) {
        this.game = game;
        this.dirX = dirX;
        this.dirY = dirY;
        this.direction = dir;
    }

    public void move() {
        switch (direction) {
            case UP:
                dirY -= speed;
                break;
            case RIGHT_UP:
                dirX += (int) Math.ceil(speed / 1.5);
                dirY -= (int) Math.ceil(speed / 1.5);
                break;
            case RIGHT:
                dirX += speed;
                break;
            case RIGHT_DOWN:
                dirX += (int) Math.ceil(speed / 1.5);
                dirY += (int) Math.ceil(speed / 1.5);
                break;
            case DOWN:
                dirY += speed;
                break;
            case LEFT_DOWN:
                dirX -= (int) Math.ceil(speed / 1.5);
                dirY += (int) Math.ceil(speed / 1.5);
                break;
            case LEFT:
                dirX -= speed;
                break;
            case LEFT_UP:
                dirX -= (int) Math.ceil(speed / 1.5);
                dirY -= (int) Math.ceil(speed / 1.5);
                break;
            default:
                break;
        }

        setProjectileHeadCords();
        for (Character enemy : game.characters) {
            hitCheck(enemy);
        }
    }

    public abstract void setProjectileHeadCords();

    public void hitCheck(Character enemy) {
        if(enemy.state != State.DEAD) {
            if (projectiveHeadX >= enemy.dirX && projectiveHeadY <= enemy.dirY + enemy.spriteHeight
                    && projectiveHeadY >= enemy.dirY && projectiveHeadX <= enemy.dirX + enemy.spriteWidth) {
                enemy.hp -= damage;
                enemy.stan();
//                game.supplies.remove(this);
            }
        }
    }

    protected void setSprites(String imageName) {
        textureInit(imageName);

        for (Direction dir : Direction.values()) {
            if (dir != Direction.NONE) {
                supplySprites.put(dir, supplyImage.getSubimage(dir.count * width, 0, width, height)
                        .getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }
        }
    }

    private void textureInit(String imageName) {
        File file = new File("C:\\myGame\\src\\res\\supplySprites\\" + imageName + ".png");
        try {
            supplyImage = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = supplyImage.getWidth() / 8;
        height = supplyImage.getHeight();
    }
}
