package characters;

import mainFiles.MyMain;
import mainFiles.gameConventions.GameFraction;

import javax.swing.*;

public class HumanMagician extends Character {

    public HumanMagician(MyMain game) {
        super(game);

        fraction= GameFraction.HUMANS;

        sprites = new CharacterSprite("magician");
        spriteHeight = sprites.height;
        spriteWidth = sprites.width;

        icon = new ImageIcon("C:\\myGame\\src\\res\\icons\\magicianIco.png").getImage();

        hp = 100;
        speed = 3;

        dirX = (int) (Math.random() * 1000);
        dirY = (int) (Math.random() * 500);

//        dirX = 1100;
//        dirY = 550;
    }
}
