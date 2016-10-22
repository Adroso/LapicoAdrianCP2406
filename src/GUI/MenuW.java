package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Adroso360 on 9/10/2016.
 */
public class MenuW extends JFrame {

    private JButton quitButton;
    private JButton startGameButton;
    private JButton gameRulesButton;
    private JPanel rootPanel;
    public static MenuW menuW;

    public MenuW(String title){
        super(title);
        MenuW.menuW =this;
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        quitButton.addActionListener(e -> {
            System.exit(1);
        });

        gameRulesButton.addActionListener(e -> JOptionPane.showMessageDialog(this ,"This is a game designed by to help players learn about the properties\n" +
                "and uses of economically-significant and common rock-forming minerals.\n\n" +
                "The deck consists of 54 mineral cards and 6 “supertrump” cards.\n\n" +
                "Each mineral card includes information about the mineral such as the generic chemical formula,\n" +
                "the classification, crystal system, the geological environment where the mineral is\n" +
                "commonly found or formed (igneous, metamorphic, sedimentary, or the mantle), as well as information in the\n" +
                "five playing categories (or trumps) of Hardness, Specific Gravity, Cleavage, Crustal Abundance, and Economic Value.\n" +
                "The first three trump categories relate to distinct physical properties of the mineral,\n" +
                "while last two categories rate the importance of the mineral in terms of abundance in the\n" +
                "Earths crust (continental and oceanic) and value to modern societies.\n" +
                "\n" +
                "Number of players: 3 to 5\n" +
                "\n\n" +
                "Objective: To be the first player to lose all of your cards"));

        startGameButton.addActionListener(e -> {
            setVisible(false);
            new GameW();
        });
    }
}
