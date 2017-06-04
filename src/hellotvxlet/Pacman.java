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
public class Pacman {
    private int x = SPRITE_SIZE;
    private int y = SPRITE_SIZE;
 
    private Punten punten;
    
    public int hoek=30;
    public boolean bekopen = true;
    
    public int r=1;
    
    public int px=SPRITE_SIZE*1;
    public int py=SPRITE_SIZE*1;
    public int rotation = 90;
   
    
    public static int SPRITE_SIZE=16;
    
    public Pacman(){
        this.punten = new Punten();
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void incrementY(int number){
        this.y = this.y + number;
    }
    
    public void incrementX(int number){
        this.x = this.x + number;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public boolean hasCollided(String direction){
        String[] veld = PacmanVeld.veld;
        
        int veldX = (int) Math.round((double)this.x / (double)Pacman.SPRITE_SIZE);
        int veldY = (int) Math.round((double)this.y / (double)Pacman.SPRITE_SIZE);    
        
        
        
        if(veldX == 0 || veldY == 0){
            return true;
        }
        
        if(direction.equals("left") && veld[veldY].charAt(veldX - 1) == '-'){
            this.setX(veldX * Pacman.SPRITE_SIZE);
            this.setY(veldY * Pacman.SPRITE_SIZE);
            if(veldY * Pacman.SPRITE_SIZE != this.getY() || veldX * Pacman.SPRITE_SIZE != this.getX()){
                return false;
            }
            return true;
        }
        
        if(direction.equals("right") && veld[veldY].charAt(veldX + 1) == '-'){
            this.setX(veldX * Pacman.SPRITE_SIZE);
            this.setY(veldY * Pacman.SPRITE_SIZE);
            if(veldY * Pacman.SPRITE_SIZE != this.getY() || veldX * Pacman.SPRITE_SIZE != this.getX()){
                return false;
            }
            return true;
        }
        
        if(direction.equals("up") && veld[veldY - 1].charAt(veldX) == '-'){
            this.setX(veldX * Pacman.SPRITE_SIZE);
            this.setY(veldY * Pacman.SPRITE_SIZE);
            if(veldY * Pacman.SPRITE_SIZE != this.getY() || veldX * Pacman.SPRITE_SIZE != this.getX()){
                return false;
            }
            return true;
        }
        
        if(direction.equals("down") && veld[veldY + 1].charAt(veldX) == '-'){
            this.setX(veldX * Pacman.SPRITE_SIZE);
            this.setY(veldY * Pacman.SPRITE_SIZE);
            if(veldY * Pacman.SPRITE_SIZE != this.getY() || veldX * Pacman.SPRITE_SIZE != this.getX()){
                return false;
            }
            return true;
        }
        
        if(veld[veldY].charAt(veldX) == '*'){
            punten.takePunt();
  
            char[] newVeld = veld[veldY].toCharArray();
            newVeld[veldX] = ',';
            
            veld[veldY] = String.valueOf(newVeld);            
        }
        
        return false;
    }
    
    public void paintPacman(Graphics g){
        g.setColor(Color.YELLOW);
        

        int rot = 90 * (r - 1);
       
        g.fillArc(x, y, Pacman.SPRITE_SIZE, Pacman.SPRITE_SIZE, this.rotation + hoek , 360 - hoek  * 2);
   
  
        
    }
    
    public void move(HComponent context, String direction, int position){
        
        if(hoek == 0){
            bekopen = true;
        }else if(hoek == 40){
            bekopen = false;
        }
        
        if(bekopen){
            hoek = hoek + 10;
        }else{
            hoek = hoek - 10;
        }
        
        if(direction.equals("left")){
            this.setX(this.getX() - position);
            this.rotation = 180;
        }
        
        if(direction.equals("right")){
            this.setX(this.getX() + position);
            this.rotation = 0;
        }

        if (direction.equals("up")) {
            this.setY(this.getY() - position);
            this.rotation = 90;
        }
        
        if (direction.equals("down")) {
            this.setY(this.getY() + position);
            this.rotation = 260;
        }
        
        context.repaint();
        
    }
   
    
}
