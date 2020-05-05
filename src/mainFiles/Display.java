package mainFiles;

import javax.swing.*;

public class Display {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setFocusable(true);

        frame.setResizable(false);
        frame.setUndecorated(true);

        MyMain game = new MyMain(frame);

        frame.add(game);

        frame.setVisible(true);
    }

}
