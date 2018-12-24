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

        setButtonProps(all_board[2][2], true);
        setButtonProps(all_board[2][3], true);
        setButtonProps(all_board[2][4], true);

        autoPlayer.playStep();
        //next generation selected test alive and die
        Assert.assertEquals(all_board[1][3].isSelected(), true);
        Assert.assertEquals(all_board[2][2].isSelected(), false);
    }

    @Test
    public void playStepColorTest() {
        JButton[][] all_board = gameBoard.getjButtonCells();
        setButtonProps(all_board[2][2], true);
        setButtonProps(all_board[2][3], true);
        setButtonProps(all_board[2][4], true);

        autoPlayer.playStep();

        //next generation selected test alive and die
        Assert.assertEquals(all_board[1][3].getBackground(), Color.BLUE);
        Assert.assertEquals(all_board[2][2].getBackground(), Color.WHITE);
    }

    // setting up button properties
    private void setButtonProps(JButton button, boolean is_selected) {
        button.setSelected(is_selected);
        button.setBackground(Color.BLUE);
    }

    @Test
    public void shouldThrowInterruptedException() {
        autoPlayer.setCurrState(1);
        autoPlayer.run();
    }

}
