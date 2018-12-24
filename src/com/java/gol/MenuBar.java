package com.java.gol;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar implements ActionListener {

    private JPanel jPanel;
    private JButton jb_play;
    private JButton jb_pause;
    private JButton jb_reset;
    private JButton jb_exit;

    private GameBoard gameBoard;

    public MenuBar(){
        jPanel = new JPanel();

        createAndAddButtons(jPanel);
    }

    //create panel and game buttons
    public void createAndAddButtons(JPanel jPanel) {
        createButton(jPanel, jb_play, "Play");
        createButton(jPanel, jb_pause, "Pause");
        createButton(jPanel, jb_reset, "Exit");
    }

    private void createButton(JPanel panel, JButton button, String button_name) {
        button = new JButton(button_name);
        button.addActionListener(this);
        panel.add(button);
    }

    public JComponent getMenuBar(){
        return jPanel;
    }

    //setting buttons duty and visibility through the game
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jb_exit)){
            System.exit(0);
        }else if(e.getSource().equals(jb_play)){
             jb_pause.setEnabled(true);
             jb_play.setEnabled(false);
             this.gameBoard.play();
        } else {
             // if button is either reset or pause button
             jb_pause.setEnabled(false);
             jb_play.setEnabled(true);
             if(e.getSource().equals(jb_reset)) {
                 gameBoard.resetBoard();
             } else {
                 this.gameBoard.pause();
             }
        }
    }
    
    void setGameBoard(GameBoard gameBoard) {
    	this.gameBoard = gameBoard;
    }
}
