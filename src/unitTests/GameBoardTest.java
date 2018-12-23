package unitTests;

import com.java.gol.AutoPlayer;
import com.java.gol.GameBoard;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class GameBoardTest {

    GameBoard gameBoard = new GameBoard();
    AutoPlayer autoPlayer = new AutoPlayer(gameBoard);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void pauseTest() {

        autoPlayer.setCurrState(1);
        int state = autoPlayer.getCurrState();
        gameBoard.pause();
        Assert.assertEquals(autoPlayer.getCurrState(), state);
    }

    @Test
    public void resetBoardTest() {

        JButton[][] testCells = new JButton[50][50];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                testCells[i][j] = new JButton();
                testCells[i][j].setBackground(Color.white);
                testCells[i][j].setSize(10, 10);
            }
        }

        gameBoard.resetBoard();
        Color initialBackGroundColor = Color.WHITE;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Assert.assertEquals(testCells[i][j].getBackground(), initialBackGroundColor);
            }
        }
    }

}
