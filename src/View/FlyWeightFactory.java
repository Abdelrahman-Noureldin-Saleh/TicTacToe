/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author Abd El Rahman
 */
public class FlyWeightFactory {
    
    private static final HashMap<String, ImageIcon> imagesShapes = new HashMap<>();
    
    public static ImageIcon get(String key){
        ImageIcon image = imagesShapes.get(key);
        if (image == null) {
            //imagesShapes.put(key, new javax.swing.ImageIcon(getClass().getResource("/resources/" + key + ".png")));
            imagesShapes.put(key, new javax.swing.ImageIcon("src\\resources\\" + key + ".png"));
            image = imagesShapes.get(key);
        }
        return image;
    }
    
}
