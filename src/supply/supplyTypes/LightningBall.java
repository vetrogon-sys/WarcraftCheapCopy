package supply.supplyTypes;

import mainFiles.Direction;
import mainFiles.MyMain;
import supply.Supply;

public class LightningBall extends Supply {
    public static float spellCoast;

    public LightningBall(MyMain game, int dirX, int dirY, Direction dir) {
        super(game, dirX, dirY, dir);

        damage = 10;
        speed = 40;
        spellCoast = 12.5F;

        setSprites("lightningBall");
        currentFrame = supplySprites.get(dir);
    }

    @Override
    public void setProjectileHeadCords() {
        switch (direction) {
            case UP:
                projectiveHeadX = dirX + 8;
                projectiveHeadY = dirY + 6;
                break;
            case RIGHT_UP:
                projectiveHeadX = dirX + 22;
                projectiveHeadY = dirY + 8;
                break;
            case RIGHT:
                projectiveHeadX = dirX + 25;
                projectiveHeadY = dirY + 13;
                break;
            case RIGHT_DOWN:
                projectiveHeadX = dirX + 26;
                projectiveHeadY = dirY + 24;
                break;
            case DOWN:
                projectiveHeadX = dirX + 16;
                projectiveHeadY = dirY + 30;
                break;
            case LEFT_DOWN:
                projectiveHeadX = dirX + 6;
                projectiveHeadY = dirY + 24;
                break;
            case LEFT:
                projectiveHeadX = dirX + 5;
                projectiveHeadY = dirY + 17;
                break;
            case LEFT_UP:
                projectiveHeadX = dirX + 5;
                projectiveHeadY = dirY + 10;
                break;
            default:
                break;
        }
    }
}
