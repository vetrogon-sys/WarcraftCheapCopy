package mainFiles;

import characters.*;
import characters.Character;
import mainFiles.gameConventions.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyMain extends JPanel implements ActionListener {
    private static final int SCALE = 2;

    public JFrame frame;
    public Timer timer = new Timer(20, this);

    GameState gameState;
    public MainMenu menu;

    public Image mainMap = new ImageIcon("C:\\myGame\\src\\res\\map.jpg").getImage();

    public java.util.List<Character> characters = new ArrayList<>();
    public Player player;

    public MyMain(JFrame frame) {
        this.frame = frame;
        this.timer.start();
        this.gameState = GameState.IN_GAME;
        this.menu = new MainMenu(this);
        this.player = new Player(this);

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                player.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                player.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                player.mouseReleased(e);
            }
        });

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });

        characters.add(new ElfArcher(this));
        characters.add(new HumanMagician(this));
        characters.add(new HumanKnight(this));

        characters.add(new Troll(this));
        characters.add(new OrcGrant(this));
    }

    public void paint(Graphics g) {
        if (gameState == GameState.IN_MENU) {
            menu.drawMenu(g);
            menu.clickCheck();
        }
        if (gameState == GameState.IN_GAME) {
            g.drawImage(mainMap, player.mapX, player.mapY,
                    mainMap.getWidth(null), mainMap.getHeight(null), null);

            for (Character c : characters) {
                g.drawImage(c.currentFrame, c.dirX, c.dirY,
                        c.spriteWidth * SCALE, c.spriteHeight * SCALE, null);
            }

            g.drawImage(new ImageIcon("C:\\myGame\\src\\res\\GameInterface.png").getImage(), 0, 0, null);
            g.drawImage(mainMap, 62, 53, 398, 300, null);

            if (!player.party.isEmpty()) {
                paintHighlighting((Graphics2D) g);
                paintIco(g);
            }

        }

    }

    public void paintHighlighting(Graphics2D g) {
        g.setColor(Color.GREEN);
        for (Character character : player.party) {
            g.drawRect(character.dirX + character.spriteWidth / 4, character.dirY + character.spriteHeight / 4,
                    (int) (character.spriteWidth * 1.5 - 10), (int) (character.spriteHeight * 1.5));
        }
    }

    public void paintIco(Graphics g) {
        int wdFactor = 0;
        int hgFactor = 0;
        for (Character character : player.party) {
            if (wdFactor == 4) {
                hgFactor++;
                wdFactor = 0;
            }
            g.drawImage(character.icon, (68 + character.iconWidth * SCALE * wdFactor + 6 * wdFactor),
                    (361 + character.iconHeight * SCALE * hgFactor + 10 * hgFactor),
                    character.iconWidth * SCALE, character.iconHeight * SCALE, null);
            wdFactor++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (characters != null) {
            for (Character c : characters) {
                c.walkDirection();
                c.move();
            }
        }
        repaint();
    }

}
