package characters;

import mainFiles.MyMain;
import mainFiles.gameConventions.GameFraction;

import javax.swing.*;

public class OrcGrant extends Character {

    public OrcGrant(MyMain game) {
        super(game);

        fraction= GameFraction.ORC;

        sprites = new CharacterSprite("orcGrant");
        spriteHeight = sprites.height;
        spriteWidth = sprites.width;

        icon = new ImageIcon("C:\\myGame\\src\\res\\icons\\orcGrantIco.png").getImage();

        hp = 75;
        speed = 2;

        dirX = (int) (Math.random() * 1000) + 700;
        dirY = (int) (Math.random() * 500) + 50;

//        dirX = 1000;
//        dirY = 500;
    }
}
