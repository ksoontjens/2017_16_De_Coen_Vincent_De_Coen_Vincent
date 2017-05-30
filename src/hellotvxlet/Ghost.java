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
public class Ghost {
    
    private int x;
    private int y;
    private Color color;
    private String direction = "up";
    private String[] directions = {};
    
    public Ghost(int veldX, int veldY, Color color){
        this.x = veldX * Pacman.SPRITE_SIZE;
        this.y = veldY * Pacman.SPRITE_SIZE;
        this.color = color;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public void paintGhost(Graphics g){
        g.setColor(this.color);
    
        g.fillRoundRect(this.x, this.y, Pacman.SPRITE_SIZE, Pacman.SPRITE_SIZE, 4, 14);
    }
    
    public void correctCourse(){
        
    }
    
    public boolean hasCollided(){
        String[] veld = PacmanVeld.veld;
        
        int veldX = (int) Math.round((double)this.x / (double)Pacman.SPRITE_SIZE);
        int veldY = (int) Math.round((double)this.y / (double)Pacman.SPRITE_SIZE);        
        
        if(veldX == 0 || veldY == 0){
            correctCourse();
        }
        
        if(this.direction.equals("left") && veld[veldY].charAt(veldX - 1) == '-'){
            this.setX(veldX * Pacman.SPRITE_SIZE);
            this.setY(veldY * Pacman.SPRITE_SIZE);
            
            correctCourse();
        }
        
        if(this.direction.equals("right") && veld[veldY].charAt(veldX + 1) == '-'){
            this.setX(veldX * Pacman.SPRITE_SIZE);
            this.setY(veldY * Pacman.SPRITE_SIZE);
            
            correctCourse();
        }
        
        if(this.direction.equals("up") && veld[veldY - 1].charAt(veldX) == '-'){
            this.setX(veldX * Pacman.SPRITE_SIZE);
            this.setY(veldY * Pacman.SPRITE_SIZE);
            
            correctCourse();
        }
        
        if(this.direction.equals("down") && veld[veldY + 1].charAt(veldX) == '-'){
            this.setX(veldX * Pacman.SPRITE_SIZE);
            this.setY(veldY * Pacman.SPRITE_SIZE);
            
            correctCourse();
        }
        
        return false;
    }
    
    public void move(HComponent context, int position){
        
        if(this.direction.equals("left")){
            this.setX(this.getX() - position);
        }
        
        if(this.direction.equals("right")){
            this.setX(this.getX() + position);
        }

        if(this.direction.equals("up")) {
            this.setY(this.getY() - position);
        }
        
        if(this.direction.equals("down")) {
            this.setY(this.getY() + position);
        }
        
        context.repaint();
        
    }
}
