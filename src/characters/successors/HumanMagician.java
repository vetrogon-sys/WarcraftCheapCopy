package characters.successors;

import characters.Activity;
import characters.Character;
import characters.CharacterSprite;
import characters.State;
import mainFiles.Direction;
import mainFiles.MyMain;
import mainFiles.gameConventions.GameFraction;
import supply.supplyTypes.LightningBall;

import javax.swing.*;

public class HumanMagician extends Character {
    private float mp;

    public HumanMagician(MyMain game) {
        super(game);

        fraction= GameFraction.HUMANS;

        sprites = new CharacterSprite("magician");
        spriteHeight = sprites.height;
        spriteWidth = sprites.width;

        icon = new ImageIcon("C:\\myGame\\src\\res\\icons\\magicianIco.png").getImage();

        hp = 100;
        mp = 100;
        speed = 3;

        dirX = (int) (Math.random() * 1000);
        dirY = (int) (Math.random() * 500);

//        dirX = 1100;
//        dirY = 550;
    }

    @Override
    public void move() throws NullPointerException {
        super.move();
        if (state == State.ALIVE && activity != Activity.ATTACK) {
            mp += 0.5;
        }
    }

    @Override
    public void attack(Character target) {
        if (target.hp > 0) {
            if (mp > LightningBall.spellCoast) {
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
                mp -= LightningBall.spellCoast;
            }
        } else {
            activity = Activity.STAND;
        }
    }

    private void shoot(int x, int y) {
        game.supplies.add(new LightningBall(game, dirX + x, dirY + y, direction));
    }
}
