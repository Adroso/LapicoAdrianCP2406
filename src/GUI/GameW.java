package GUI;

import javax.swing.*;
import Gameplay.SuperTGame;

/**
 * Created by Adroso360 on 9/10/2016.
 */
public class GameW extends JFrame {
    private JScrollPane hand;
    private JPanel gamePanel = new JPanel();
    private JLabel cCard = new JLabel();
    private JLabel cPlayer = new JLabel();
    private JLabel cCat = new JLabel();

    public GameW(){
        setVisible(true);
        pack();
        setContentPane(gamePanel);
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
        setSize(1000, 500);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gamePanel.add(cCard);
        gamePanel.add(cPlayer);
        gamePanel.add(cCat);
        //TODO number players input

        new Thread(() -> {
            new SuperTGame(4, this);
        }).start();

    }

    public void displayCard(String fileName){
        cCard.setIcon(new ImageIcon(new ImageIcon("images/" + fileName).getImage().getScaledInstance((int)Math.floor(300 * 0.714), 300,  java.awt.Image.SCALE_SMOOTH)));
        invalidate();
        repaint();
    }
    public void displayPlayer(String playerName){
        cPlayer.setText("Current Player: Player " + playerName);
        invalidate();
        repaint();
    }
    public void displayCat(String categoryName){
        cCat.setText("Current Category: " + categoryName);
        invalidate();
        repaint();

    }


}
