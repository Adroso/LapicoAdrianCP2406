package GUI;

import javax.swing.*;

/**
 * Created by Adroso360 on 9/10/2016.
 */
public class GameW extends JFrame {
    private JScrollPane hand;
    private JPanel gamePanel;

    public GameW(){
        setVisible(true);
        pack();
        setContentPane(gamePanel);
        setSize(1000, 500);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
