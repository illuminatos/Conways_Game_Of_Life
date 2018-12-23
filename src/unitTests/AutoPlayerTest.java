package unitTests;

import java.awt.Color;

import javax.swing.JButton;

import org.junit.Assert;
import org.junit.Test;
import com.java.gol.*;


public class AutoPlayerTest {

    GameBoard gameBoard = new GameBoard();

    AutoPlayer autoPlayer = new AutoPlayer(gameBoard);

    @Test
    public void playStepSelectedTest() {

        JButton[][] all_board = gameBoard.getjButtonCells();
        all_board[2][2].setSelected(true);
        all_board[2][2].setBackground(Color.BLUE);
        all_board[2][3].setSelected(true);
        all_board[2][3].setBackground(Color.BLUE);
        all_board[2][4].setSelected(true);
        all_board[2][4].setBackground(Color.BLUE);

        autoPlayer.playStep();
        //next generation selected test
        Assert.assertEquals(all_board[1][3].isSelected(), true);
        Assert.assertEquals(all_board[2][2].isSelected(), false);

    }

    @Test
    public void playStepColorTest() {

        JButton[][] all_board = gameBoard.getjButtonCells();
        all_board[2][2].setSelected(true);
        all_board[2][2].setBackground(Color.BLUE);
        all_board[2][3].setSelected(true);
        all_board[2][3].setBackground(Color.BLUE);
        all_board[2][4].setSelected(true);
        all_board[2][4].setBackground(Color.BLUE);

        //next generation^s color test
        Color initialBackGroundColor = all_board[1][3].getBackground();
        Assert.assertEquals(all_board[1][3].getBackground(),initialBackGroundColor);

        Color initialBackGroundColor2 = all_board[1][2].getBackground();
        Assert.assertEquals(all_board[1][2].getBackground(),initialBackGroundColor2);

    }


    @Test
    public void shouldThrowInterruptedException() {
        autoPlayer.setCurrState(1);
        autoPlayer.run();
       }

}
