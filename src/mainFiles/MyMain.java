package mainFiles;

import characters.Character;
import characters.successors.*;
import mainFiles.gameConventions.GameState;
import supply.Supply;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class MyMain extends JPanel implements ActionListener {
    private static final int SCALE = 2;

    public JFrame frame;
    public Timer timer = new Timer(20, this);

    GameState gameState;

    public Image mainMap = new ImageIcon("C:\\myGame\\src\\res\\map.jpg").getImage();
    public MiniMap miniMap;

    public java.util.List<Character> characters = new ArrayList<>();
    public java.util.List<Supply> supplies = new ArrayList<>();
    public Player player;

    public MyMain(JFrame frame) {
        this.frame = frame;
        this.timer.start();
        this.gameState = GameState.IN_GAME;

        this.player = new Player(this);
        this.miniMap = new MiniMap(mainMap);

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
        if (gameState == GameState.IN_GAME) {
            g.drawImage(mainMap, player.mapX, player.mapY,
                    mainMap.getWidth(null), mainMap.getHeight(null), null);

            for (Character c : characters) {
                g.drawImage(c.currentFrame, c.dirX, c.dirY,
                        c.spriteWidth * SCALE, c.spriteHeight * SCALE, null);

                if (!player.party.isEmpty()) {
                    paintHighlighting((Graphics2D) g);
                }
            }

            if (!supplies.isEmpty()) {
                for (Supply supply : supplies) {
                    g.drawImage(supply.currentFrame, supply.dirX, supply.dirY,
                            supply.width * SCALE, supply.height * SCALE, null);
                }
            }

            g.drawImage(new ImageIcon("C:\\myGame\\src\\res\\GameInterface.png").getImage(), 0, 0, null);
            if (!player.party.isEmpty()) {
                paintIco(g);
            }
            miniMap.paintMiniMap(g);
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
                if (!player.party.contains(c)) {
                    c.walkDirection();
                }
                c.move();
            }
        }

        if (!supplies.isEmpty()) {
            for (Supply supply : supplies) {
                try {
                    supply.move();
                } catch (ConcurrentModificationException ignored) {
                }
            }
        }

        repaint();
    }

}
