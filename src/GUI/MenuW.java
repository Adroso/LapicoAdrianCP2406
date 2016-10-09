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

    public MenuW(String title){
        super(title);
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        quitButton.addActionListener(e -> {
            System.exit(1);
        });

        gameRulesButton.addActionListener(e -> JOptionPane.showMessageDialog(this ,"Hi in a future patch game rules will be located here"));

        startGameButton.addActionListener(e -> {
            setVisible(false);


        });
    }








}
