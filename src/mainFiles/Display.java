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

        frame.add(new MyMain(frame));


        frame.setVisible(true);
    }
}
