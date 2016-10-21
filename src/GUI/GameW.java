package GUI;

import javax.swing.*;
import Gameplay.SuperTGame;
import Players.HumanHandle;

import java.awt.event.ActionEvent;
//TODO add all cards to horizontal box layout (as buttons with image icons)
//TODO FIX Things disapearing

/**
 * Created by Adroso360 on 9/10/2016.
 */
public class GameW extends JFrame {
    private JScrollPane hand;
    private JPanel gamePanel = new JPanel();
    private JLabel cCard = new JLabel();
    private JLabel cPlayer = new JLabel();
    private JLabel cCat = new JLabel();
    private JPanel catSelection = new JPanel();
    private JButton cleavage = new JButton("Cleavage");
    private JButton hardness = new JButton("Hardness");
    private JButton specGravity = new JButton("Specific Gravity");
    private JButton crustAbund = new JButton("Crustal Abundance");
    private  JButton ecoValue = new JButton("Economic Value");
    public static GameW gameW;

    public GameW(){
        GameW.gameW = this;
        setVisible(true);
        pack();
        setContentPane(gamePanel);
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
        setSize(1000, 500);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gamePanel.add(cCard);
        gamePanel.add(cPlayer);
        gamePanel.add(cCat);catSelection.setVisible(false);
        catSelection.setLayout(new BoxLayout(catSelection, BoxLayout.X_AXIS));
        gamePanel.add(catSelection);
        catSelection.add(cleavage);
        catSelection.add(hardness);
        catSelection.add(specGravity);
        catSelection.add(crustAbund);
        catSelection.add(ecoValue);

        cleavage.addActionListener(e ->{
            HumanHandle.humanHandle.categoryNotifier("Cleavage");

        });
        hardness.addActionListener(e ->{
            HumanHandle.humanHandle.categoryNotifier("Hardness");

        });
        specGravity.addActionListener(e ->{
            HumanHandle.humanHandle.categoryNotifier("Specific gravity");

        });
        crustAbund.addActionListener(e ->{
            HumanHandle.humanHandle.categoryNotifier("Crustal abundance");

        });
        ecoValue.addActionListener(e ->{
            HumanHandle.humanHandle.categoryNotifier("Economic value");

        });

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
    public void displayCatChoice(){
        catSelection.setVisible(true);
    }
    public void hideCatChoice(){
        catSelection.setVisible(false);
    }



}
