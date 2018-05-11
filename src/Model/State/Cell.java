/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.State;

/**
 *
 * @author Abd El Rahman
 */
public class Cell {

    private State state;

    public Cell() {
        this.state = EmptyState.getInstance();
    }

    public String getSimpleState(){
        return state.getName();
    }
    
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public boolean Fill(Player player){
        return state.Fill(player,this);
    }
    
    @Override
    public Cell clone() {
        Cell clone = new Cell();
        clone.setState(state);
        return clone;
    }
    
}
