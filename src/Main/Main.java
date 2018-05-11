/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.Engine;

/**
 *
 * @author Abd El Rahman
 */
public class Main {
    
    public static void main(String[] args) {
        Engine engine = Engine.getInstance();
        engine.runGame();
    }
    
}
