package characters.successors;

import characters.Activity;
import characters.Character;
import characters.CharacterSprite;
import mainFiles.Direction;
import mainFiles.MyMain;
import mainFiles.gameConventions.GameFraction;
import supply.supplyTypes.Arrow;

import javax.swing.*;

public class ElfArcher extends Character {
    private int arrowNum;

    public ElfArcher(MyMain game) {
        super(game);

        fraction= GameFraction.HUMANS;

        sprites = new CharacterSprite("archer");
        spriteHeight = sprites.height;
        spriteWidth = sprites.width;

        icon = new ImageIcon("C:\\myGame\\src\\res\\icons\\archerIco.png").getImage();

        hp = 75;
        speed = 3;

        arrowNum = 20;

        dirX = (int) (Math.random() * 1000) + 700;
        dirY = (int) (Math.random() * 500) + 50;

//        dirX = 1000;
//        dirY = 500;
    }

    @Override
    public void attack(Character target) {
        if (target.hp > 0) {
            if (arrowNum > 0) {
                if (direction == Direction.RIGHT) {
                    shoot(51, -10);
                } else if (direction == Direction.LEFT) {
                    shoot(3, -1);
                } else if (direction == Direction.UP) {
                    shoot(0, 0);
                } else if (direction == Direction.DOWN) {
                    shoot(25, 44);
                } else if (direction == Direction.RIGHT_DOWN) {
                    shoot(10, 38);
                } else if (direction == Direction.RIGHT_UP) {
                    shoot(8, 45);
                } else if (direction == Direction.LEFT_DOWN) {
                    shoot(10, 21);
                } else if (direction == Direction.LEFT_UP) {
                    shoot(9, 17);
                }
                arrowNum--;
            }
        } else {
            activity = Activity.STAND;
        }
    }

    private void shoot(int x, int y) {
        game.supplies.add(new Arrow(game, dirX + x, dirY + y, direction));
    }
}
