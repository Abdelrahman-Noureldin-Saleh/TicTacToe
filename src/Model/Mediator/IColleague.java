/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Mediator;

import Model.State.Cell;
import Model.State.Player;

/**
 *
 * @author Abd El Rahman
 */
public interface IColleague {
    
  public Cell[][] getCells();
  public Player getPlayer();
    
}
