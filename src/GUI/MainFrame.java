package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Adroso360 on 9/10/2016.
 */
public class MainFrame extends JFrame {
    public MainFrame(String title){
        super(title);
        //Layout Manager
        setLayout(new BorderLayout());

        //Components
        JLabel heading = new JLabel("Mineral SuperTrumps The Game!!!!!");
        JButton startPrompt =  new JButton("Start Game");
        JButton infoPrompt = new JButton("Game Information");
        JButton quitPrompt = new JButton("Quit");

        //Content Pane
        Container mm = getContentPane();
        mm.add(heading,BorderLayout.PAGE_START);
        mm.add(infoPrompt, BorderLayout.LINE_START);
        mm.add(startPrompt, BorderLayout.CENTER);
        mm.add(quitPrompt, BorderLayout.LINE_END);

        infoPrompt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hi");
            }
        });
    }
}
