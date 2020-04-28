package mainFiles;

import mainFiles.gameConventions.GameState;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    Image background = new ImageIcon("C:\\myGame\\src\\res\\menuBackground.png").getImage();
    Image humanButton = new ImageIcon("C:\\myGame\\src\\res\\HumanButton.png").getImage();
    Image orcButton = new ImageIcon("C:\\myGame\\src\\res\\OrcButton.png").getImage();
    Image exitButton = new ImageIcon("C:\\myGame\\src\\res\\ExitButton.png").getImage();

    int buttonWidth = humanButton.getWidth(null);
    int buttonHeight = humanButton.getHeight(null);

    int buttonX;
    int humanButtonY;
    int orcButtonY;
    int exitButtonY;

    Button b = new Button();

    MyMain game;

    public MainMenu(MyMain game) {
        this.game = game;

        b.checkImage(humanButton, buttonWidth, buttonHeight, null);

    }

    private void buttonInit() {
        buttonX = game.getWidth() / 2 - buttonWidth;
        humanButtonY = game.getHeight() / 2 - buttonHeight * 2;
        orcButtonY = game.getHeight() / 2 + buttonHeight * 2;
        exitButtonY = game.getHeight() / 2 + buttonHeight * 6;
    }

    public void drawMenu(Graphics g) {
        buttonInit();
        g.drawImage(background, 0, 0, game.getWidth(), game.getHeight(), null);
        g.drawImage(humanButton, buttonX, humanButtonY,
                buttonWidth * 2, buttonHeight * 2, null);
        g.drawImage(orcButton, buttonX, orcButtonY,
                buttonWidth * 2, buttonHeight * 2, null);
        g.drawImage(exitButton, buttonX, exitButtonY,
                buttonWidth * 2, buttonHeight * 2, null);
    }

    public void clickCheck() {
        if (game.player.x > buttonX && game.player.x < buttonX + buttonWidth) {
            if (game.player.y < humanButtonY + buttonHeight
                    && game.player.y > humanButtonY) {
                game.gameState = GameState.IN_GAME;
            }
            if (game.player.y < orcButtonY + buttonHeight
                    && game.player.y > orcButtonY) {
                game.gameState = GameState.IN_GAME;
            }
            if (game.player.y < exitButtonY + buttonHeight
                    && game.player.y > exitButtonY) {
                game.gameState = GameState.IN_MENU;
            }
        } else game.gameState = GameState.IN_MENU;
    }

}
