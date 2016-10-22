package GUI;

import javax.swing.*;

import Cards.Card;
import Cards.SuperTDeck;
import Gameplay.SuperTGame;
import Players.HumanHandle;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
//TODO add all cards to horizontal box layout (as buttons with image icons)
//TODO FIX Things disapearing

/**
 * Created by Adroso360 on 9/10/2016.
 */
public class GameW extends JFrame {
    //Hand
    private int handSize;
    private JScrollPane handScroll;
    private JButton handButtons [];
    private JPanel playerHand = new JPanel();
    //Other
    private JPanel gamePanel = new JPanel();
    private JLabel cCard = new JLabel();
    private JLabel cPlayer = new JLabel();
    private JLabel cCat = new JLabel();
    private JPanel catSelection = new JPanel();
    private JLabel majorStatus = new JLabel();
    private JLabel gameStatus = new JLabel();
    private JLabel catPrompt = new JLabel("Please Choose a Category: ");
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
        gamePanel.add(cPlayer);
        gamePanel.add(cCat);
        gamePanel.add(majorStatus);
        gamePanel.add(cCard);
        catSelection.setVisible(false);
        catSelection.setLayout(new BoxLayout(catSelection, BoxLayout.X_AXIS));
        gamePanel.add(gameStatus);
        gamePanel.add(catSelection);
        catSelection.add(catPrompt);
        catSelection.add(cleavage);
        catSelection.add(hardness);
        catSelection.add(specGravity);
        catSelection.add(crustAbund);
        catSelection.add(ecoValue);
        gamePanel.add(playerHand);



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

        //running in background
        new Thread(() -> {
            new SuperTGame(4, this);
        }).start();

    }

    public void displayCard(String fileName){
        cCard.setIcon(new ImageIcon(new ImageIcon("images/" + fileName).getImage().getScaledInstance((int)Math.floor(300 * 0.714), 300,  java.awt.Image.SCALE_SMOOTH)));
        cCard.setVisible(true);
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
        gamePanel.setVisible(true);
    }
    public void hideCatChoice(){
        catSelection.setVisible(false);
        invalidate();
        repaint();
    }
    public  void changeStatus(String status){
        gameStatus.setText(status);
        invalidate();
        repaint();
    }

    public void clearStatus(){
        gameStatus.setText("");
    }
    public  void changeMajorStatus(String status){
        gameStatus.setText(status);
        invalidate();
        repaint();
    }

    public void clearMajorStatus(){
        gameStatus.setText("");
    }

    public void handGUIGenerator(ArrayList<Card> hand){
        playerHand.removeAll();
        handSize = hand.size();
        for (int i=0; i < handSize ;i++) {
            JButton card = new JButton();
            card.setIcon(new ImageIcon(new ImageIcon("images/" + hand.get(i).fileName).getImage().getScaledInstance((int)Math.floor(150 * 0.714), 150,  java.awt.Image.SCALE_SMOOTH)));
           // playerHand.add(new JButton());
            playerHand.add(card);
            int finalI1 = i;
            card.addActionListener(e ->{
                HumanHandle.humanHandle.cardNotifier(finalI1);
                playerHand.remove(card);
            });
        }
        JButton skip = new JButton();
        skip.setIcon(new ImageIcon(new ImageIcon("images/Slide66.jpg").getImage().getScaledInstance((int)Math.floor(150 * 0.714), 150,  java.awt.Image.SCALE_SMOOTH)));
        playerHand.add(skip);
        skip.addActionListener(e -> {
            HumanHandle.humanHandle.cardNotifier(handSize);
            playerHand.removeAll();
        });
        invalidate();
        repaint();
    }

}
