package supply.supplyTypes;

import mainFiles.Direction;
import mainFiles.MyMain;
import supply.Supply;

public class Arrow extends Supply {

    public Arrow(MyMain game, int dirX, int dirY, Direction dir) {
        super(game, dirX, dirY, dir);

        damage = 15;
        speed = 20;

        setSprites("arrow");
        currentFrame = supplySprites.get(dir);
    }

    @Override
    public void setProjectileHeadCords() {
        switch (direction) {
            case UP:
                projectiveHeadX = dirX + 26;
                projectiveHeadY = dirY + 14;
                break;
            case RIGHT_UP:
                projectiveHeadX = dirX + 30;
                projectiveHeadY = dirY + 19;
                break;
            case RIGHT:
                projectiveHeadX = dirX + 33;
                projectiveHeadY = dirY + 33;
                break;
            case RIGHT_DOWN:
                projectiveHeadX = dirX + 32;
                projectiveHeadY = dirY + 42;
                break;
            case DOWN:
                projectiveHeadX = dirX + 16;
                projectiveHeadY = dirY + 47;
                break;
            case LEFT_DOWN:
                projectiveHeadX = dirX + 3;
                projectiveHeadY = dirY + 40;
                break;
            case LEFT:
                projectiveHeadX = dirX;
                projectiveHeadY = dirY + 29;
                break;
            case LEFT_UP:
                projectiveHeadX = dirX + 8;
                projectiveHeadY = dirY + 19;
                break;
            default:
                break;
        }
    }
}
