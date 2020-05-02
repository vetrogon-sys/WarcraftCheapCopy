package mainFiles;

import characters.Activity;
import characters.Character;
import mainFiles.gameConventions.GameFraction;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int POINT_RANGE = 40;
    private static final int MAX_PARTY_SIZE = 12;

    private static final int MAP_STARTED_X = 525;
    private static final int MAP_STARTED_Y = 32;
    private static final int INTERFACE_X_SIZE = 1354;
    private static final int INTERFACE_Y_SIZE = 1022;
    private static final int MAP_MOVE_SPED = 20;

    public MyMain game;
    public int x;
    public int y;

    public int mapX = MAP_STARTED_X;
    public int mapY = MAP_STARTED_Y;

    public GameFraction fraction = GameFraction.ORC;

    int[] selectedAreaCords = new int[4];

    public List<Character> party = new ArrayList<>();

    public Player(MyMain game) {
        this.game = game;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_DOWN
                && mapY >= MAP_STARTED_Y + INTERFACE_Y_SIZE - game.mainMap.getHeight(null)) {
            mapY -= MAP_MOVE_SPED;
            for (Character character : game.characters) {
                character.dirY -= MAP_MOVE_SPED;
            }
        } else if (key == KeyEvent.VK_UP
                && mapY <= MAP_STARTED_Y - POINT_RANGE / 2) {
            mapY += MAP_MOVE_SPED;
            for (Character character : game.characters) {
                character.dirY += MAP_MOVE_SPED;
            }
        } else if (key == KeyEvent.VK_RIGHT
                && mapX >= MAP_STARTED_X + INTERFACE_X_SIZE - game.mainMap.getWidth(null)) {
            mapX -= MAP_MOVE_SPED;
            for (Character character : game.characters) {
                character.dirX -= MAP_MOVE_SPED;
            }
        } else if (key == KeyEvent.VK_LEFT
                && mapX <= MAP_STARTED_X - POINT_RANGE / 2) {
            mapX += MAP_MOVE_SPED;
            for (Character character : game.characters) {
                character.dirX += MAP_MOVE_SPED;
            }
        }

    }

    public void mouseClicked(MouseEvent e) {
        int key = e.getButton();
        if (key == MouseEvent.BUTTON1) {
            if (!party.isEmpty()) {
                x = e.getX();
                y = e.getY();
                setPartyDirection();
            }
        }
        if (key == MouseEvent.BUTTON2) {
            party.removeAll(party);
        }
    }

    private void setPartyDirection() {
        if (!party.isEmpty()) {
            for (Character character : party) {
                changeDirection(character);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        selectedAreaCords[0] = e.getX();
        selectedAreaCords[1] = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        selectedAreaCords[2] = e.getX();
        selectedAreaCords[3] = e.getY();

        if (selectedAreaCords[0] > selectedAreaCords[2]) {
            selectedAreaCords[2] = selectedAreaCords[0];
            selectedAreaCords[0] = e.getX();

            selectedAreaCords[3] = selectedAreaCords[1];
            selectedAreaCords[1] = e.getY();
        }

        addToParty();
    }

    public void changeDirection(Character character) {
        if (character.dirX < x && character.dirY > y
                && character.dirX + character.spriteWidth < x) {
            character.direction = Direction.RIGHT_UP;
        } else if (character.dirX < x && character.dirX + character.spriteWidth > x
                && character.dirY > y) {
            character.direction = Direction.UP;
        } else if (character.dirX > x && character.dirY > y) {
            character.direction = Direction.LEFT_UP;
        } else if (character.dirY < y && character.dirY + character.spriteHeight > y
                && character.dirX > x) {
            character.direction = Direction.LEFT;
        } else if (character.dirX > x && character.dirY < y
                && character.dirY + character.spriteHeight < y) {
            character.direction = Direction.LEFT_DOWN;
        } else if (character.dirX < x && character.dirX + character.spriteWidth > x
                && character.dirY + character.spriteHeight < y) {
            character.direction = Direction.DOWN;
        } else if (character.dirX < x && character.dirY < y
                && character.dirX + character.spriteWidth < x
                && character.dirY + character.spriteHeight < y) {
            character.direction = Direction.RIGHT_DOWN;
        } else if (character.dirY < y && character.dirY + character.spriteHeight > y
                && character.dirX + character.spriteWidth < x) {
            character.direction = Direction.RIGHT;
        }
    }

    private void addToParty() {
        for (Character character : game.characters) {
            if (character.dirX > selectedAreaCords[0]
                    && character.dirX + character.spriteWidth < selectedAreaCords[2]
                    && character.dirY > selectedAreaCords[1]
                    && character.dirY + character.spriteWidth < selectedAreaCords[3]) {
                if (!party.contains(character)
                        && party.size() < MAX_PARTY_SIZE
                        && character.fraction == fraction) {
                    party.add(character);
                    character.activity = Activity.STAND;
                }
            }
        }

    }

}


