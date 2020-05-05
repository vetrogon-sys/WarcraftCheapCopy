package characters.successors;

import characters.Character;
import characters.CharacterSprite;
import mainFiles.MyMain;
import mainFiles.gameConventions.GameFraction;

import javax.swing.*;

public class Troll extends Character {
    private int axeNum;

    public Troll(MyMain game) {
        super(game);

        fraction= GameFraction.ORC;

        sprites = new CharacterSprite("troll");
        spriteHeight = sprites.height;
        spriteWidth = sprites.width;

        icon = new ImageIcon("C:\\myGame\\src\\res\\icons\\trollIco.png").getImage();

        hp = 100;
        speed = 3;
        axeNum = 5;

        dirX = (int) (Math.random() * 1000) + 700;
        dirY = (int) (Math.random() * 500) + 50;

//        dirX = 1080;
//        dirY = 500;
    }

    @Override
    public void attack(Character target) {

    }
}
