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
public class CareTaker {
    
    Memento board;
    
    public void update(Memento board){
      this.board = board;
   }

   public Memento get(){
      return board;
   }
    
}
