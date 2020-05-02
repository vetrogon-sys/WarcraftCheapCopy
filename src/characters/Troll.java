package characters;

import mainFiles.MyMain;
import mainFiles.gameConventions.GameFraction;

import javax.swing.*;

public class Troll extends Character {

    public Troll(MyMain game) {
        super(game);

        fraction= GameFraction.ORC;

        sprites = new CharacterSprite("troll");
        spriteHeight = sprites.height;
        spriteWidth = sprites.width;

        icon = new ImageIcon("C:\\myGame\\src\\res\\icons\\trollIco.png").getImage();

        hp = 75;
        speed = 3;

        dirX = (int) (Math.random() * 1000) + 700;
        dirY = (int) (Math.random() * 500) + 50;

//        dirX = 1000;
//        dirY = 500;
    }
}
