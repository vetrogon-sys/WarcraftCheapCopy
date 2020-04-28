package characters;

import mainFiles.gameConventions.GameFraction;
import mainFiles.MyMain;

public class ElfArcher extends Character {

    public ElfArcher(MyMain game) {
        super(game);

        fraction= GameFraction.HUMANS;

        sprites = new CharacterSprite("archer");
        spriteHeight = sprites.height;
        spriteWidth = sprites.width;

        hp = 100;
        speed = 3;

        dirX = (int) (Math.random() * 1000) + 700;
        dirY = (int) (Math.random() * 500) + 50;

//        dirX = 1000;
//        dirY = 500;
    }


}
