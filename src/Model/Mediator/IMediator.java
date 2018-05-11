/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Mediator;

import Model.Memento.GameBoard;

/**
 *
 * @author Abd El Rahman
 */
public interface IMediator {
    
    public GameBoard getCurrentBoard();
    public void undo();
    public void redo();
    public void save(GameBoard board);
    
}
