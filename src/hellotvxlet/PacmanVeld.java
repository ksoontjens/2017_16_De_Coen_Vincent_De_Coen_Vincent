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
    
    public int SPRITE_SIZE=15;
    public int px=SPRITE_SIZE*1;
    public int py=SPRITE_SIZE*1;
    
    public int hoek=30;
    public int r=1;
    public boolean bekopen=true;

    public void buildVeld(Graphics g, HComponent context) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 720, 576);
     
        for (int i = 0; i < veld.length; i++) {
            for (int j = 0; j < veld[i].length(); j++) {
                if (veld[i].charAt(j) == '-') {
                    g.setColor(Color.BLUE);
                    g.fillRect(j * SPRITE_SIZE, i * SPRITE_SIZE, 15, 15);
                }else if(veld[i].charAt(j) == ':'){
                    g.setColor(Color.GRAY);
                    g.fillRect(j * SPRITE_SIZE, i * SPRITE_SIZE, 15, 15);
                }else if(veld[i].charAt(j) == '*'){
                    g.setColor(Color.WHITE);
                    g.fillOval(j * SPRITE_SIZE + 5, i * SPRITE_SIZE + 5, 5, 5);
                }else if(veld[i].charAt(j) == 'O'){
                    g.setColor(Color.PINK);
                    g.fillOval(j * SPRITE_SIZE + 3, i * SPRITE_SIZE + 3, 8, 8);
                }
            }
        }

        g.setColor(Color.YELLOW);
    
        int rot = 90 * (r - 1);
        if (bekopen) {
            g.fillArc(px, py, SPRITE_SIZE, SPRITE_SIZE, rot + hoek, 360 - hoek * 2);
        } else {
            g.fillArc(px, py, SPRITE_SIZE, SPRITE_SIZE, 0, 360);
        }
    }
}
