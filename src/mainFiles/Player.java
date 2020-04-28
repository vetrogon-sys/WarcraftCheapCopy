package mainFiles;

import characters.Activity;
import characters.Character;
import mainFiles.gameConventions.GameFraction;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int POINT_RANGE = 10;

    public MyMain game;
    public int x;
    public int y;

    public GameFraction fraction = GameFraction.HUMANS;

    int[] selectedAreaCords = new int[4];

    public List<Character> party = new ArrayList<>();

    public Player(MyMain game) {
        this.game = game;
    }

    public void mouseClicked(MouseEvent e) {
        int key = e.getButton();
        if (key == MouseEvent.BUTTON1) {
            if(!party.isEmpty()) {
                x = e.getX();
                y = e.getY();
                setPartyDirection();
            }
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
                if (!party.contains(character)) {
                    party.add(character);
                    character.activity = Activity.STAND;
                }
            }
        }

//        if(party != null
//                && x == 0
//                && y == 0) {
//            x = party.get(0).dirX;
//            y = party.get(0).dirY;
//        }

    }

}


