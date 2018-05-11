/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Memento.CareTaker;
import Model.Memento.Originator;
import Model.Strategy.DefensiveLevel;
import Model.Strategy.Level;
import Model.Strategy.MultiplayerLevel;
import Model.Strategy.RandomLevel;
import Model.Strategy.SmartLevel;
import View.View;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import view.FirstFrame;

/**
 *
 * @author Abd El Rahman
 */
public class Engine {

    private Level game;
    private View view;
    private FirstFrame firstFrame;
    private Originator originator;
    private CareTaker careTaker;

    private static Engine singletone = null;

    private Engine() {
    }

    public static Engine getInstance() {
        if (singletone == null) {
            singletone = new Engine();
        }
        return singletone;
    }

    public void runGame() {
        firstFrame = new FirstFrame();
        firstFrame.getRandomLevelButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomButtonActionPerformed(evt);
            }
        });
        firstFrame.getDefensiveLevelButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defensiveButtonActionPerformed(evt);
            }
        });
        firstFrame.getSmartLevelButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smartButtonActionPerformed(evt);
            }
        });
        firstFrame.getMultiplayerLevelButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiplayerButtonActionPerformed(evt);
            }
        });

        game = new RandomLevel();
        originator = new Originator();
        careTaker = new CareTaker();
        firstFrame.setLocationRelativeTo(null);
        firstFrame.setVisible(true);
    }

    public void Run() {

        view = new View();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.getLoadButton().setEnabled(false);
        view.getUndoButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });
        view.getRedoButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoButtonActionPerformed(evt);
            }
        });
        view.getSaveButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        view.getLoadButton().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        view.getButton0().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button0ActionPerformed(evt);
            }
        });
        view.getButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        view.getButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        view.getButton3().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        view.getButton4().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        view.getButton5().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        view.getButton6().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        view.getButton7().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        view.getButton8().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        updateView();
        game.save();
    }

    private void updateView() {
        view.updateTurn(game.getPlayer().getSimpleState());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                view.updateCell(i, j, game.getCells()[i][j].getSimpleState());
            }
        }
    }

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        game.undo();
        updateView();
    }

    private void redoButtonActionPerformed(ActionEvent evt) {
        game.redo();
        updateView();
    }

    private void saveButtonActionPerformed(ActionEvent evt) {
        originator.setState(game.getGameBoard().clone());
        careTaker.update(originator.saveStateToMemento());
        view.getLoadButton().setEnabled(true);
    }

    private void loadButtonActionPerformed(ActionEvent evt) {
        originator.getStateFromMemento(careTaker.get());
        game.updateGameBoard(originator.getState());
        updateView();

    }

    private void continueGame(boolean played) {
        if (played) {
            updateView(); // Refresh the GUI
            if (game.checkWinner()) {
                view.announceWinner(game.getPlayer().getSimpleState().equalsIgnoreCase("O") ? "X" : "O");
                return;
            }
            if (game.checkEnd()) {
                view.announceTie();
                return;
            }
            game.execute(); // Play
            updateView(); // Refresh Again
            game.save();
            if (game.checkWinner()) {
                view.announceWinner(game.getPlayer().getSimpleState().equalsIgnoreCase("O") ? "X" : "O");
                return;
            }
            if (game.checkEnd()) {
                view.announceTie();
                return;
            }
            // Do the Commented part again
        }
    }

    private void button0ActionPerformed(java.awt.event.ActionEvent evt) {
        continueGame(game.playIn(0, 0));
    }

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
        continueGame(game.playIn(0, 1));
    }

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
        continueGame(game.playIn(0, 2));
    }

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {
        continueGame(game.playIn(1, 0));
    }

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {
        continueGame(game.playIn(1, 1));
    }

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {
        continueGame(game.playIn(1, 2));
    }

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {
        continueGame(game.playIn(2, 0));
    }

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {
        continueGame(game.playIn(2, 1));
    }

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {
        continueGame(game.playIn(2, 2));
    }

    private void multiplayerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        game = new MultiplayerLevel();
        firstFrame.setVisible(false);
        Run();
    }

    private void randomButtonActionPerformed(java.awt.event.ActionEvent evt) {
        game = new RandomLevel();
        firstFrame.setVisible(false);
        Run();
    }

    private void defensiveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        game = new DefensiveLevel();
        firstFrame.setVisible(false);
        Run();

    }

    private void smartButtonActionPerformed(java.awt.event.ActionEvent evt) {
        game = new SmartLevel();
        firstFrame.setVisible(false);
        Run();
    }
}
