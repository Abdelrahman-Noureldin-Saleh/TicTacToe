/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Strategy;

import Model.Mediator.IColleague;
import Model.Mediator.Mediator;
import Model.Memento.GameBoard;
import Model.State.Cell;
import Model.State.Player;

/**
 *
 * @author Abd El Rahman
 */

public abstract class Level implements IColleague{
    
    public Level() {

    }
    
    Mediator mediator = new Mediator();

    public GameBoard getGameBoard() {
        return mediator.getCurrentBoard();
    }

    public void updateGameBoard(GameBoard newBoard) {
        mediator.setCurrentBoard(newBoard);
    }
    
    public void undo(){
        mediator.undo();
    }
    
    public void redo(){
        mediator.redo();
    }
    
    public void save(){
        mediator.save();
    }
    
    public boolean playIn(int i,int j){ 
        try 
        {
            return mediator.getCurrentBoard().getCells()[i][j].Fill(mediator.getCurrentBoard().getPlayer());
        } catch (ArrayIndexOutOfBoundsException ex){
            return false;
        }
    }
    
    @Override
    public Cell[][] getCells(){
        return mediator.getCurrentBoard().getCells();
    }
    @Override
    public Player getPlayer(){
        return mediator.getCurrentBoard().getPlayer();
    }
    
    public abstract void execute();

    public boolean checkWinner() {
        System.out.println("hey");
        Cell[][] temp = mediator.getCurrentBoard().getCells();
        for (int i = 0; i<3; i++)
            if (match(temp[i][0],temp[i][1],temp[i][2]))
                return true;
        for (int i = 0; i<3; i++)
            if (match(temp[0][i],temp[1][i],temp[2][i]))
                return true;
        if (match(temp[0][0],temp[1][1],temp[2][2]))
            return true;
        return match(temp[0][2],temp[1][1],temp[2][0]);
    }

    private boolean match(Cell cell, Cell cell0, Cell cell1) {
        if (cell.getSimpleState().equalsIgnoreCase("Empty"))
            return false;
        return (cell.getSimpleState().equals(cell0.getSimpleState()) && cell.getSimpleState().equals(cell1.getSimpleState()));
            
    }

    public boolean checkEnd() {
        Cell[][] temp = mediator.getCurrentBoard().getCells();
        for (int i = 0; i<3; i++)
            for (int j = 0; j<3; j++)
                if (temp[i][j].getSimpleState().equals("Empty"))
                    return false;
        return true;     
    }
    
    
}
