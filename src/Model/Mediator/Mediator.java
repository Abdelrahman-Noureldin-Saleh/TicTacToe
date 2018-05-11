/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Mediator;

import Model.Memento.GameBoard;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author Abd El Rahman
 */
public class Mediator {

    private GameBoard CurrentBoard;
    private final Stack<GameBoard> Undo;
    private final Stack<GameBoard> Redo;

    public Mediator() {
        CurrentBoard = new GameBoard();
        Undo = new Stack<>();
        Redo = new Stack<>();
    }

    public GameBoard getCurrentBoard() {
        return CurrentBoard;
    }

    public void undo() {
        try {
            Redo.push(Undo.pop());
            CurrentBoard = Undo.peek();
        } catch (EmptyStackException ex) {
            System.out.println("Can't Undo Anything");
        }
    }

    public void redo() {
        try {
            Undo.push(Redo.pop());
            CurrentBoard = Undo.peek();
        } catch (EmptyStackException ex){
            System.out.println("Can't Redo Anything");
        }
    }

    public void save() {
            Undo.push(CurrentBoard.clone());
    }

    public void setCurrentBoard(GameBoard CurrentBoard) {
        this.CurrentBoard = CurrentBoard;
    }

}
