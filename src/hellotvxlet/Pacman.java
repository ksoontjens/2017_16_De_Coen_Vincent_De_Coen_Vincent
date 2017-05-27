/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Pacman {
    private int x;
    private int y;
    private Image pacman;
    
    public int hoek=30;
    public int r=1;
    public boolean bekopen=true;
    
    public int px=SPRITE_SIZE*1;
    public int py=SPRITE_SIZE*1;
    
    public static int SPRITE_SIZE=15;
    
    public Pacman(Image image){
        this.pacman = image;
    }
    
    public Image getImage(){
        return this.pacman;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public boolean hasCollided(){
        return false;
    }
    
    public void paintPacman(Graphics g){
        g.setColor(Color.YELLOW);
    
        int rot = 90 * (r - 1);
        if (bekopen) {
            g.fillArc(x, y, Pacman.SPRITE_SIZE, Pacman.SPRITE_SIZE, rot + hoek, 360 - hoek * 2);
        } else {
            g.fillArc(x, y, Pacman.SPRITE_SIZE, Pacman.SPRITE_SIZE, 0, 360);
        }
    }
    
    public void move(HComponent context, char direction, int position){
        
        if(direction == 'x'){
            this.setX(this.getX() + position);
            
            context.repaint();
        }

        if (direction == 'y') {
            this.setY(this.getY() + position);
            context.repaint();
        }
        
    }
   
    
}
