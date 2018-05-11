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
            
public abstract class State {
    
    public abstract boolean Fill(Player player,Cell cell);
    
    public abstract String getName();
    
    public static boolean isX(State state){
        return (state instanceof XState);
    }
    
    public static boolean isO(State state){
        return (state instanceof OState);
    }
    
    public boolean isEmpty(State state){
        return (state instanceof EmptyState);
    }
    
    public static State getX(){
        return XState.getInstance();
    }
    
    public static State getO(){
        return OState.getInstance();
    }
    
    public static State getEmpty(){
        return EmptyState.getInstance();
    }
}
