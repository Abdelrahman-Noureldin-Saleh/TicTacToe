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
public class EmptyState extends State {

    private static State singleton = null;

    private EmptyState() { }

    public static State getInstance() {
        if (singleton == null) {
            singleton = new EmptyState();
        }
        return singleton;
    }
    
    @Override
    public boolean Fill(Player player,Cell cell) {
        cell.setState(player.getState());
        player.setState(player.getState() instanceof XState ? OState.getInstance() : XState.getInstance() );
        return true;
    }

    @Override
    public String getName() {
        return "Empty";
    }

}
