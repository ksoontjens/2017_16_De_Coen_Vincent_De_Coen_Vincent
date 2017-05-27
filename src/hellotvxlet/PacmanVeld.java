/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class PacmanVeld {

    /**
     *  Breedte: 28 Vakken
     *  Hoogte: 32 Vakken
     */
    private String[] veld = {
        "----------------------------",
        "-************--************-",
        "-*----*-----*--*-----*----*-",
        "-O----*-----*--*-----*----O-",
        "-*----*-----*--*-----*----*-",
        "-**************************-",
        "-*----*--*--------*--*----*-",
        "-*----*--*--------*--*----*-",
        "-******--****--****--******-",
        "------*-----*--*-----*------",
        "------*-----*--*-----*------",
        "------*--**********--*------",
        "------*--*---::---*--*------",
        "------*--*-::::::-*--*------",
        "------****-::::::-****------",
        "------*--*-::::::-*--*------",
        "------*--*--------*--*------",
        "------*--**********--*------",
        "------*--*--------*--*------",
        "------*--*--------*--*------",
        "-************--************-",
        "-*----*-----*--*-----*----*-",
        "-*----*-----*--*-----*----*-",
        "-O**--****************--**O-",
        "---*--*--*--------*--*--*---",
        "---*--*--*--------*--*--*---",
        "-******--****--****--******-",
        "-*----------*--*----------*-",
        "-*----------*--*----------*-",
        "-**************************-",
        "----------------------------"
    };    
    
    

    public void buildVeld(Graphics g, HComponent context) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 720, 576);
     
        for (int i = 0; i < veld.length; i++) {
            for (int j = 0; j < veld[i].length(); j++) {
                if (veld[i].charAt(j) == '-') {
                    g.setColor(Color.BLUE);
                    g.fillRect(j * Pacman.SPRITE_SIZE, i * Pacman.SPRITE_SIZE, 15, 15);
                }else if(veld[i].charAt(j) == ':'){
                    g.setColor(Color.GRAY);
                    g.fillRect(j * Pacman.SPRITE_SIZE, i * Pacman.SPRITE_SIZE, 15, 15);
                }else if(veld[i].charAt(j) == '*'){
                    g.setColor(Color.WHITE);
                    g.fillOval(j * Pacman.SPRITE_SIZE + 5, i * Pacman.SPRITE_SIZE + 5, 5, 5);
                }else if(veld[i].charAt(j) == 'O'){
                    g.setColor(Color.PINK);
                    g.fillOval(j * Pacman.SPRITE_SIZE + 3, i * Pacman.SPRITE_SIZE + 3, 8, 8);
                }else if(veld[i].charAt(j) == ','){
                    g.setColor(Color.BLACK);
                    g.fillRect(j * Pacman.SPRITE_SIZE, i * Pacman.SPRITE_SIZE, 15, 15);
                }
            }
        }

    }
}
