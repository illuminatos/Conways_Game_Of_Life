package com.java.gol;
import javax.swing.*;
import java.awt.*;

public class GuiFrame {

    private JFrame jFrame;
    private final int width = 800;
    private final int height = 600;

    private MenuBar menuBar;
    private GameBoard gameBoard;

    public GuiFrame(){

        jFrame = new JFrame("Game OF Life");
        jFrame.setSize(width,height);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

        menuBar = new MenuBar();
        jFrame.add(menuBar.getMenuBar(),BorderLayout.NORTH);

        gameBoard = new GameBoard();
        jFrame.add(gameBoard.getGameBoard(), BorderLayout.CENTER);
        menuBar.setGameBoard(gameBoard);
        //jFrame.pack();
        jFrame.setVisible(true);

    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }
}

