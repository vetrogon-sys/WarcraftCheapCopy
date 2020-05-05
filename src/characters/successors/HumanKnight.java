package characters.successors;

import characters.Character;
import characters.CharacterSprite;
import mainFiles.MyMain;
import mainFiles.gameConventions.GameFraction;

import javax.swing.*;

public class HumanKnight extends Character {

    public HumanKnight(MyMain game) {
        super(game);

        fraction= GameFraction.HUMANS;

        sprites = new CharacterSprite("knight");
        spriteHeight = sprites.height;
        spriteWidth = sprites.width;

        icon = new ImageIcon("C:\\myGame\\src\\res\\icons\\knightIco.png").getImage();

        hp = 125;
        speed = 2;

        dirX = (int) (Math.random() * 1000) + 700;
        dirY = (int) (Math.random() * 500) + 50;


    }

    @Override
    public void attack(Character target) {

    }
}
