/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Strategy;

import Model.State.Cell;
import Model.State.State;
import java.util.Random;

/**
 *
 * @author Abd El Rahman
 */
public class SmartLevel extends Level{

    @Override
    public void execute() {
        boolean h, v, d;
        h = checkHorizontal();
        if (!h) {
            v = checkVertical();
            if (!v) {
                d = checkDiagonal();
                if (!d) {
                    this.executeD();

                }
            }
        }
    }
    private boolean checkHorizontal() {
        boolean r = false;
        for (int i = 0; i < 3; i++) {

            if (State.isO(mediator.getCurrentBoard().getCells()[i][0].getState()) && State.isO(mediator.getCurrentBoard().getCells()[i][1].getState()) && mediator.getCurrentBoard().getCells()[i][2].Fill(mediator.getCurrentBoard().getPlayer())) {
                r = true;
                break;
            } else if (State.isO(mediator.getCurrentBoard().getCells()[i][0].getState()) && State.isO(mediator.getCurrentBoard().getCells()[i][2].getState()) && mediator.getCurrentBoard().getCells()[i][1].Fill(mediator.getCurrentBoard().getPlayer())) {
                r = true;
                break;
            } else if (State.isO(mediator.getCurrentBoard().getCells()[i][1].getState()) && State.isO(mediator.getCurrentBoard().getCells()[i][2].getState()) && mediator.getCurrentBoard().getCells()[i][0].Fill(mediator.getCurrentBoard().getPlayer())) {
                r = true;
                break;
            }

        }
        return r;
    }

    private boolean checkVertical() {
        boolean r = false;
        outerLoop:
        for (int i = 0; i < 3; i++) {

            if (State.isO(mediator.getCurrentBoard().getCells()[0][i].getState()) && State.isO(mediator.getCurrentBoard().getCells()[1][i].getState()) && mediator.getCurrentBoard().getCells()[2][i].Fill(mediator.getCurrentBoard().getPlayer())) {
                r = true;
                break;

            } else if (State.isO(mediator.getCurrentBoard().getCells()[0][i].getState()) && State.isO(mediator.getCurrentBoard().getCells()[2][i].getState()) && mediator.getCurrentBoard().getCells()[1][i].Fill(mediator.getCurrentBoard().getPlayer())) {
                r = true;
                break;

            } else if (State.isO(mediator.getCurrentBoard().getCells()[1][i].getState()) && State.isO(mediator.getCurrentBoard().getCells()[2][i].getState()) && mediator.getCurrentBoard().getCells()[0][i].Fill(mediator.getCurrentBoard().getPlayer())) {
                r = true;
                break;

            }

        }
        return r;
    }

    private boolean checkDiagonal() {

        boolean r = false;

        if (State.isO(mediator.getCurrentBoard().getCells()[0][0].getState()) && State.isO(mediator.getCurrentBoard().getCells()[1][1].getState()) && mediator.getCurrentBoard().getCells()[2][2].Fill(mediator.getCurrentBoard().getPlayer())) {
            r = true;
        } else if (State.isO(mediator.getCurrentBoard().getCells()[0][0].getState()) && State.isO(mediator.getCurrentBoard().getCells()[2][2].getState()) && mediator.getCurrentBoard().getCells()[1][1].Fill(mediator.getCurrentBoard().getPlayer())) {
            r = true;
        } else if (State.isO(mediator.getCurrentBoard().getCells()[1][1].getState()) && State.isO(mediator.getCurrentBoard().getCells()[2][2].getState()) && mediator.getCurrentBoard().getCells()[0][0].Fill(mediator.getCurrentBoard().getPlayer())) {
            r = true;
        }

        return r;
    }

    //defensive
    private void executeD() {
        boolean h, v;
        h = checkHorizontal1();
        if (!h) {
            v = checkVertical1();
            if (!v) {
                Random random = new Random();
                Cell c = mediator.getCurrentBoard().getCells()[random.nextInt(3)][random.nextInt(3)];
                if (!c.Fill(mediator.getCurrentBoard().getPlayer())) {
                    this.execute();
                } else {
                    c.Fill(mediator.getCurrentBoard().getPlayer());
                }

            }
        }

    }

    private boolean checkHorizontal1() {

        boolean r = false;
        for (int i = 0; i < 3; i++) {

            if ((State.isX(mediator.getCurrentBoard().getCells()[i][0].getState()) || State.isX(mediator.getCurrentBoard().getCells()[i][1].getState())) && mediator.getCurrentBoard().getCells()[i][2].Fill(mediator.getCurrentBoard().getPlayer())) {
                r = true;
                break;
            } else if ((State.isX(mediator.getCurrentBoard().getCells()[i][0].getState()) || State.isX(mediator.getCurrentBoard().getCells()[i][2].getState())) && mediator.getCurrentBoard().getCells()[i][1].Fill(mediator.getCurrentBoard().getPlayer())) {
                r = true;
                break;
            } else if ((State.isX(mediator.getCurrentBoard().getCells()[i][1].getState()) || State.isX(mediator.getCurrentBoard().getCells()[i][2].getState())) && mediator.getCurrentBoard().getCells()[i][0].Fill(mediator.getCurrentBoard().getPlayer())) {
                r = true;
                break;
            }

        }
        return r;
    }

    private boolean checkVertical1() {
        boolean r = false;
        for (int i = 0; i < 3; i++) {
            if ((State.isX(mediator.getCurrentBoard().getCells()[0][i].getState()) || State.isX(mediator.getCurrentBoard().getCells()[1][i].getState())) && mediator.getCurrentBoard().getCells()[2][i].Fill(mediator.getCurrentBoard().getPlayer())) {
                r = true;
                break;
            } else if ((State.isX(mediator.getCurrentBoard().getCells()[0][i].getState()) || State.isX(mediator.getCurrentBoard().getCells()[2][i].getState())) && mediator.getCurrentBoard().getCells()[1][i].Fill(mediator.getCurrentBoard().getPlayer())) {
                r = true;
                break;
            } else if ((State.isX(mediator.getCurrentBoard().getCells()[1][i].getState()) || State.isX(mediator.getCurrentBoard().getCells()[2][i].getState())) && mediator.getCurrentBoard().getCells()[0][i].Fill(mediator.getCurrentBoard().getPlayer())) {
                r = true;
                break;
            }
        }
        return r;
    }
    
}
