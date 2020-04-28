package characters;

import mainFiles.Direction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CharacterSprite {
    public BufferedImage characterImage;
    public Map<Direction, Map<Activity, Image[]>> characterSprites = new HashMap<>();

    public int width;
    public int height;

    public CharacterSprite(String imageName) {
        textureInit(imageName);
    }

    public void textureInit(String imageName) {
        File file = new File("C:\\myGame\\src\\res\\characterSprites\\" + imageName + ".png");
        try {
            characterImage = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = characterImage.getWidth() / 12;
        height = characterImage.getHeight() / 8;

        setSprites();
    }

//    private void setSprites() {
//        for (Direction dir : Direction.values()) {
//            if (dir != Direction.NONE) {
//                for (Activity activity : Activity.values()) {
//                    Map<Activity, Image[]> activityMap = new HashMap<>();
//                    Image[] tmp = new Image[activity.number];
//                    for (int i = 0; i < activity.number; i++) {
//                        tmp[i] = characterImage.getSubimage(i * width, dir.count * height,
//                                width, height)
//                                .getScaledInstance(width, height, Image.SCALE_SMOOTH);
//                    }
//
//                    activityMap.put(activity, tmp);
//                    characterSprites.put(dir, activityMap);
//                }
//            }
//        }
//    }

    private void setActivity() {
        for (Direction dir : Direction.values()) {
            for (Activity activity : Activity.values()) {
                Map<Activity, Image[]> tmp = new HashMap<>();
                tmp.put(activity, new Image[activity.number]);
                characterSprites.put(dir, tmp);
            }
        }
    }

    private void setSprites() {
        setActivity();
        for (Direction dir : Direction.values()) {
            if (dir != Direction.NONE) {
                for (Activity activity : Activity.values()) {
                    Image[] tmp = new Image[activity.number];
                    for (int i = activity.start; i < activity.number; i++) {
                        tmp[i] = characterImage.getSubimage(i * width, dir.count * height,
                                width, height)
                                .getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    }

                    characterSprites.get(dir).put(activity, tmp);
                }
            }
        }
    }
}
