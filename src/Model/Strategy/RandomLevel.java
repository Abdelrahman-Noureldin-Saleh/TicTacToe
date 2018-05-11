/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Strategy;

import Model.State.Cell;
import java.util.Random;

/**
 *
 * @author Abd El Rahman
 */
public class RandomLevel extends Level {

    Random random = new Random();

    @Override
    public void execute() { // continue ??
        Cell c = mediator.getCurrentBoard().getCells()[random.nextInt(3)][random.nextInt(3)];
                if (!c.Fill(mediator.getCurrentBoard().getPlayer())) {
                    this.execute();
                } else {
                    c.Fill(mediator.getCurrentBoard().getPlayer());
                }
    }
}
