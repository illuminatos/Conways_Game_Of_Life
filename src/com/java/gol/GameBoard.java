package com.java.gol;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameBoard implements ActionListener {

    private JPanel jPanel;
    private JButton[][] jButtonCells;
    public static final int TABLE_SIZE = 50;
    
    // thread to auto play and monitor the game board
    Thread gameThread;

    public GameBoard(){
        jPanel = new JPanel();
        jPanel.setBackground(Color.gray);
        jPanel.setLayout(new GridLayout(TABLE_SIZE,TABLE_SIZE,0,0));

        jButtonCells = new JButton[TABLE_SIZE][TABLE_SIZE];
        for(int i=0; i<TABLE_SIZE; i++){
            for(int j=0; j<TABLE_SIZE; j++){
                jButtonCells[i][j] = new JButton();
                jButtonCells[i][j].setBackground(Color.white);
                jButtonCells[i][j].setSize(10,10);
                jButtonCells[i][j].addActionListener(this);
                jButtonCells[i][j].setActionCommand("clicked");
                jPanel.add(jButtonCells[i][j]);
            }
        }
        
    }

    public JComponent getGameBoard(){
        return jPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("clicked")) {        	
            //when find clicked button, redirect selectedcells method to change state and color
        	selectedCells((JButton)e.getSource());
        }
    }

    public void selectedCells(JButton jButtonCell){
        //button is already selected
        if(jButtonCell.isSelected()){
            jButtonCell.setBackground(Color.WHITE);
            jButtonCell.setSelected(false);
        }//button is not selected so change state and color
        else{
            jButtonCell.setBackground(Color.BLUE);
            jButtonCell.setSelected(true);
        }
    }

    public void play() {
		if(AutoPlayer.getCurrState() != AutoPlayer.PLAYING) {
			AutoPlayer.setCurrState(AutoPlayer.PLAYING);
	        gameThread = new Thread(new AutoPlayer(this));
	        gameThread.start();
		}
    }
    
    public void pause() {
    	AutoPlayer.setCurrState(AutoPlayer.PAUSED);
   	}
    
    public void resetBoard(){
        for(int i=0; i<TABLE_SIZE; i++) {
            for (int j = 0; j < TABLE_SIZE; j++) {
                jButtonCells[i][j].setBackground(Color.WHITE);
                jButtonCells[i][j].setSelected(false);
            }
        }
    }

    public JButton[][] getjButtonCells() {
		return jButtonCells;
    }
}

