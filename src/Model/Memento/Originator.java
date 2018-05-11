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
public class Originator {
 
    private GameBoard baord;

   public void setState(GameBoard board){
      this.baord = board;
   }

   public GameBoard getState(){
      return baord;
   }

   public Memento saveStateToMemento(){
      return new Memento(baord);
   }

   public void getStateFromMemento(Memento memento){
      baord = memento.getBoard();
   }
    
}
