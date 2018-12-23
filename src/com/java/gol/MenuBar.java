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

        jb_play = new JButton("Play");
        jb_play.addActionListener(this);

        jb_pause = new JButton("Pause");
        jb_pause.addActionListener(this);
        jb_pause.setEnabled(false);

        jb_reset = new JButton("Reset");
        jb_reset.addActionListener(this);

        jb_exit = new JButton("Exit");
        jb_exit.addActionListener(this);

        jPanel.add(jb_play);
        jPanel.add(jb_pause);
        jPanel.add(jb_reset);
        jPanel.add(jb_exit);

    }

    public JComponent getMenuBar(){
        return jPanel;
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(jb_exit)){
            System.exit(0);
        }else if(e.getSource().equals(jb_play)){
        	 jb_reset.setEnabled(true);
             jb_pause.setEnabled(true);
             jb_play.setEnabled(false);
             this.gameBoard.play();
        }else if(e.getSource().equals(jb_pause)){
        	 jb_reset.setEnabled(true);
             jb_pause.setEnabled(false);
             jb_play.setEnabled(true);
             this.gameBoard.pause();
        }else if(e.getSource().equals(jb_reset)){
            jb_reset.setEnabled(true);
            jb_pause.setEnabled(false);
            jb_play.setEnabled(true);
            gameBoard.resetBoard();
        }
    }
    
    void setGameBoard(GameBoard gameBoard) {
    	this.gameBoard = gameBoard;
    }
}
