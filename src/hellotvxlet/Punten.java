/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author student
 */
public class Punten {
    public static int punten = 0;
    
    public void takePunt(){
        this.punten++;
    }
    
    public void paintScore(Graphics g){
        g.setColor(Color.WHITE);
        g.drawString("Score", 500, 60);
        g.drawString(String.valueOf(punten), 500, 120);
    }
}
