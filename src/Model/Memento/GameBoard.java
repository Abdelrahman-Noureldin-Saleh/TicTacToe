/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Memento;

import Model.Mediator.IColleague;
import Model.State.Player;
import Model.State.Cell;

/**
 *
 * @author Abd El Rahman
 */
public class GameBoard implements IColleague{
    
    private Player player = new Player();
    private Cell[][] board = new Cell[3][3];

    public GameBoard() {
        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j<board[i].length; j++)
                board[i][j] = new Cell();
        }
    }
    

    @Override
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public Cell[][] getCells() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }
 
    @Override
    public GameBoard clone() {
        GameBoard copyOfBoard = new GameBoard();
        Cell[][] newCell = new Cell[3][3];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                    newCell[i][j] = board[i][j].clone();
        copyOfBoard.setBoard(newCell);
        copyOfBoard.setPlayer(this.player.clone());
        return copyOfBoard;
    }    
    
}
