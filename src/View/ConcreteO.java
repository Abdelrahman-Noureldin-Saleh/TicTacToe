/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Abd El Rahman
 */
public class ConcreteO {
    
     private final ImageIcon image = FlyWeightFactory.get("Y");

    public JButton operation(JButton button){
        button.setIcon(image);
        return button;
    }
    
   public JLabel operation(JLabel label){
        label.setIcon(image);
        return label;
    }
    
}
