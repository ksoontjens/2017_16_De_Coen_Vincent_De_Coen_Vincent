/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

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
