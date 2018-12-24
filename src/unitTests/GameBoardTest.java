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

        autoPlayer.setCurrState(AutoPlayer.PLAYING);
        int state = autoPlayer.getCurrState();
        Assert.assertEquals(AutoPlayer.PLAYING, state);

        gameBoard.pause();

        state = autoPlayer.getCurrState();
        Assert.assertEquals(AutoPlayer.PAUSED, state);
    }

    @Test
    public void resetBoardTest() {
        JButton[][] cells = gameBoard.getjButtonCells();
        cells[0][0].setBackground(Color.BLUE);
        cells[0][1].setBackground(Color.BLUE);
        cells[0][2].setBackground(Color.BLUE);

        gameBoard.resetBoard();

        Color initialBackGroundColor = Color.WHITE;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Assert.assertEquals(cells[i][j].getBackground(), initialBackGroundColor);
            }
        }
    }

}
