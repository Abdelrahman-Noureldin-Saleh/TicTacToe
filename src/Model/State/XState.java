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
public class XState extends State{

    private static State Singleton = null;
    private XState() {}
    
    public static State getInstance(){
        if (Singleton == null)
            Singleton = new XState();        
        return Singleton;
    }
    
    @Override
    public boolean Fill(Player player,Cell cell) {  return false;  }

    @Override
    public String getName() {
        return "X";
    }
    
}
