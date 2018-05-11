/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Memento;

/**
 *
 * @author Abd El Rahman
 */
public class Memento {
    
    private final GameBoard snapshot;

    public Memento(GameBoard board) {
        this.snapshot = board;
    }

    public GameBoard getBoard() {
        return snapshot;
    }
    
}
