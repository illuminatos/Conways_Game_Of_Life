package com.java.gol;
import java.awt.Color;

import javax.swing.JButton;

public class AutoPlayer implements Runnable {

	public static final int PLAYING = 0;
	public static final int PAUSED  = 1;
	
	// update interval in milliseconds
	public static int TIME_INTERVAL_MS = 200;
	
	GameBoard board;
	
	static int curr_state = PAUSED;
	
	public AutoPlayer(GameBoard board) {
		this.board = board;
	}
	
	@Override
	public void run() {
		while(AutoPlayer.getCurrState() == PLAYING) {
			try {
				Thread.sleep(TIME_INTERVAL_MS);
				playStep();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void playStep() {
		// 1 . Births: Each dead cell adjacent to exactly three live neighbors will become live in the next generation.
		// 2 . Death by isolation: Each live cell with one or fewer live neighbors will die in the next generation.
		// 3 . Death by overcrowding: Each live cell with four or more live neighbors will die in the next generation.
		// 4 . Survival: Each live cell with either two or three live neighbors will remain alive for the next generation.

		//extend border of button table left,right, top, bottom with table_size+2 to check border cell either alive or death
        boolean[][] gameBoard = new boolean[GameBoard.TABLE_SIZE + 2][GameBoard.TABLE_SIZE + 2];

        JButton[][] all_board_buttons = this.board.getjButtonCells();
        int size = all_board_buttons.length;
        
        for(int i = 0; i < size; i++) {
        	for(int j = 0; j < size; j++) {
        		if(all_board_buttons[i][j].isSelected()) {
        			gameBoard[i+1][j+1] = true;
        			all_board_buttons[i][j].setSelected(false);
        			all_board_buttons[i][j].setBackground(Color.WHITE);
        		}
        	}
        }

        // counting neighbors with iterate array of whole button table
        for (int i=1; i<gameBoard.length-1; i++) {
            for (int j=1; j<gameBoard[0].length-1; j++) {
                int surrounding = 0;
                if (gameBoard[i-1][j-1]) { surrounding++; }
                if (gameBoard[i-1][j])   { surrounding++; }
                if (gameBoard[i-1][j+1]) { surrounding++; }
                if (gameBoard[i][j-1])   { surrounding++; }
                if (gameBoard[i][j+1])   { surrounding++; }
                if (gameBoard[i+1][j-1]) { surrounding++; }
                if (gameBoard[i+1][j])   { surrounding++; }
                if (gameBoard[i+1][j+1]) { surrounding++; }
                if (gameBoard[i][j]) {

            		// 4 . Survival: Each live cell with either two or three live neighbors will remain alive for the next generation.
                	if ((surrounding == 2) || (surrounding == 3)) {
                		all_board_buttons[i-1][j-1].setSelected(true);
                		all_board_buttons[i-1][j-1].setBackground(Color.BLUE);
                    } 
                } else {
            		// 1 . Births: Each dead cell adjacent to exactly three live neighbors will become live in the next generation.
                	if (surrounding == 3) {
                		if(validatePosition(i, j))
                			all_board_buttons[i-1][j-1].setSelected(true);
                			all_board_buttons[i-1][j-1].setBackground(Color.BLUE);
                	}
                }
            }
        }
	}
	
	public boolean validatePosition(int x, int y) {
		return x >= 0 && y >= 0 && x < GameBoard.TABLE_SIZE && y < GameBoard.TABLE_SIZE;
	}
	
	public static void setCurrState(int newState) {
		AutoPlayer.curr_state = newState;
	}

	public static int getCurr_state() {
		return curr_state;
	}

	public static int getCurrState() {
		return AutoPlayer.curr_state;
	}

}
