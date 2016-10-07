package GUI;

/**
 * Created by Adroso360 on 5/10/2016.
 */

import javax.swing.*;
import java.awt.*;

public class GUITest {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Mineral Super Trumps! - The Computer Game!");
        Font mainFont = new Font("Arial", Font.ITALIC, 35);
        mainFrame.setSize(1100, 700);
        mainFrame.setVisible(true);
        mainFrame.setDefaultLookAndFeelDecorated(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
