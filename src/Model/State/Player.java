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
public class Player {
    
    private State state;

    public Player() {
        this.state = XState.getInstance();
    }

    public State getState() {
        return state;
    }

    public String getSimpleState(){
        return state.getName();
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    @Override
    public Player clone(){
        Player clone = new Player();
        clone.setState(this.state);
        return clone;
    }
    
    
}
